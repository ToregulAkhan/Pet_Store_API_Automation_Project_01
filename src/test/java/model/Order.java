package model;

import java.util.Date;

public class Order {
    public int id;
    public int petId;
    public int quantity;
    public Date shipDate;
    public String status;
    public boolean complete;

    public Order(){}

    public Order(int id, int petId, int quantity, Date shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public int getPetId() {
        return petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public String getStatus() {
        return status;
    }

    public boolean getComplete() {
        return complete;
    }
}
