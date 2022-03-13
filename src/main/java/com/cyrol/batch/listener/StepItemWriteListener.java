package com.cyrol.batch.listener;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.batch.core.ItemWriteListener;

import java.util.List;

public class StepItemWriteListener implements ItemWriteListener<SampleEntity> {

    @Override
    public void beforeWrite(List<? extends SampleEntity> items) {
        System.out.println("ItemWriteListener - beforeWrite");
    }

    @Override
    public void afterWrite(List<? extends SampleEntity> items) {
        System.out.println("ItemWriteListener - afterWrite");
    }

    @Override
    public void onWriteError(Exception exception, List<? extends SampleEntity> items) {
        System.out.println("ItemWriteListener - onWriteError");
    }
}