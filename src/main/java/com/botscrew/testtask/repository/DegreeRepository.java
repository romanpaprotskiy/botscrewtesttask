package com.botscrew.testtask.repository;

import com.botscrew.testtask.domain.enity.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long>, SearchRepository {

    @Query(value = "select d.name from Degree d where d.name like %:template%")
    List<Object> findByNameLike(@Param("template") String template);
}
