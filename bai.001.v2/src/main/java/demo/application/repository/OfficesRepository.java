package demo.application.repository;

import org.springframework.stereotype.Repository;

import demo.application.entity.OfficesEntity;

@Repository
public interface OfficesRepository extends IRepository<OfficesEntity, String>{

}
