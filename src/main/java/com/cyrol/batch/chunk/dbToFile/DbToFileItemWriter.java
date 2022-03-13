package com.cyrol.batch.chunk.dbToFile;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;


public class DbToFileItemWriter extends FlatFileItemWriter<SampleEntity> {

    public DbToFileItemWriter() {
        setResource(new FileSystemResource("data/output.csv"));
        setLineAggregator(getDelimitedLineAggregator());
    }

    public DelimitedLineAggregator<SampleEntity> getDelimitedLineAggregator() {
        BeanWrapperFieldExtractor<SampleEntity> beanWrapperFieldExtractor = new BeanWrapperFieldExtractor<SampleEntity>();
        beanWrapperFieldExtractor.setNames(new String[] {"id", "name", "salary"});

        DelimitedLineAggregator<SampleEntity> delimitedLineAggregator = new DelimitedLineAggregator<SampleEntity>();
        delimitedLineAggregator.setDelimiter(",");
        delimitedLineAggregator.setFieldExtractor(beanWrapperFieldExtractor);
        return delimitedLineAggregator;

    }
}