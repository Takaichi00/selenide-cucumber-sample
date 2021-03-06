package com.takaichi00.selenidecucumbersample.integration.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String title;
  private String author;
}
