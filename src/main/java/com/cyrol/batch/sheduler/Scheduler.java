package com.cyrol.batch.sheduler;


import com.cyrol.batch.launcher.BatchLauncher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Scheduler {

    @Autowired
    private BatchLauncher batchLauncher;


    /**
     * Un scheduler (planificateur) a été mis en place pour permettre au batch de s'auto déclencher.
     * Dans cet exemple, le batch une fois lancé s'exécuter toutes les 8 secondes.
     * Vous pouvez jouer avec en changeant la valeur fixedDelayen millisecondes.
     *
     */

    @Scheduled(fixedDelay = 8000)
    public void perform() throws Exception {
        log.info("Batch programm&#xE9; pour tourner toutes les 8 secondes");
        batchLauncher.run();
    }
}