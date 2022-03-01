package demo.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import demo.application.repository.IRepository;


public abstract class MyServices<T, ID> implements IServices<T, ID>{

	@Autowired
	private IRepository<T, ID> repository;
	
	@Override
	public List<T> findPage(int page){
		
		PageRequest pageable = PageRequest.of(page - 1, 10, Sort.by("id").ascending());
		
		List<T> findAll = new ArrayList<>(repository.findAll(pageable).getContent());
		
		return findAll;
	}

	@Override
	public boolean addData(T entity) {
		
		repository.save(entity);
		
		return true;
	}

	@Override
	public boolean updateData(T entity) {

		repository.save(entity);
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteData(String id) {
		
		repository.deleteById((ID) id);
		
		return true;
	}
	
	
	@Override
	public T createId() {
		
		PageRequest pageable = PageRequest.of(0, 1, Sort.by("id").ascending());
		
		List<T> findOne = new ArrayList<>(repository.findAll(pageable).getContent());
		
		if(findOne == null || findOne.isEmpty() ) return null;
		
		return (T) findOne.get(0);
	}
}
