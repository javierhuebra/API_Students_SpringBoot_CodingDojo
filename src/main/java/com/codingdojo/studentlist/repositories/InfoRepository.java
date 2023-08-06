package com.codingdojo.studentlist.repositories;

import com.codingdojo.studentlist.models.Info;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InfoRepository extends CrudRepository<Info, Long> {
    List<Info> findAll();

    @Query("SELECT i FROM Info i LEFT OUTER JOIN FETCH i.student")
    List<Info> allInfos();
}
