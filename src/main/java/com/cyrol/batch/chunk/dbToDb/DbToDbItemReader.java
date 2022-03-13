package com.cyrol.batch.chunk.dbToDb;

import com.cyrol.batch.model.SampleEntity;
import com.cyrol.batch.repository.SampleRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;


@Component
public  class DbToDbItemReader implements ItemReader<SampleEntity> {

    @Autowired
    private SampleRepository repository;

    private List<SampleEntity> transactions;

    private int index;

    @PostConstruct
    public void init() {
        transactions = repository.findAll();
        index = 0;
    }

    @Override
    public SampleEntity read() throws Exception {
        SampleEntity entity = null;
        if (transactions != null && transactions.size() > index) {
            entity = transactions.get(index);
            index++;
        }
        return entity;
    }

}