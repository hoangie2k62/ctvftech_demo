package demo.application.services;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import demo.application.entity.LogsEntity;
import demo.application.repository.IDFactory;
import demo.application.repository.IRepository;

@Service
public class LogsService extends CrudService<LogsEntity, Integer>{

	@Override
	public boolean createData(LogsEntity entity, String symbol) {
		
		return false;
	}
	
	@Override
	public boolean updateData(LogsEntity entity, Integer ID) {
		
		return false;
	}
	
	@Override
	public boolean deleteData(Class<LogsEntity> clazz, Integer ID) {
		
		return false;
	}
	
	@Override
	public IDFactory<Integer> getIDFactory() {
		
		return new IDFactory<Integer>() {

			@Override
			public Integer createID(IRepository repository, String className, String symbol) {
				
				String hql = String.format("SELECT MAX(stt) FROM %s", className);

				Query query = repository.get().createQuery(hql);
				
				return (Integer)query.getResultList().get(0);
			}
			
		};
	}
}
