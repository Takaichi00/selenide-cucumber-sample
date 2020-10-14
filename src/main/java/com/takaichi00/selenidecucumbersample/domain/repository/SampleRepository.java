package com.takaichi00.selenidecucumbersample.domain.repository;

import com.takaichi00.selenidecucumbersample.integration.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Integer> {
}
