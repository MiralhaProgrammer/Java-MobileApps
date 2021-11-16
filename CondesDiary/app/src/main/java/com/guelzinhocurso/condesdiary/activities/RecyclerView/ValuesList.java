package com.guelzinhocurso.condesdiary.activities.RecyclerView;

import java.io.Serializable;

public class ValuesList  implements  Serializable{
    private Long id;
    private String title, text, date,datem, datey, rate;

    public String getDatem() {
        return datem;
    }

    public void setDatem(String datem) {
        this.datem = datem;
    }

    public String getDatey() {
        return datey;
    }

    public void setDatey(String datey) {
        this.datey = datey;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
