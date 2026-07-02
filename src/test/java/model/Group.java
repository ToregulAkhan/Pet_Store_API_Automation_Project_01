package model;


import java.util.List;

public class Group {
    public int sellerId;
    public String sellerName;
    public double sellerSubtotal;
    public List<Item> items;

    public Group(int sellerId, String sellerName, double sellerSubtotal, List<Item> items) {
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerSubtotal = sellerSubtotal;
        this.items = items;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public double getSellerSubtotal() {
        return sellerSubtotal;
    }

    public List<Item> getItems() {
        return items;
    }
}
