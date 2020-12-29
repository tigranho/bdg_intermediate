package com.bdg;
/**
 * @author Artur
 */

/**
 * Simple example aggregation
 */
public class LineItem {
    private int id;
    private int quantity;
    private Product p;

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getP() {
        return p;
    }

    public LineItem(int id, int quantity, Product p) {
        this.id = id;
        this.quantity = quantity;
        this.p = p;
    }

    @Override
    public String toString() {
        return "LineItem [id=" + id + ", quantity=" + quantity + ", p=" + p + "]";
    }
}
