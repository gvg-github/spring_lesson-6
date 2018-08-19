package ru.gvg.spring.model;

import java.io.Serializable;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.08.2018.
 */
public class NewsChecker implements Serializable {
    private News news;

    public NewsChecker() {
    }

    public NewsChecker(News news) {
        this.news = news;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
