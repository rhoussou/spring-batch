package com.cyrol.batch.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListener implements JobExecutionListener {

    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Called beforeJob().");
    }

    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED ) {
            //job success
        }
        else if (jobExecution.getStatus() == BatchStatus.FAILED) {
            //job failure
        }
    }
}