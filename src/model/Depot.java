package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Depot {

    private String name;
    private String address;

    List<Product> products = new ArrayList<>();

    public Depot(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product... product) {
        products.addAll(Arrays.asList(product));
    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
