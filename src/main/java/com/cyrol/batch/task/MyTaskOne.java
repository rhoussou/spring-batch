package com.cyrol.batch.task;

import com.cyrol.batch.exception.BatchException;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyTaskOne implements Tasklet {

    /**
     * ce bbatchlet test si il existe dans le repertoire data  des fichiers csv à traiter

     */
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception
    {
        System.out.println("MyTaskOne start..");

        Resource[] resources = null;
        ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        try {
            resources = patternResolver.getResources("file:./data/*.csv");
            if (resources.length == 0) {
                throw new IOException("aucun fichier csv trouvé");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new BatchException(e.getMessage());
        }

        System.out.println("MyTaskOne done..");
        return RepeatStatus.FINISHED;
    }
}
