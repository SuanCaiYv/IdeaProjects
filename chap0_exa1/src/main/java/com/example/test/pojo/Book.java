package com.example.test.pojo;

public class Book
{
    private Integer id;
    private String name;
    private Double price;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getPrice()
    {
        return price;
    }

    public Integer getId()
    {
        return id;
    }
}
