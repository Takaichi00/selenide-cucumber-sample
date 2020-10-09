package com.takaichi00.selenidecucumbersample.application;

import io.cucumber.messages.internal.com.google.protobuf.Internal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationFormControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void トップページにアクセスしたら本の情報が取得できること() throws Exception {

    BookForDisplay book = BookForDisplay.builder().title("title1").build();
    BookListForDisplay expectedBookList = BookListForDisplay.builder().bookListForDisplays(Arrays.asList(book)).build();

    mockMvc.perform(get("/top"))
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.model().attribute("bookList", expectedBookList))
      .andExpect(view().name("top"));
  }

}
