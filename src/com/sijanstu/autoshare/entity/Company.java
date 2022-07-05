package com.sijanstu.autoshare.entity;

/**
 *
 * @author sijan
 */
public class Company {
    private int id;
    private String name;
    private String details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", details=" + details + '}';
    }
}
