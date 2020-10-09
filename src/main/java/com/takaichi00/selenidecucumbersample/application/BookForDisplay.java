package com.takaichi00.selenidecucumbersample.application;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookForDisplay {
  private String title;
}
