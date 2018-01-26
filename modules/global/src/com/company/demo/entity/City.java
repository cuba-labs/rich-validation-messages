package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.validation.constraints.NotNull;

@NamePattern("%s|title")
@Table(name = "DEMO_CITY")
@Entity(name = "demo$City")
public class City extends StandardEntity {
    private static final long serialVersionUID = 6167500147617141172L;

    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}