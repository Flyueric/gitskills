package com.wb.week06;

public class Goods {
    private String name;
    private String kind;
    private double price;

    public Goods() {
        super();
    }

    public Goods(String name, String kind, double price) {
        super();
        this.name = name;
        this.kind = kind;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", price=" + price +
                '}';
    }
}
