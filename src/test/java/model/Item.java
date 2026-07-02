package model;

public class Item {
    public int idCartItem;
    public int idCart;
    public int productId;
    public int sellerId;
    public String productName;
    public String sellerName;
    public double unitPrice;
    public int quantity;
    public double subtotal;
    public String imageUrl;

    public Item(int idCartItem, int idCart, int productId, int sellerId, String productName, String sellerName, double unitPrice, int quantity, double subtotal, String imageUrl) {
        this.idCartItem = idCartItem;
        this.idCart = idCart;
        this.productId = productId;
        this.sellerId = sellerId;
        this.productName = productName;
        this.sellerName = sellerName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.imageUrl = imageUrl;
    }

    public int getIdCartItem() {
        return idCartItem;
    }

    public int getIdCart() {
        return idCart;
    }

    public int getProductId() {
        return productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getProductName() {
        return productName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
