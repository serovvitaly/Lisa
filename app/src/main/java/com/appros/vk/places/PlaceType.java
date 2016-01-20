package com.appros.vk.places;

/**
 * Тип места
 */
public class PlaceType {

    protected Integer tid;

    protected String title;

    protected String icon;

    public PlaceType(Integer tid, String title, String icon) {
        this.tid = tid;
        this.title = title;
        this.icon = icon;
    }

    public Integer getTid() {

        return this.tid;
    }

    public String getTitle() {

        return this.title;
    }

    public String getIcon() {

        return this.icon;
    }

}
