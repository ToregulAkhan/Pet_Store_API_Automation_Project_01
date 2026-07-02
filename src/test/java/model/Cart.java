package model;

import java.util.List;

public class Cart {
    public int idCart;
    public int userId;
    public String status;
    public double totalAmount;
    public List<Group> groups;
    public double total;
    public String currency;

    public Cart(int idCart, int userId, String status, double totalAmount, List<Group> groups, double total, String currency) {
        this.idCart = idCart;
        this.userId = userId;
        this.status = status;
        this.totalAmount = totalAmount;
        this.groups = groups;
        this.total = total;
        this.currency = currency;
    }

    public int getIdCart() {
        return idCart;
    }

    public int getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public double getTotal() {
        return total;
    }

    public String getCurrency() {
        return currency;
    }
}
