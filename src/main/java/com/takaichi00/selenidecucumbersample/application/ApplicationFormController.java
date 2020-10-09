package com.takaichi00.selenidecucumbersample.application;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.takaichi00.selenidecucumbersample.integration.BookEntity;
import com.takaichi00.selenidecucumbersample.integration.BookRepository;
import com.takaichi00.selenidecucumbersample.integration.SampleRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class ApplicationFormController {

  @Autowired
  SampleRepository sampleRepository;

  @Autowired
  BookRepository bookRepository;

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
                                        .build());
    }

    model.addAttribute("bookList", bookForDisplays);
    return "top";
  }

}
