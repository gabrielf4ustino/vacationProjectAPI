package com.vacation.project.controller;

import com.vacation.project.model.BasicInfoModel;
import com.vacation.project.repository.BasicInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class DefaultController {

    @Autowired
    private BasicInfoRepository basicInfoRepository;

    @QueryMapping
    Iterable<BasicInfoModel> basicInfo() {
        return basicInfoRepository.findAll();
    }

    @QueryMapping
    Optional<List<BasicInfoModel>> basicInfoByStartYear(@Argument String year) {
        return basicInfoRepository.findByStartYear(year, ThreadLocalRandom.current().nextInt(10000, 24852600));
    }
}
