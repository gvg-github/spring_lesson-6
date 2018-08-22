package ru.gvg.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gvg.spring.controller.NewsController;
import ru.gvg.spring.model.News;
import ru.gvg.spring.service.NewsService;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.08.2018.
 */
public class NewsControllerTest {
    @MockBean
    private NewsController newsController;
    private News post = new News("foo", "bar");

    @Before
    public void setUp() {
        NewsService mockService = mock(NewsService.class);
        newsController = new NewsController();
        when(mockService.getNews(post.getId())).thenReturn(post);
    }

    @Test
    public void getNewsTest() throws Exception {
        News newsActual = newsController.newsGet(post.getId());
        assertTrue(newsActual != null);
        assertTrue(newsActual.getId().equalsIgnoreCase(post.getId()));
    }
}
