package ru.gvg.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gvg.spring.model.News;
import ru.gvg.spring.repository.NewsRepository;

import java.util.Map;

/**
 * @author Valeriy Gyrievskikh
 * @since 05.08.2018.
 */
@Controller
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @RequestMapping(value = {"/news-list"}, method = RequestMethod.GET)
    public String newsList(Map<String, Object> model) {
        model.put("newsmap", newsRepository.getListNews());
        return "news-list";
    }

    @RequestMapping(value = {"/news-create"}, method = RequestMethod.GET)
    public String newsCreate(Map<String, Object> model) {
        News news = new News();
        model.put("news-map", news);
        return "news-create";
    }

    @RequestMapping(value = {"/news-remove"}, method = RequestMethod.GET)
    public String newsRemove(@RequestParam("id") String id) {
        newsRepository.removeNewsById(id);
        return "redirect:/person-list";
    }

//    @RequestMapping(value = {"/person-edit"}, method = RequestMethod.GET)
//    public String personEdit(@RequestParam("id") String personId, Map<String, Object> model) {
//        final User user = userRepository.findOne(personId);
//        model.put("person", user);
//        return "person-edit";
//    }

    @RequestMapping(value = {"/news-save"}, method = RequestMethod.POST)
    public String newsSave(@ModelAttribute("person") News news) {
        newsRepository.merge(news);
        return "redirect:/person-list";
    }

}
