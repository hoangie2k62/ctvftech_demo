package demo.application.repository;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class DefaultIDFactory implements IDFactory<String>{

	@Override
	public String createID(IRepository repository, String className, String symbol) {
		
		String hql = String.format("SELECT MAX(stt) FROM %s", className);
		
		Query query = repository.get().createQuery(hql);
		
		String max = (String)query.getSingleResult();
		
		String id = symbol + max;
		
		return id;
	}

}
