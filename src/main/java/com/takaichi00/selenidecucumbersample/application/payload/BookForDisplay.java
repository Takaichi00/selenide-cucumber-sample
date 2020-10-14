package com.takaichi00.selenidecucumbersample.application.payload;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class BookForDisplay {
  private String title;
  private String author;
}
