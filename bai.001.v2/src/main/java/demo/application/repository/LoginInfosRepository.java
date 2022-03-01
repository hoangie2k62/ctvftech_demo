package demo.application.repository;

import org.springframework.stereotype.Repository;

import demo.application.entity.LoginInfosEntity;

@Repository
public interface LoginInfosRepository extends IRepository<LoginInfosEntity, String>{

}
