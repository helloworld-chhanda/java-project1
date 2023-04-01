import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/*

  Implement a system that a company would use for recording purchases of items.
  The system must be capable of recording details of suppliers, and orders sent to suppliers requesting goods.
  The system must be able to provide a series of reports, for example details of when goods are received
  and details of payments made.

 */
class PurchaseSystem
{
    public List<Supplier> suppliers;
    private List<PurchaseOrder> purchaseOrders;
    private List<Purchase> purchases;
    private List<Payment> payments;

    public PurchaseSystem() {
        this.suppliers = new ArrayList<>();
        this.purchaseOrders = new ArrayList<>();
        this.purchases = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    public void placeOrder(PurchaseOrder order) {
        purchaseOrders.add(order);
    }

    public void receivePurchase(Purchase purchase) {
        purchases.add(purchase);
    }

    public void makePayment(Payment payment) {
        payments.add(payment);
    }
    public void generatePurchasesReport(Date startDate, Date endDate) {
        double totalCost = 0;
        System.out.println("Purchases Report for " + startDate + " to " + endDate);
        System.out.println("-------------------------------------------------");
        for (Purchase purchase : purchases) {
            if (purchase.getDateReceived().after(startDate) && purchase.getDateReceived().before(endDate)) {

                System.out.println("Supplier: " + purchase.getPurchaseOrder().getSupplier().getName());
                System.out.println("Date Received: " + purchase.getDateReceived());
                System.out.println("Total Cost: $" + purchase.getTotalCost());
                System.out.println("Items:");
                for (Item item : purchase.getPurchaseOrder().getItems()) {
                    System.out.println("- " + item.Getname()+ " x " + item.getQuantity() + " @ $" + item.getPrice());
                }
                totalCost += purchase.getTotalCost();
                System.out.println("-------------------------------------------------");
            }
        }
        System.out.println("Total Cost for period: $" + totalCost);
    }

    void sup()
    {
        System.out.println(suppliers);
    }
}
class PurchaseOrder {
    private Supplier supplier;
    private Item[] items;
    private Date datePlaced;

    public PurchaseOrder(Supplier supplier, Item[] items, Date datePlaced) {
        this.supplier = supplier;
        this.items = items;
        this.datePlaced = datePlaced;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Item[] getItems() {
        return items;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

}
class Supplier {
    private String name;
    private String address;
    private String phone;

    public Supplier(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String Getname()
    {
        return name;
    }
    public double getPrice()
    {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
}
class Purchase {
    public PurchaseOrder purchaseOrder;
    public Date dateReceived;
    public double totalCost;

    public Purchase(PurchaseOrder purchaseOrder, Date dateReceived, double totalCost) {
        this.purchaseOrder = purchaseOrder;
        this.dateReceived = dateReceived;
        this.totalCost = totalCost;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public double getTotalCost() {
        return totalCost;
    }

}
class Payment {
    private Supplier supplier;
    private Date datePaid;
    private double amount;

    public Payment(Supplier supplier, Date datePaid, double amount) {
        this.supplier = supplier;
        this.datePaid = datePaid;
        this.amount = amount;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public double getAmount() {
        return amount;
    }


}
public class project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PurchaseSystem system = new PurchaseSystem();

        // Adding suppliers
        Supplier supplier1 = new Supplier("Supplier 1", "2-241 tanuku", "1234567890");
        Supplier supplier2 = new Supplier("Supplier 2", "Address 2", "0987654321");
        system.addSupplier(supplier1);
        system.addSupplier(supplier2);
        system.sup();
        // Creating purchase orders
        Item item1 = new Item("Item 1", 10.0, 5);
        Item item2 = new Item("Item 2", 20.0, 3);
        PurchaseOrder order1 = new PurchaseOrder(supplier1, new Item[]{item1, item2}, new Date());
        PurchaseOrder order2 = new PurchaseOrder(supplier2, new Item[]{item2}, new Date());

        // Placing purchase orders
        system.placeOrder(order1);
        system.placeOrder(order2);

        // Receiving purchases
        Purchase purchase1 = new Purchase(order1, new Date(), 150.0);
        Purchase purchase2 = new Purchase(order2, new Date(), 60.0);
        system.receivePurchase(purchase1);
        system.receivePurchase(purchase2);

        // Making payments
        Payment payment1 = new Payment(supplier1, new Date(), 120.0);
        Payment payment2 = new Payment(supplier2, new Date(), 50.0);
        system.makePayment(payment1);
        system.makePayment(payment2);

        // Generating reports
        System.out.println("Enter start date (yyyy-MM-dd): ");
        String startDateStr = sc.nextLine();
        System.out.println("Enter end date (yyyy-MM-dd): ");
        String endDateStr = sc.nextLine();
        Date startDate = parseDate(startDateStr);
        Date endDate = parseDate(endDateStr);
        system.generatePurchasesReport(startDate, endDate);
    }
    // Helper function to parse date string in yyyy-MM-dd format
    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(dateString);
        } catch (ParseException e)
        {
            System.out.println("Invalid date format");
            return null;
        }
    }

}