package com.botscrew.testtask.repository;

import com.botscrew.testtask.domain.enity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>,SearchRepository {

    Department findByName(String name);

    @Query(value = "select d.name from Department d where d.name like %:template%")
    List<Object> findByNameLike(@Param("template") String template);
}
