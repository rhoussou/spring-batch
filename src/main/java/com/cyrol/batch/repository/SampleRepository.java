package com.cyrol.batch.repository;

import com.cyrol.batch.model.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity,Long> {
}
