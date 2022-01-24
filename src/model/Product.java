package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {

    private String code;
    private String name;
    private double quantity;
    private double price;
    private double value;


     List<ProductOperation> operations=new ArrayList<>();

    public Product(String code, String name, double quantity, double price, double value) {
        this.code = code;
        this.name = name;
        this.quantity =quantity;
        this.price = price;
        this.value=value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductOperation> getOperations() {
        return operations;
    }

    public void setOperations(ProductOperation... operation) {
     operations.addAll(Arrays.asList(operation));
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", value=" + value +
                '}';
    }
}
