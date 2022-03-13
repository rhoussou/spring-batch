package com.cyrol.batch.chunk.dbToDb;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.item.ItemWriter;
import java.util.List;

public class DbToDbItemWriter implements ItemWriter<SampleEntity> {

    @Override
    public void write(List<? extends SampleEntity> list) throws Exception {

    }
}
