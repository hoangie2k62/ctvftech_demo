package demo.application.services;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.application.dto.WorkAssgin;
import demo.application.entity.LogsEntity;
import demo.application.entity.relationship.WorkAssginEntity;
import demo.application.entity.relationship.WorkAssginKey;
import demo.application.repository.IDFactory;
import demo.application.repository.IRepository;

@Service
public class WorkAssginService extends CrudService<WorkAssginEntity, WorkAssginKey> {

	@Autowired
	private IRepository repository;
	
	@Override
	public boolean createData(WorkAssginEntity entity, String symbol) {

		boolean check = false;

		try {

			repository.begin();

			repository.get().persist(entity);

			// lưu thông tin đã insert vào table Logs trong database;

			LogsEntity logs = createLog("INSERT", entity, entity.getId());

			repository.get().persist(logs);

			repository.commit();

			check = true;

		} catch (Exception ex) {

			ex.printStackTrace();

			repository.rollback();
		} finally {

			repository.close();
		}

		return check;
	}

	@Override
	public boolean updateData(WorkAssginEntity entity, WorkAssginKey id) {

		boolean check = false;

		try {

			repository.begin();

			// Sửa và lưu entity vào table cùng tên trong database.

			repository.get().merge(entity);

			// lưu thông tin đã insert vào table Logs trong database;

			LogsEntity logs = createLog("UPDATE", entity, id);

			repository.get().persist(logs);

			repository.commit();

			check = true;
		} catch (Exception ex) {

			repository.rollback();
		} finally {

			repository.close();
		}
		return check;
	}

	@Override
	public boolean deleteData(Class<WorkAssginEntity> clazz, WorkAssginKey id) {

		boolean check = false;

		try {

			repository.begin();

			String hql = String.format("DELETE FROM %s WHERE employee_id = %s AND office_id = %s AND work_id = %s",
					clazz.getName(), id.getEmployeeId(), id.getOfficeId(), id.getWorkId());

			Query query = repository.get().createQuery(hql);

			query.executeUpdate();

			// Lưu thông tin vào logs.

			LogsEntity log = createLog(clazz, id);

			repository.get().persist(log);

			repository.commit();

			check = true;
		} catch (Exception ex) {

			repository.rollback();
		} finally {

			repository.close();
		}
		return check;
	}

	@Override
	public boolean checkId(String className, WorkAssginKey id) throws Exception {

		String hql = String.format(
				"SELECT * FROM %s e WHERE e.employee_id IN ('%s') AND e.office_id IN('%s') AND e.work_id('%s')",
				className, id.getEmployeeId(), id.getOfficeId(), id.getWorkId());

		Query query = repository.get().createQuery(hql);

		return (query.getResultList() == null) ? false : true;
	}

	public boolean checkId(String className, WorkAssgin workassgin) throws Exception {

		String hql = String.format(
				"SELECT * FROM %s e WHERE e.employee_id IN ('%s') AND e.office_id IN('%s') AND e.work_id('%s')",
				className, workassgin.getEmployeeId(), workassgin.getOfficeId(), workassgin.getWorkId());

		Query query = repository.get().createQuery(hql);

		return (query.getResultList() == null) ? false : true;
	}
	
	@Override
	public IDFactory<WorkAssginKey> getIDFactory() {

		return new IDFactory<WorkAssginKey>() {

			@Override
			public WorkAssginKey createID(IRepository repository, String className, String symbol) {
				// WorkAssginEntityODO Auto-generated method stub
				return null;
			}

		};
	}

}
