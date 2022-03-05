package demo.application.services;

import java.util.List;

import demo.application.entity.LogsEntity;
import demo.application.repository.IRepository;

public interface IService<T, ID>{

	List<T> readData(String className, int page);
	boolean createData(T entity, String symbol);
	boolean updateData(T entity, ID id);
	boolean deleteData(Class<T> clazz, ID id);
	
	boolean checkId(String className, ID id) throws Exception;
	LogsEntity createLog(String type, T entity, ID id)throws Exception;
	LogsEntity createLog(Class<T> clazz, ID id) throws Exception;
	
	IRepository getRepository();
}
