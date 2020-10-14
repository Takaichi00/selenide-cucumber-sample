package com.takaichi00.selenidecucumbersample.domain.repository;

import com.takaichi00.selenidecucumbersample.integration.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
