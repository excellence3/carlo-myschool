package it.nttdata.myschool.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.nttdata.myschool.model.SchoolClass;

public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long>{

    @Query(" SELECT s FROM SchoolClass s WHERE s.name = :name ")
    public SchoolClass findSchoolClassBySection(@Param("name") String name);
    
}
