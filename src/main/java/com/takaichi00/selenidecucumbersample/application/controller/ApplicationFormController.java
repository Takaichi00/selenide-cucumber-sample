package com.takaichi00.selenidecucumbersample.application.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.takaichi00.selenidecucumbersample.application.payload.BookForDisplay;
import com.takaichi00.selenidecucumbersample.domain.repository.BookRepository;
import com.takaichi00.selenidecucumbersample.domain.repository.SampleRepository;
import com.takaichi00.selenidecucumbersample.integration.entity.BookEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class ApplicationFormController {

  private final BookRepository bookRepository;

  @RequestMapping(path = "/sample", method = {GET})
  public String showSamplePage() {
    return "sample";
  }

  @RequestMapping(path = "/top", method = {GET})
  public String showTopPage(Model model) {

    List<BookEntity> bookEntities = bookRepository.findAll();

    List<BookForDisplay> bookForDisplays = new ArrayList<>();

    for (BookEntity bookEntity : bookEntities) {
      bookForDisplays.add(BookForDisplay.builder()
                                        .title(bookEntity.getTitle())
                                        .author(bookEntity.getAuthor())
                                        .build());
    }

    model.addAttribute("bookList", bookForDisplays);
    return "top";
  }

}
