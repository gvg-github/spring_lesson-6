package ru.gvg.spring.repository;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.gvg.spring.model.News;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author Valeriy Gyrievskikh
 * @since 05.08.2018.
 */
@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class NewsRepository {

    private Map<String, News> newsMap = new LinkedHashMap<>();

    @PostConstruct
    private void init() {
        List<String> list = new ArrayList<>();
        list.add("tag1");
        list.add("tag2");
        list.add("tag3");
        merge(new News("Cap1", "This is news 1", list, new Date(), "This is preview 1", 1000));
        merge(new News("Cap2", "This is news 2", list, new Date(), "This is preview 2", 2000));
        merge(new News("Cap3", "This is news 3", list, new Date(), "This is preview 3", 3000));
    }

    public Collection<News> getListNews() {
        return newsMap.values();
    }

    public void merge(News news) {
        if (news == null) return;
        if (news.getId() == null || news.getId().isEmpty()) return;
        ;
        newsMap.put(news.getId(), news);
    }

    public News findOne(String id) {
        if (id == null || id.isEmpty()) return null;
        return newsMap.get(id);
    }

    public void removeNewsById(String id) {
        if (id == null || id.isEmpty()) return;
        newsMap.remove(id);
    }
}
