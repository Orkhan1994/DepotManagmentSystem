package model;


import exception.InvalidPriceException;
import exception.InvalidQuantityException;
import exception.InvalidWeightExseption;
import exception.Message;

public class ProductOperation {

    private OperationType type;
    private double weight;
    private double quantity;
    private double price;
    private  double value;
    private String description;


    public ProductOperation(OperationType type, double weight,double quantity, double price, double value,String description) {
        this.type = type;
        if (weight<=0.1){
            throw new InvalidWeightExseption(Message.WEIGHT_EXCEPTION_MESSAGE);
        }
        this.weight = weight;
        if (quantity<=0||quantity<weight){
            throw new InvalidQuantityException(Message.PRICE_EXCPTION_MESSAGE);
        }
        this.quantity=quantity;
        if (price<=0.1){
            throw new InvalidPriceException(Message.PRICE_EXCPTION_MESSAGE);
        }
        this.price = price;
        this.value=value;
        this.description = description;
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductOperation{" +
                "weight=" + weight +
                ", price=" + price +
                ", value=" + value +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }
}
