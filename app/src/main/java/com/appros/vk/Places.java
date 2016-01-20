package com.appros.vk;


/**
 * Created by Vitaly on 20.01.2016.
 */
public class Places {

    public static final String METHOD_BASE = "places";

    /**
     * Возвращает полное имя метода
     * @param methodName
     * @return
     */
    protected static String getFullMethodName(String methodName) {

        String fullMethodName = METHOD_BASE + "" + methodName;

        return fullMethodName;
    }

    /**
     * Добавляет новое место в базу географических мест.
     * Созданное место будет выводиться в поиске по местам только тому, кто его добавил.
     */
    public void add() {

        //
    }

    /**
     * Возвращает информацию о местах по их идентификаторам.
     */
    public void getById() {

        //
    }

    /**
     * Возвращает список мест, найденных по заданным условиям поиска.
     * Поиск производится среди мест, добавленных модераторами сайта и текущим пользователем.
     * Места в списке расположены в порядке увеличения дистанции от исходной точки поиска.
     */
    public void search() {

        //
    }

    /**
     * Отмечает пользователя в указанном месте.
     * Для вызова этого метода Ваше приложение должно иметь права: wall.
     * Подробнее о получении прав: https://vk.com/dev/permissions
     */
    public void checkin() {

        //
    }

    /**
     * Возвращает список отметок пользователей в местах согласно заданным параметрам.
     */
    public void getCheckins() {

        //
    }

    /**
     * Возвращает список всех возможных типов мест.
     */
    public static void getTypes() {

        String fullMethodName = getFullMethodName("getTypes");

        Request request = new Request(fullMethodName);

        request.execute();
    }

}
