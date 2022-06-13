package com.guelzinhocurso.condesdiary.activities.RecyclerView;

import java.io.Serializable;

public class ValuesList  implements  Serializable{
    private Long id;
    private String title, text;

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
