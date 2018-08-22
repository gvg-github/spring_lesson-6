package ru.gvg.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.gvg.spring.controller.NewsController;
import ru.gvg.spring.model.News;
import ru.gvg.spring.service.NewsService;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.08.2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private NewsService newsService;

    @Test
    public void test() throws Exception {
        given(this.newsService.getNews("news1"))
                .willReturn(new News("news1", "new news1"));
//        this.mvc.perform(get("/news?name={news}","news1")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
    }
}
