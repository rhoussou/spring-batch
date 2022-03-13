package com.cyrol.batch.chunk.fileToDB;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileToDbItemReader extends FlatFileItemReader<SampleEntity> implements ItemReader<SampleEntity>{


    @Value("${header.names}")
    private String names;

    @Value("${line.delimiter}")
    private String delimiter;

    public FileToDbItemReader() {
        // decommenter cette ligne si on veut juste traiter un fichier à la fois
        //setResource(new FileSystemResource("data/input.csv"));
        setLinesToSkip(1);
        setLineMapper(getDefaultLineMapper());
    }

    public DefaultLineMapper<SampleEntity> getDefaultLineMapper() {
        DefaultLineMapper<SampleEntity> defaultLineMapper = new DefaultLineMapper<SampleEntity>();

        DelimitedLineTokenizer delimitedLineTokenizer =new DelimitedLineTokenizer();
        delimitedLineTokenizer.setNames(names);
        delimitedLineTokenizer.setNames(names.split(delimiter));
        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);

        BeanWrapperFieldSetMapper<SampleEntity> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<SampleEntity>();
        beanWrapperFieldSetMapper.setTargetType(SampleEntity.class);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return defaultLineMapper;
    }
}