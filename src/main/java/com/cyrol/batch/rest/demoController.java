package com.cyrol.batch.rest;


import com.cyrol.batch.launcher.BatchLauncher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
@Slf4j


/**
 * cet api rest permet de lancer le batch  manuellement
 * sans passer un **scheduler qui va se déclencher en fonction de notre paramétrage
 */


public class demoController {

    @Autowired
    private BatchLauncher batchLauncher;

    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        log.info("Batch demarr&#xE9; &#xE0; la demande");
        return batchLauncher.run();
    }
}