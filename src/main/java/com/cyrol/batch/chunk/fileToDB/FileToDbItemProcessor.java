package com.cyrol.batch.chunk.fileToDB;


import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;


@Component
public class FileToDbItemProcessor implements ItemProcessor<SampleEntity, SampleEntity> {


    @Override
    public SampleEntity process(SampleEntity sampleEntity) throws Exception {
        return null;
    }
}
