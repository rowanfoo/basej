package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.Fundamental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface FundamentalRepo extends JpaRepository<Fundamental, String>, QuerydslPredicateExecutor<Fundamental> {


}
