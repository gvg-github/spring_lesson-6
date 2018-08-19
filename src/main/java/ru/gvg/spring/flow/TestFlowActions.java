package ru.gvg.spring.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gvg.spring.model.News;
import ru.gvg.spring.service.NewsService;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.08.2018.
 */
@Component
public class TestFlowActions {

    @Autowired
    private NewsService newsService;

    public TestFlowActions() {

    }

    public News getNews(String cap) {
        return newsService.getNews(cap);
    }
}
