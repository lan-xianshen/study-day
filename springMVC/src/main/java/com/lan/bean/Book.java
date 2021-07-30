package com.lan.bean;

import java.math.BigDecimal;

/**
 * @author jianglin.lan
 * @title: Book
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/21 10:18
 */
public class Book {
    private String name;
    private int id;
    private BigDecimal price;

    public Book () {
    }

    public Book (String name, int id, BigDecimal price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public void setPrice (BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString () {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }
}
