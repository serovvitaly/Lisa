package com.appros.vk.places;

import com.appros.vk.Request;

/**
 * Created by Vitaly on 20.01.2016.
 */
public class PlacesSearchRequest extends Request {

    /**
     * Строка поискового запроса.
     */
    protected String query;

    /**
     * Идентификатор города.
     */
    protected Integer city;

    /**
     * Географическая широта точки, в радиусе которой необходимо производить поиск,
     * заданная в градусах (от -90 до 90).
     */
    protected Double latitude;

    /**
     * Географическая долгота точки, в радиусе которой необходимо производить поиск,
     * заданная в градусах (от -180 до 180).
     */
    protected Double longitude;

    /**
     * тип радиуса зоны поиска (от 1 до 4)
     * 1 — 300 метров;
     * 2 — 2400 метров;
     * 3 — 18 километров;
     * 4 — 150 километров.
     */
    protected Integer radius;

    /**
     * Смещение, необходимое для выборки определенного подмножества результатов поиска.
     */
    protected Integer offset;

    /**
     * Количество мест, информацию о которых необходимо вернуть.
     * По умолчанию 30, максимальное значение 1000.
     */
    protected Integer count;

    public void setQuery(String query) {
        this.query = query;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PlacesSearchRequest() {

        super("places.search");
    }
}
