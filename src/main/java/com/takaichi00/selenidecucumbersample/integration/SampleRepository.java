package com.takaichi00.selenidecucumbersample.integration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Integer> {
}
