package it.nttdata.myschool.repository;

import org.springframework.data.repository.CrudRepository;

import it.nttdata.myschool.model.SchoolClass;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long>{
    
}
