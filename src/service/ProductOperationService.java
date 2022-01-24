package service;

import exception.InvalidPriceException;
import exception.InvalidQuantityException;
import exception.InvalidWeightExseption;
import exception.Message;
import model.Depot;
import model.OperationType;
import model.Product;
import model.ProductOperation;


public class ProductOperationService {


    public void insertProductToDepot(Depot depot,String code,String name,double quantity,double price,double value){
             Product product=new Product(code, name, quantity, price, value);
             depot.setProducts(product);

    }
    public void buy(double weight,Product product, double price, String description) {
        var quantiy = product.getQuantity();
        quantiy += weight;
        product.setQuantity(quantiy);
        var value = product.getValue();
        if (weight<0.1){
            throw new InvalidWeightExseption(Message.WEIGHT_EXCEPTION_MESSAGE);
        }
        if (price<0.1){
            throw new InvalidPriceException(Message.PRICE_EXCPTION_MESSAGE);
        }
        value += weight * price;
        product.setValue(value);
        product.setOperations(new ProductOperation(OperationType.BUY,  weight,quantiy, price, value, description));
    }

    public void sale( double weight,Product product, double price, String description) {
        var quantiy = product.getQuantity();
        if (quantiy<0||quantiy<weight){
           throw  new InvalidQuantityException(Message.QUANTITY_EXCEPTION_MESSAGE);
        }
        quantiy -= weight;
        product.setQuantity(quantiy);
        if (weight<0.1){
            throw new InvalidWeightExseption(Message.WEIGHT_EXCEPTION_MESSAGE);
        }
        if (price<0.1){
            throw new InvalidPriceException(Message.PRICE_EXCPTION_MESSAGE);
        }
       var value = weight * price;

        product.setOperations(new ProductOperation(OperationType.SALE,weight,quantiy, price, value, description));
    }

    public void depotToDepot(Product product, double weight, double price, String description,Depot toDepot) {
        buy(weight,product,price,description);

    }

    public void showOperation(Product product) {
        System.out.println("Code        /        Name        /        " +
                " Weight     /       Quantity     /       Price       /       Value     /        Description");

        product.getOperations().forEach(pro -> {
            System.out.println(product.getCode() + "        /        " +
                    product.getName() + "        /        " +
                    pro.getWeight() + "        /        " +
                    pro.getQuantity() + "       /        " +
                    pro.getPrice() + "        /        " +
                    pro.getValue() + "      /        " +
                    pro.getDescription());
        });
    }
}
