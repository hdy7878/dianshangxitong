package entity;

public class Orders {
    private String orderID;
    private String order_date;
    private Employees emp;
    private Customers cus;

    public Orders(String orderID, String order_date, Employees emp, Customers cus) {
        this.orderID = orderID;
        this.order_date = order_date;
        this.emp = emp;
        this.cus = cus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public Employees getEmp() {
        return emp;
    }

    public void setEmp(Employees emp) {
        this.emp = emp;
    }

    public Customers getCus() {
        return cus;
    }

    public void setCus(Customers cus) {
        this.cus = cus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID='" + orderID + '\'' +
                ", order_date='" + order_date + '\'' +
                ", emp=" + emp +
                ", cus=" + cus +
                '}';
    }
}
