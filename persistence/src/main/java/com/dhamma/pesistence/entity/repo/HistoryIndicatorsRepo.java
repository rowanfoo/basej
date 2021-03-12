package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.HistoryIndicators;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryIndicatorsRepo extends PagingAndSortingRepository<HistoryIndicators, Long>, QuerydslPredicateExecutor<HistoryIndicators> {
}
