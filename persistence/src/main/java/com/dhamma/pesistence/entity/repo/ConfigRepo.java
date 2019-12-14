package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ConfigRepo extends JpaRepository<Config, Long>, QuerydslPredicateExecutor<Config> {
}
