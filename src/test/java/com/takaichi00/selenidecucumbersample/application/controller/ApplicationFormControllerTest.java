package com.takaichi00.selenidecucumbersample.application.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.takaichi00.selenidecucumbersample.application.payload.BookForDisplay;
import com.takaichi00.selenidecucumbersample.integration.entity.BookEntity;
import com.takaichi00.selenidecucumbersample.domain.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationFormControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  BookRepository bookRepository;

  @Test
  void トップページにアクセスしたら本の情報が取得できること() throws Exception {

    when(bookRepository.findAll()).thenReturn(Arrays.asList(BookEntity.builder()
                                                                      .id(1)
                                                                      .title("title1")
                                                                      .author("たなか")
                                                                      .build()));

    BookForDisplay book = BookForDisplay.builder()
                                        .title("title1")
                                        .author("たなか")
                                        .build();

    mockMvc.perform(get("/top"))
      .andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.model().attribute("bookList", Arrays.asList(book)))
      .andExpect(view().name("top"));

    verify(bookRepository, times(1)).findAll();

  }

}
