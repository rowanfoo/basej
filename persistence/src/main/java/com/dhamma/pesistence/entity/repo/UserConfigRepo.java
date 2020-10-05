package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.UserConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConfigRepo extends JpaRepository<UserConfig, Long>, QuerydslPredicateExecutor<UserConfig> {
}
