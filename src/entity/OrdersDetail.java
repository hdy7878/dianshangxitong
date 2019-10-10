package entity;

public class OrdersDetail {
    private int id;
    private String orderID;
    private Products p;
    private int quantity;
    private double discount;

    public OrdersDetail(int id, String orderID, Products p, int quantity, double discount) {
        this.id = id;
        this.orderID = orderID;
        this.p = p;
        this.quantity = quantity;
        this.discount = discount;
    }

    public OrdersDetail(String orderID, Products p, int quantity, double discount) {
        this.orderID = orderID;
        this.p = p;
        this.quantity = quantity;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Products getP() {
        return p;
    }

    public void setP(Products p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrdersDetail{" +
                "id=" + id +
                ", orderID='" + orderID + '\'' +
                ", p=" + p +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
