package ru.gvg.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gvg.spring.model.News;
import ru.gvg.spring.service.NewsService;

import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.08.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class IntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ApplicationContext applicationContext;
    @MockBean
    private NewsService newsService;
    private News predefinedNews1 = new News("cap1", "news1");

    @Before
    public void setUp() {
        given(this.newsService.getNews(predefinedNews1.getCap()))
                .willReturn(predefinedNews1);
    }

    @Test
    public void test() {
        assertTrue(applicationContext != null);
    }

    @Test
    public void userControllerTest() {
        ResponseEntity<News> entity =
                restTemplate.getForEntity("/news?name={news}", News.class, "post1");
        assertTrue(entity.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void controllerTest() {
        ResponseEntity<News> entity = restTemplate.getForEntity("/news?name={news}", News.class,
                predefinedNews1.getCap());
        assertTrue(entity.getStatusCode() == HttpStatus.OK);
        News actualPost = entity.getBody();
        assertTrue(actualPost.getCap().equalsIgnoreCase(predefinedNews1.getCap()));
    }

}
