package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.CoreStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepo extends JpaRepository<CoreStock, Long>, QuerydslPredicateExecutor<CoreStock> {

    @Query("SELECT DISTINCT c.category FROM CoreStock c")
    public List<String> category();

    @Query("SELECT DISTINCT c.subcategory FROM CoreStock c")
    public List<String> subcategory();

    @Query("SELECT DISTINCT c.tags FROM CoreStock c")
    public List<String> tags();

}
