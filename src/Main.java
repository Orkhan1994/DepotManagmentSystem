import exception.InvalidNumberException;
import exception.Message;
import model.Depot;
import model.Employee;
import model.GenderType;
import model.Product;
import service.ProductOperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Depot> depots = new ArrayList<>();
    static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {

        var employees = getEmployees();
        System.out.println("Welcome to System.");
        login(employees);

    }

    private static void login(List<Employee> employees) {
        for (; ; ) {
            int index;
            Scanner sc = new Scanner(System.in);

            System.out.print("Username daxil edin:");
            String username = sc.nextLine();
            System.out.print("Password daxil edin:");
            String password = sc.nextLine();

            Employee employee = null;
            for (Employee employee1 : employees) {
                if (employee1.getUserName().equals(username)) {
                    employee = employee1;
                    break;
                }
            }
            if (employee == null) {
                System.out.println("Username and password incorrect.");
                continue;
            }
            if (!employee.getPassword().equals(password)) {
                System.out.println("Username and password incorrect.");
                continue;
            }
            selectDepot(sc, employee.getDepots());
        }
    }

    public static void selectDepot(Scanner sc, List<Depot> depots) {
        for (; ; ) {
            int index;
            System.out.println("select depot index:");
            for (int i = 0; i < depots.size(); i++) {
                System.out.println(i + 1 + "." + depots.get(i).getName());
            }
            System.out.print("Depot index daxil edin:");
            index = sc.nextInt();
            if (index <= 0) {
                System.out.println("Daxil etdiyiniz index yanlisdir.");
            } else {
                int login = showDepotProducts(sc, depots.get(index - 1).getProducts(), index);
                if (login == 0) {
                    return;
                }
            }
        }
    }

    public static int showDepotProducts(Scanner sc, List<Product> products, int index) {
        for (; ; ) {
            for (int i = 0; i < products.size(); i++) {
                System.out.println(i + 1 + "." + products.get(i));
            }
            System.out.print("Enter Product index:");
            index = sc.nextInt();
            System.out.println(products.get(index - 1));
            boolean booleans = selectOperations(sc, products, index);

            if (booleans) {
                System.out.print("Login ucun 0 daxil edin\n" +
                        "Select Depot ucun 1 daxil edin:");
                int number = sc.nextInt();
                if (number != 0 && number != 1) {
                    throw new InvalidNumberException(Message.NUMBER_EXCEPTION_MESSAGE);
                }
                return number;
            }
        }
    }

    public static boolean selectOperations(Scanner sc, List<Product> products, int index) {
        for (; ; ) {
            System.out.println("Zehmet olmasa bir operation secin.");
            System.out.println("1.Insert product to Depot");
            System.out.println("2.Buy");
            System.out.println("3.Sale");
            System.out.println("4.Depot to Depot");
            System.out.println("5.Show Product operations");
            System.out.println("6.Login and Select to depot ");
            System.out.println("7.Select to product");
            System.out.println("8.Exit");

            System.out.print("Enter operations index:");
            int operation = sc.nextInt();

            ProductOperationService operationService = new ProductOperationService();
            double weight;
            double price;
            String code;
            String name;
            double value;
            int indexs;
            String description;

            switch (operation) {
                case 1:
                    System.out.print("Enter product code:");
                    code = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Enter product name:");
                    name = sc.nextLine();
                    System.out.print("Enter product quantity:");
                    weight = sc.nextDouble();
                    System.out.print("Enter product price:");
                    price = sc.nextDouble();
                    System.out.print("Enter product value:");
                    value = sc.nextDouble();

                    for (int i = 0; i < depots.size(); i++) {
                        System.out.println(i + 1 + "." + depots.get(i).getName());

                    }
                    System.out.print("Zehmet olmasa gondereceyiniz deponu index-ni secin:");
                    indexs = sc.nextInt();
                    Depot depot = null;
                    for (int i = 0; i < depots.size(); i++) {
                        depot = depots.get(indexs - 1);
                    }

                    operationService.insertProductToDepot(depot, code, name, weight, price, value);
                    break;
                case 2:
                    System.out.print("Enter weight:");
                    weight = sc.nextDouble();
                    System.out.print("Enter price:");
                    price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter description:");
                    description = sc.nextLine();
                    operationService.buy(weight, products.get(index - 1), price, description);
                    break;
                case 3:
                    System.out.print("Enter weight:");
                    weight = sc.nextDouble();
                    System.out.print("Enter price:");
                    price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter description:");
                    description = sc.nextLine();
                    operationService.sale(weight, products.get(index - 1), price, description);
                    break;
                case 4:
                    for (int i = 0; i < depots.size(); i++) {
                        System.out.println(i + 1 + "." + depots.get(i).getName());

                    }
                    System.out.print("Zehmet olmasa gondereceyiniz deponu index-ni secin:");
                    indexs = sc.nextInt();
                    Depot toDepot = null;
                    for (int i = 0; i < depots.size(); i++) {
                        toDepot = depots.get(indexs - 1);
                    }
                    for (int i = 0; i < toDepot.getProducts().size(); i++) {
                        if (!(depots.get(index - 1).getProducts().equals(toDepot.getProducts()))) {
                            products.get(index - 1).setQuantity(0);
                            products.get(index - 1).setValue(0);
                            products.get(index - 1).setPrice(0);
                            toDepot.setProducts(products.get(index - 1));
                            break;
                        }

                    }
                    for (int i = 0; i < toDepot.getProducts().size(); i++) {
                        System.out.println(i + 1 + "." + toDepot.getProducts().get(i));
                    }
                    System.out.print("Enter weight:");
                    weight = sc.nextDouble();
                    System.out.print("Enter price:");
                    price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter description:");
                    description = sc.nextLine();
                    operationService.depotToDepot(products.get(index - 1), weight, price, description, toDepot);
                    break;
                case 5:
                    operationService.showOperation(products.get(index - 1));
                    break;
                case 6:
                    return true;
                case 7:
                    return false;
                case 8:
                    System.exit(1);
                default:
                    System.out.println("Emeliyyati duzgun daxil edin.");

            }
        }
    }

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Orxan", "Mirzeyev", "orxan", "1111", GenderType.MAN, 500.0);
        Employee employee2 = new Employee("Rafael", "Memmedov", "rafael", "2222", GenderType.MAN, 700.0);
        Employee employee3 = new Employee("Turgut", "Allahverdiyev", "turgut", "3333", GenderType.MAN, 600.0);
        Employee employee4 = new Employee("Melik", "Agakhanli", "melik", "4444", GenderType.MAN, 650.0);


        Depot depot1 = new Depot("Depot1", "Baku");
        Depot depot2 = new Depot("Depot2", "Baku");
        Depot depot3 = new Depot("Depot3 ", "Baku");
        Depot depot4 = new Depot("Depot4", "Baku");
        Depot depot5 = new Depot("Depot5", "Baku");

        Product product1 = new Product("11", "Alma", 400.0, 1.5, 600.0);
        Product product2 = new Product("12", "Armud", 150.0, 2.0, 300);
        Product product3 = new Product("13", "Banan", 50, 1.8, 90);
        Product product4 = new Product("14", "Kartof", 700.0, 0.5, 350);
        Product product5 = new Product("15", "Sogan", 1000.0, 0.3, 300);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        depot1.setProducts(product1, product2);
        depot2.setProducts(product2, product3);
        depot3.setProducts(product3, product4);
        depot4.setProducts(product3, product5);
        depot5.setProducts(product4, product5);

        depots.add(depot1);
        depots.add(depot2);
        depots.add(depot3);
        depots.add(depot4);
        depots.add(depot5);

        employee1.setDepots(depot1, depot2);
        employee2.setDepots(depot2, depot3);
        employee3.setDepots(depot4);
        employee4.setDepots(depot4, depot5);

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);


        return employees;
    }


}
