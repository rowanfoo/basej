package com.dhamma.pesistence.service;

import com.dhamma.pesistence.entity.data.Fundamental;
import com.dhamma.pesistence.entity.data.QFundamental;
import com.dhamma.pesistence.entity.repo.FundamentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FundamentalService {

    @Autowired
    FundamentalRepo fundamentalRepo;

    public Iterable<Fundamental> codes(List<String> codes) {
        return fundamentalRepo.findAll(QFundamental.fundamental.code.in(codes));
    }

    public Fundamental code(String code) {
        return fundamentalRepo.findOne(QFundamental.fundamental.code.eq(code)).get();
    }

}
