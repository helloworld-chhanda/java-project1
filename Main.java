import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors



class Supplier
{
    public String name;
    public String address;
    public String phoneNumber;

    public Supplier(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }



    public String toString() {
        return String.format("Supplier::\nName:%s,\nAddress:%s,\nPhoneNumber:%s", name, address,phoneNumber);
    }
}

class Item {
    public String name;
    public double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }



    public double getPrice() {
        return price;
    }


    public String toString()
    {
        return String.format("Item::\nName:%s,\nPrice:%.2f", name, price);
    }
}

class OrderItem {
    public Item item;
    public int quantity;

    public OrderItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }



    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }


    public String toString() {
        return String.format("OrderItem::\nItem:%s,\nQuantity:%d,\nTotalPrice:%.2f", item, quantity, getTotalPrice());
    }
}

class Order {
    public Supplier supplier;
    public List<OrderItem> items;
    public Date date;

    public Order(Supplier supplier, List<OrderItem> items) {
        this.supplier = supplier;
        this.items = items;
        this.date = new Date();
    }



    public double getTotalPrice() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }


    public String toString() {
        return String.format("Order::\nSupplier:%s,\nItems:%s,\nDate:%s,\nTotalPrice:%.2f", supplier, items, date, getTotalPrice());
    }
}

class Payment {
    public Supplier supplier;
    public double amount;
    public Date date;

    public Payment(Supplier supplier, double amount) {
        this.supplier = supplier;
        this.amount = amount;
        this.date = new Date();
    }



    public String toString() {
        return String.format("Payment::\nSupplier:%s,\nAmount:%.2f,\nDate:%s", supplier, amount, date);
    }
}

class Company {
    public List<Supplier> suppliers;
    public List<Order> orders;
    public List<Payment> payments;

