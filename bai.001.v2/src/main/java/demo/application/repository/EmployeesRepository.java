package demo.application.repository;

import org.springframework.stereotype.Repository;

import demo.application.entity.EmployeesEntity;

@Repository
public interface EmployeesRepository extends IRepository<EmployeesEntity, String>{

}
