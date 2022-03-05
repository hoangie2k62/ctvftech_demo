package demo.application.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import demo.application.attributes.SessionATT;
import demo.application.entity.LogsEntity;
import demo.application.repository.IDFactory;
import demo.application.repository.IRepository;

public abstract class CrudService<T, ID> implements IService<T, ID> {

	@Autowired
	private IRepository repository;

	@Autowired
	private HttpSession session;

	@SuppressWarnings({ "rawtypes", "unused" })
	@Autowired
	private IDFactory idFactory;

	// Trả về thể hiện đúng của lớp con IDFactory;
	public abstract IDFactory<ID> getIDFactory();

	@SuppressWarnings("unchecked")
	@Override
	public List<T> readData(String className, int page) {

		List<T> list = new ArrayList<>();

		int limit = 10;

		try {

			String hql = String.format("SELECT * FROM %s LIMIT %d, %d", className, (page - 1) * limit, limit);

			Query query = this.getRepository().get().createQuery(hql);

			list = new ArrayList<T>(query.getResultList());

		} catch (Exception ex) {

		} finally {

			this.getRepository().close();
		}

		return list;
	}

	@Override
	public boolean createData(T entity, String symbol) {

		boolean check = false;

		try {

			this.getRepository().begin();

			// tạo id vì không cho người dùng tự ý tạo.

			ID id = getIDFactory().createID(this.getRepository(), entity.getClass().getName(), symbol);

			// Lưu entity vào table cùng tên trong database.

			@SuppressWarnings("unchecked")
			Class<T> clazz = (Class<T>) entity.getClass();

			Method method = clazz.getMethod("setId", id.getClass());

			method.invoke(entity, id);

			this.getRepository().get().persist(entity);

			// lưu thông tin đã insert vào table Logs trong database;

			LogsEntity logs = createLog("INSERT", entity, id);

			this.getRepository().get().persist(logs);

			this.getRepository().commit();

			check = true;

		} catch (Exception ex) {

			ex.printStackTrace();

			this.getRepository().rollback();
		} finally {

			this.getRepository().close();
		}

		return check;
	}

	@Override
	public boolean updateData(T entity, ID id) {

		boolean check = false;

		try {

			this.getRepository().begin();;

			// Sửa và lưu entity vào table cùng tên trong database.

			this.getRepository().get().merge(entity);

			// lưu thông tin đã insert vào table Logs trong database;

			LogsEntity logs = createLog("UPDATE", entity, id);

			this.getRepository().get().persist(logs);

			this.getRepository().commit();

			check = true;
		} catch (Exception ex) {

			this.getRepository().rollback();
		} finally {

			this.getRepository().close();
		}
		return check;
	}

	@Override
	public boolean deleteData(Class<T> clazz, ID id) {

		boolean check = false;

		try {

			this.getRepository().begin();

			String hql = String.format("DELETE FROM %s WHERE id = %s", clazz.getName(), id);

			Query query = this.getRepository().get().createNativeQuery(hql);

			query.executeUpdate();

			// Lưu thông tin vào logs.

			LogsEntity log = createLog(clazz, id);

			this.getRepository().get().persist(log);

			this.getRepository().commit();

			check = true;
		} catch (Exception ex) {

			this.getRepository().rollback();
		} finally {

			this.getRepository().close();
		}
		return check;
	}

	@Override
	public boolean checkId(String className, ID id) throws Exception {

		String hql = String.format("SELECT e.id FROM %s e WHERE e.id IN ('%s')", className, id.toString());

		Query query = this.getRepository().get().createQuery(hql);

		return (query.getResultList() == null) ? false : true;
	}

	@Override
	public LogsEntity createLog(String type, T entity, ID id) throws Exception {

		LogsEntity log = new LogsEntity();

		// lấy tên của bảng thực hiện thêm, xóa, sửa.
		Class<?> clazz = entity.getClass();
		Table table = clazz.getAnnotation(Table.class);
		String tableName = table.name();
		log.setTableName(tableName);

		// lấy thông tin id của thực thể bị thay đổi.
		log.setEntityId(id.toString());

		log.setType(type);

		log.setContents(entity.toString());

		// lấy id người thực hiện thêm, sửa.
		String employeeId = SessionATT.getUserInSession(session).getId();
		log.setEntityId(employeeId);

		return log;
	}

	@Override
	public LogsEntity createLog(Class<T> clazz, ID id) throws Exception {

		LogsEntity log = new LogsEntity();

		// lấy tên của bảng thực hiện thêm, xóa, sửa.
		Table table = clazz.getAnnotation(Table.class);
		String tableName = table.name();
		log.setTableName(tableName);

		// Lấy id thực thể bị thay đổi
		log.setEntityId(id.toString());

		log.setType("DELETE");

		log.setContents(null);

		// lấy id người thực hiện xóa.
		String employeeId = SessionATT.getUserInSession(session).getId();
		log.setEntityId(employeeId);

		return log;
	}

	@Override
	public IRepository getRepository() {

		return repository;
	}
}
