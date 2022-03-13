package com.cyrol.batch.chunk.fileToDB;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class FileToDbItemWriter implements ItemWriter<SampleEntity> {


    @Override
    public void write(List<? extends SampleEntity> list) throws Exception {

    }
}