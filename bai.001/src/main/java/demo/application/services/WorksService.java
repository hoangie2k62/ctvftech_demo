package demo.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.application.entity.WorksEntity;
import demo.application.repository.DefaultIDFactory;

@Service
public class WorksService extends CrudService<WorksEntity, String>{

	@Autowired
	private DefaultIDFactory idFactory;
	
	@Override
	public DefaultIDFactory getIDFactory() {
		
		return idFactory;
	}
}
