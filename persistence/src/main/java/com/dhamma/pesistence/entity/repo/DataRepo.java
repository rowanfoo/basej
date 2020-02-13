package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.CoreData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepo extends JpaRepository<CoreData, Long>, QuerydslPredicateExecutor<CoreData> {

//    @Query("SELECT u FROM CoreData u WHERE u.code= ?1  order by u.date desc limit 14 offset ?2")
//    List<CoreData> findbyCodeOffset(String code, Integer offset);

//    @Query("SELECT u FROM CoreData u")
//    List<CoreData> findbyCodeOffset();


//    @Query(value = "SELECT u FROM CoreData u where u.code=?1 order by u.date desc  limit 14")
//    List<CoreData> findbyCodeOffset(String code);

    @Query(value = "SELECT * FROM Core_Data u where u.code=?1 order by u.date desc limit 14 offset ?2 ", nativeQuery = true)
    List<CoreData> findbyCodeOffset(String code, Integer offset);

}
//select  * from core_data cd where cd.code='BHP.AX' order by date desc limit 14 offset 1