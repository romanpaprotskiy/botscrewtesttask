package com.botscrew.testtask.repository;

import com.botscrew.testtask.domain.enity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    @Query(value = "select count (l.id) from Lecturer l join l.departments dep join l.degree de " +
            "where de.id = :degreeId and dep.id = :departmentId")
    int countByDegreeAndDepartmentIn(@Param("degreeId") Long degreeId,@Param("departmentId") Long departmentId);
}
