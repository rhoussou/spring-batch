package com.cyrol.batch.listener;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.core.ItemReadListener;


public class StepItemReadListener implements ItemReadListener<SampleEntity> {

    @Override
    public void beforeRead() {
        System.out.println("ItemReadListener - beforeRead");
    }

    @Override
    public void afterRead(SampleEntity item) {
        System.out.println("ItemReadListener - afterRead");
    }

    @Override
    public void onReadError(Exception ex) {
        System.out.println("ItemReadListener - onReadError");
    }
}