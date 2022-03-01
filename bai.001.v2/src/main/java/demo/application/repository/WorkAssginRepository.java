package demo.application.repository;

import org.springframework.stereotype.Repository;

import demo.application.entity.relationship.WorkAssginEntity;
import demo.application.entity.relationship.WorkAssginKey;

@Repository
public interface WorkAssginRepository extends IRepository<WorkAssginEntity, WorkAssginKey>{

}
