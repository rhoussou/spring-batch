package com.cyrol.batch.config;


import com.cyrol.batch.chunk.dbToDb.DbToDbItemProcessor;
import com.cyrol.batch.chunk.dbToDb.DbToDbItemReader;
import com.cyrol.batch.chunk.dbToDb.DbToDbItemWriter;
import com.cyrol.batch.chunk.dbToFile.DbToFileItemProcessor;
import com.cyrol.batch.chunk.dbToFile.DbToFileItemReader;
import com.cyrol.batch.chunk.dbToFile.DbToFileItemWriter;
import com.cyrol.batch.chunk.fileToDB.FileToDbItemProcessor;
import com.cyrol.batch.chunk.fileToDB.FileToDbItemReader;
import com.cyrol.batch.chunk.fileToDB.FileToDbItemWriter;
import com.cyrol.batch.model.SampleEntity;
import com.cyrol.batch.task.MyTaskOne;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MyTaskOne myTaskOne;


    @Autowired
    private FileToDbItemReader fileToDbItemReader;

    @Autowired
    private FileToDbItemWriter fileToDbItemWriter;

    @Autowired
    private FileToDbItemProcessor fileToDbItemProcessor;


    @Autowired
    private DbToFileItemReader dbToFileItemReader;

    @Autowired
    private DbToFileItemProcessor dbToFileItemProcessor;

    @Autowired
    private DbToFileItemWriter dbToFileItemWriter;


    @Autowired
    private DbToDbItemWriter dbToDbItemWriter;

    @Autowired
    private DbToDbItemProcessor dbToDbItemProcessor;

    @Autowired
    private DbToDbItemReader dbToDbItemReader;



    @Bean
    public Step taskletStep(){
        return stepBuilderFactory.get("taskletStep")
                .tasklet(myTaskOne)
                //.listener(new StepListener())
                .build();
    }


    /**
     * chunkSize 20 design le commit interval.
     * c'est à dire le nombre de item lus par le reader et traité par le processor avant de passer au writer
     */
    @Bean
    public Step fileToDbChunkStep() {
        return stepBuilderFactory.get("fileToDbChunkStep")
                .<SampleEntity, SampleEntity>chunk(20) //
                .reader(reader())
                .processor(fileToDbItemProcessor)
                .writer(fileToDbItemWriter)
                //.listener(new StepListener())
                .build();
    }


    @Bean
    public Step dbToFileChunkStep() {
        return stepBuilderFactory.get("dbToFileChunkStep")
                .<SampleEntity, SampleEntity>chunk(20) //
                .reader(dbToFileItemReader)
                .processor(dbToFileItemProcessor)
                .writer(dbToFileItemWriter)
                //.listener(new StepListener())
                .build();
    }


    @Bean
    public Step dbToDbChunkStep() {
        return stepBuilderFactory.get("dbToDbChunkStep")
                .<SampleEntity, SampleEntity>chunk(20) //
                .reader(dbToDbItemReader)
                .processor(dbToDbItemProcessor)
                .writer(dbToDbItemWriter)
                //.listener(new StepListener())
                .build();
    }



    @Bean
    public Job demoReportJob() {
        return jobBuilderFactory.get("demoReportJob")
                //.listener(new JobListener())
                .start(taskletStep())
                .next(fileToDbChunkStep())
                .next(dbToFileChunkStep())
                .next(dbToDbChunkStep())
                .build();
    }



    @Bean
    public ItemReader<SampleEntity> reader() {
        Resource[] resources = null;
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            resources = patternResolver.getResources("file:./data/*.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        MultiResourceItemReader<SampleEntity> reader = new MultiResourceItemReader<>();
        reader.setResources(resources);
        reader.setDelegate(fileToDbItemReader);
        return reader;
    }

}
