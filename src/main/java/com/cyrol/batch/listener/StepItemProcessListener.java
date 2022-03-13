package com.cyrol.batch.listener;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.core.ItemProcessListener;

public class StepItemProcessListener implements ItemProcessListener<SampleEntity, SampleEntity> {

    @Override
    public void beforeProcess(SampleEntity item) {
        System.out.println("ItemProcessListener - beforeProcess");
    }

    @Override
    public void afterProcess(SampleEntity item, SampleEntity result) {
        System.out.println("ItemProcessListener - afterProcess");
    }

    @Override
    public void onProcessError(SampleEntity item, Exception e) {
        System.out.println("ItemProcessListener - onProcessError");
    }
}