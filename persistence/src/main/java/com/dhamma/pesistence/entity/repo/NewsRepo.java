package com.dhamma.pesistence.entity.repo;

import com.dhamma.pesistence.entity.data.News;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsRepo extends PagingAndSortingRepository<News, Long>, QuerydslPredicateExecutor<News> {
}
