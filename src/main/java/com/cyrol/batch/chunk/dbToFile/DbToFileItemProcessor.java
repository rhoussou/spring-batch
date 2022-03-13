package com.cyrol.batch.chunk.dbToFile;


import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.item.ItemProcessor;


public class DbToFileItemProcessor implements ItemProcessor<SampleEntity, SampleEntity> {


    @Override
    public SampleEntity process(SampleEntity sampleEntity) throws Exception {
        return null;
    }
}
