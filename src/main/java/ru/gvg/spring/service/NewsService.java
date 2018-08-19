package ru.gvg.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gvg.spring.model.News;
import ru.gvg.spring.repository.NewsRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.08.2018.
 */
@Component
public class NewsService {

    private List<News> newsList = null;
    private int count = 0;

    @Autowired
    private NewsRepository newsRepository;

    public NewsService() {
    }

    public NewsService(List<News> newsList) {
        this.newsList = newsList;
    }

    public News getNews(String cap) {
        News news = null;
        if (cap != null) {
            for (News item : newsList) {
                if (item.getCap().equals(cap)) {
                    news = item;
                    break;
                }
            }
        }
        return news;
    }

    public News getNews() {
        return newsList.get(count++);
    }
}
