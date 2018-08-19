package ru.gvg.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.08.2018.
 */
public class News implements Serializable{

    private String id = UUID.randomUUID().toString();
    private String cap;
    private String text;
    private List<String> tags;
    private Date date;
    private String preview;
    private double price;

    public News() {

    }

    public News(String cap, String text, List<String> tags, Date date, String preview, double price) {
        this.cap = cap;
        this.text = text;
        this.tags = tags;
        this.date = date;
        this.preview = preview;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCap() {
        return cap;
    }

    public String getText() {
        return text;
    }

    public List<String> getTags() {
        return tags;
    }

    public Date getDate() {
        return date;
    }

    public String getPreview() {
        return preview;
    }

    public double getPrice() {
        return price;
    }
}
