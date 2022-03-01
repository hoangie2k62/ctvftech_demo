package demo.application.repository;

import org.springframework.stereotype.Repository;

import demo.application.entity.WorksEntity;

@Repository
public interface WorksRepository extends IRepository<WorksEntity, String>{

}
