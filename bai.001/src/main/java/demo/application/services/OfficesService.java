package demo.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.application.entity.OfficesEntity;
import demo.application.repository.DefaultIDFactory;

@Service
public class OfficesService extends CrudService<OfficesEntity, String>{

	@Autowired
	private DefaultIDFactory idFactory;
	
	@Override
	public DefaultIDFactory getIDFactory() {
		// TODO Auto-generated method stub
		return idFactory;
	}

	
}
