package com.cyrol.batch.chunk.dbToDb;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.item.ItemProcessor;

public class DbToDbItemProcessor implements ItemProcessor<SampleEntity, SampleEntity> {

    @Override
    public SampleEntity process(SampleEntity sampleEntity) throws Exception {
        return null;
    }
}
