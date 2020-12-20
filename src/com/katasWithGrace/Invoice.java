package com.katasWithGrace;

public class Invoice {
    private double price;
    private int quantityOfItemPurchased;
    private String partNumber;
    private String partDescription;

    public Invoice(double price, int quantityOfItemPurchased, String partNumber, String partDescription) {
        this.price = price;
        this.quantityOfItemPurchased = quantityOfItemPurchased;
        this.partNumber = partNumber;
        this.partDescription = partDescription;
    }

    public Invoice() {

    }

    public double getPrice() {
        return price;
    }

    public int getQuantityOfItemPurchased() {
        return quantityOfItemPurchased;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setPrice(double price) {
        if (price>0)this.price = price;
    }
    public void setQuantityOfItemPurchased(int quantityOfItemPurchased) {
        if(quantityOfItemPurchased>0)
            this.quantityOfItemPurchased = quantityOfItemPurchased;
    }
    public double getInvoiceAmount() {
        return price * quantityOfItemPurchased;
    }
}
