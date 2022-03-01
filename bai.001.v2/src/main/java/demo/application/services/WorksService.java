package demo.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.application.entity.WorksEntity;
import demo.application.repository.WorksRepository;

@Service
public class WorksService extends MyServices<WorksEntity, String>{

	@SuppressWarnings("unused")
	@Autowired
	private WorksRepository repository;

}
