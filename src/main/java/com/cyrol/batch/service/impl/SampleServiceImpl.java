package com.cyrol.batch.service.impl;

import com.cyrol.batch.model.SampleEntity;
import com.cyrol.batch.repository.SampleRepository;
import com.cyrol.batch.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    SampleRepository sampleRepository;

    @Override
    public void insertInDB(SampleEntity sampleEntity) {

        sampleRepository.save(sampleEntity);

    }
}