    public Company() {
        this.suppliers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addSupplier(Supplier supplier)
    {

        suppliers.add(supplier);
    }

    public void placeOrder(Supplier supplier, List<OrderItem> items)
    {
        Order order = new Order(supplier,items);
        orders.add(order);
    }
    public void makePayment(Supplier supplier, double amount) {
        Payment payment = new Payment(supplier, amount);
        payments.add(payment);
    }

    public void displaySuppliers(FileWriter fw) {
        try {
            System.out.println("Suppliers:");
            fw.append("Suppliers:\n");
            for (Supplier supplier : suppliers)
            {
                System.out.println(supplier);
                fw.append(supplier+"\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    public void displayOrders(FileWriter fw) {
        try {
            System.out.println("Orders:");
            fw.append("Orders:\n");
            for (Order order : orders) {
                System.out.println(order);
                fw.append(order+"\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void displayPayments(FileWriter fw) {
        try {
            System.out.println("Payments:");
            fw.append("Payments:");
            for (Payment payment : payments) {
                System.out.println(payment);
                fw.append(payment+"\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


public class Main
{

    public static void main(String[] args) {
        try
        {
            FileWriter myWriter = new FileWriter("filename.txt", true);
            myWriter.append("\n\n");
            Scanner scanner = new Scanner(System.in);
            Company company = new Company();
            boolean exit = false;
            System.out.println(".................................................................................................................");
            myWriter.append(".................................................................................................................\n");
            System.out.println("..............................Welcome to the Company Management System!..........................................");
            myWriter.append("..............................Welcome to the Company Management System!..........................................\n");
            System.out.println(".................................................................................................................");
            myWriter.append(".................................................................................................................\n");
            while (!exit) {

                System.out.println("1. Add Supplier");
                myWriter.append("1. Add Supplier\n");
                System.out.println("2. Place Order");
                myWriter.append("2. Place Order\n");
                System.out.println("3. Make Payment");
                myWriter.append("3. Make Payment\n");
                System.out.println("4. Display Suppliers");
                myWriter.append("4. Display Suppliers\n");
                System.out.println("5. Display Orders");
myWriter.append("5. Display Orders\n");
                System.out.println("6. Display Payments");
myWriter.append("6. Display Payments\n");
                System.out.println("7. Exit");
myWriter.append("7. Exit\n");
                System.out.print("Enter your choice: ");
                myWriter.append("Enter your choice: \n");
                int choice = scanner.nextInt();
                myWriter.append(choice+" \n");
                scanner.nextLine(); // consume the new line character

                switch (choice) {
                    case 1:
                        String name,address,phoneNumber;

                        System.out.print("Enter supplier name: ");
                        myWriter.append("Enter supplier name: \n");
                        name = scanner.nextLine();
                        myWriter.append(name+" \n");
                        while(name.isEmpty())
                        {
                            System.out.print("Enter supplier name: ");
                            myWriter.append("Enter supplier name: \n");
                            name = scanner.nextLine();
                            myWriter.append(name+" \n");
                        }
                        System.out.print("Enter supplier address: ");
                        myWriter.append("Enter supplier address: \n");
                        address = scanner.nextLine();
                        myWriter.append(address+" \n");
                        while(address.isEmpty())
                        {
                            System.out.print("Enter supplier address: ");
                            myWriter.append("Enter supplier address: \n");
                            address = scanner.nextLine();
                            myWriter.append(address+" \n");
                        }

                        System.out.print("Enter supplier phone number: ");
                        myWriter.append("Enter supplier phone number: \n");
                        phoneNumber = scanner.nextLine();
                        myWriter.append(phoneNumber+" \n");
                        while(phoneNumber.isEmpty())
                        {

                            System.out.print("Enter supplier phone number: ");
                            myWriter.append("Enter supplier phone number: \n");
                            phoneNumber = scanner.nextLine();
                            myWriter.append(phoneNumber+" \n");
                        }
                        Supplier supplier = new Supplier(name, address, phoneNumber);
                        company.addSupplier(supplier);
                        System.out.println("Supplier added successfully!..");
myWriter.append("Supplier added successfully!..\n");
                        System.out.println(" ");
myWriter.append(" \n");
                        break;
                    case 2:
                        if (company.suppliers.isEmpty()) {
                            System.out.println("No suppliers added yet!");
myWriter.append("No suppliers added yet!\n");
                            System.out.println(" ");
myWriter.append(" \n");
                        } else {
                            System.out.println("Select a supplier to place the order:");
myWriter.append("Select a supplier to place the order:\n");
                            for (int i = 0; i < company.suppliers.size(); i++) {
                                System.out.println((i + 1) + ". " + company.suppliers.get(i).getName());
myWriter.append((i + 1) + ". " + company.suppliers.get(i).getName());
                            }
                            int supplierIndex = scanner.nextInt() - 1;
                            myWriter.append((supplierIndex+1)+" \n");
                            scanner.nextLine(); // consume the new line character

                            System.out.println("Enter item details:");
myWriter.append("Enter item details:\n");
                            List<OrderItem> items = new ArrayList<>();
                            boolean addItem = true;
                            while (addItem) {
                                System.out.print("Enter item name: ");
myWriter.append("Enter item name: \n");
                                String itemName = scanner.nextLine();
                                myWriter.append(itemName+" \n");
                                System.out.print("Enter item price: ");
myWriter.append("Enter item price: \n");
                                double itemPrice = scanner.nextDouble();
                                myWriter.append(itemPrice+" \n");
                                System.out.print("Enter item quantity: ");
myWriter.append("Enter item quantity: \n");
                                int quantity = scanner.nextInt();
                                myWriter.append(quantity+" \n");
                                scanner.nextLine(); // consume the new line character

                                Item item = new Item(itemName, itemPrice);
                                OrderItem orderItem = new OrderItem(item, quantity);
                                items.add(orderItem);

                                System.out.print("Add another item? (y/n): ");
myWriter.append("Add another item? (y/n): \n");
                                String addAnother = scanner.nextLine();
                                myWriter.append(addAnother+" \n");
                                addItem = addAnother.equalsIgnoreCase("y");
                            }
                            company.placeOrder(company.suppliers.get(supplierIndex), items);
                            System.out.println("Order placed successfully!");
myWriter.append("Order placed successfully!\n");
                            System.out.println(" ");
myWriter.append(" \n");
                        }
                        break;
                    case 3:
                        if (company.suppliers.isEmpty()) {
                            System.out.println("No suppliers added yet!");
myWriter.append("No suppliers added yet!\n");
                            System.out.println(" ");
myWriter.append(" \n");
                        } else {
                            System.out.println("Select a supplier to make the payment:");
myWriter.append("Select a supplier to make the payment:\n");
                            for (int i = 0; i < company.suppliers.size(); i++) {
                                System.out.println((i + 1) + ". " + company.suppliers.get(i).getName());
myWriter.append((i + 1) + ". " + company.suppliers.get(i).getName());
                            }
                            int supplierIndex = scanner.nextInt() - 1;
                            myWriter.append((supplierIndex+1)+" \n");
                            scanner.nextLine();

                            System.out.print("Enter payment amount: ");
myWriter.append("Enter payment amount: \n");
                            double amount = scanner.nextDouble();
                            myWriter.append(amount+" \n");
                            company.makePayment(company.suppliers.get(supplierIndex), amount);
                            System.out.println("Payment made successfully!");
myWriter.append("Payment made successfully!\n");
                            System.out.println(" ");
myWriter.append(" \n");
                        }
                        break;

                    case 4:
                        if (company.suppliers.isEmpty()) {
                            System.out.println("No suppliers added yet!!!");
myWriter.append("No suppliers added yet!!!\n");
                        }
                        else {
                            company.displaySuppliers(myWriter);
                            System.out.println(" ");
myWriter.append(" \n");
                        }
                        break;
                    case 5:

                        if (company.orders.isEmpty()) {
                            System.out.println("No Orders done yet!!!");
myWriter.append("No Orders done yet!!!\n");
                        }
                        else {
                            company.displayOrders(myWriter);
                            System.out.println(" ");
myWriter.append(" \n");
                        }
                        break;
                    case 6:
                        if( company.payments.isEmpty())
                        {
                            System.out.println("NO payments have been done!!!");
myWriter.append("NO payments have been done!!!\n");
                            System.out.println(" ");
myWriter.append(" \n");
                        }
                        else {
                            company.displayPayments(myWriter);
                            System.out.println(" ");
myWriter.append(" \n");
                        }
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Goodbye!");
myWriter.append("Goodbye!\n");
                        break;
                    default:
                        System.out.println("Invalid choice.....Please try again.");
myWriter.append("Invalid choice.....Please try again.\n");
                }
            }
            myWriter.append("Files in Java might be tricky, but it is fun enough!\n");
            scanner.close();
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
}