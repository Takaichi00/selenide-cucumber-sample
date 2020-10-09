package com.takaichi00.selenidecucumbersample.application;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookListForDisplay {
  private List<BookForDisplay> bookListForDisplays;
}
