package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.ImageChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageChartRepo extends JpaRepository<ImageChart, Long>, QuerydslPredicateExecutor<ImageChart> {
}
