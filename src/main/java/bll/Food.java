package bll;

import java.io.Serializable;
public class Food implements Serializable {

    private int id;
    private String name;
    private String price;
    private String detail;
    private String category;

    public Food(int id, String name, String price, String detail, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.category = category;
    }

    public Food() {
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
