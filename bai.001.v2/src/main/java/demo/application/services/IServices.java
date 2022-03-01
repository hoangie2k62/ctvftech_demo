package demo.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IServices <T, ID>{
	
	List<T> findPage(int page);
	boolean addData(T entity);
	boolean updateData(T entity); 
	boolean deleteData(String id);
	
	T createId();
}
