import java.util.Scanner;
import java.util.ArrayList;

class Inventory {
    private String productName;
    private int productID;
    private int quantity;
    private double price;

    public Inventory(String productName, int productID, int quantity, double price) {
        this.productName = productName;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }
    
    public void updateProductName(String productName) {
        this.productName = productName;
    }

    public void updateProductQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateProductPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Product Name: " + productName + "\nProduct ID: " + productID + "\nQuantity: " + quantity + "\nPrice: $" + price;
    }
}

class InventoryManagementSystem {
    // local scanner and arraylist
    static Scanner s = new Scanner(System.in);
    static ArrayList<Inventory> Inventory = new ArrayList<>();

    static void displayMenu() {
        System.out.println("--------------------------------\n" +
            "Welcome to the Inventory Management System\n" +
            "--------------------------------\n" +
            "1. Add Product\n" +
            "2. Display Inventory\n" +
            "3. Update Product\n" +
            "4. Remove Product\n" +
            "5. Search Product\n" +
            "6. Exit");
    }

    static void addProduct() {
        System.out.println("--------------------------------");
        System.out.print("Enter product name: ");
        String productName = s.nextLine();
        System.out.println("--------------------------------");

        System.out.print("Enter product id: ");
        int productID = s.nextInt();
        s.nextLine();
        System.out.println("--------------------------------");

        System.out.print("Enter quantity: ");
        int quantity = s.nextInt();
        s.nextLine();
        System.out.println("--------------------------------");

        System.out.print("Enter price: ");
        double price = s.nextDouble();
        s.nextLine();
        System.out.println("--------------------------------");

        Inventory.add(new Inventory(productName, productID, quantity, price));
        System.out.println("Product added successfully!");

        System.out.println("--------------------------------");
    }

    static void displayInventory() {
        System.out.println("--------------------------------");

        if(Inventory.isEmpty()) {
            System.out.println("No inventory!");
            return;
        }

        System.out.println("--------------------------------");

        System.out.println("Inventory: ");

        for(int i = 0; i < Inventory.size();) {
            System.out.println(Inventory.get(i));
            System.out.println("--------------------------------");
            return;
        }
    }

    static void updateProduct() {
        System.out.println("--------------------------------");
        System.out.print("Enter product id to update: ");
        int productID = s.nextInt();
        s.nextLine();

        for(int i = 0; i < Inventory.size(); i++) {
            Inventory inventoryProduct = Inventory.get(i);

            if(inventoryProduct.getProductID() == productID) {
                System.out.println("--------------------------------");
                System.out.println("1. Edit product name\n2. Edit product quantity\n3. Edit product price");
                System.out.print("Enter your choice: ");
                int option = s.nextInt();

                s.nextLine();

                switch(option) {
                    case 1:
                        System.out.println("--------------------------------");
                        System.out.print("Enter new product name: ");
                        String newProductName = s.nextLine();

                        inventoryProduct.updateProductName(newProductName);

                        System.out.println("--------------------------------");
                        break;
                    case 2:
                        System.out.println("--------------------------------");
                        System.out.print("Enter new product quantity: ");
                        int quantity = s.nextInt();
        
                        inventoryProduct.updateProductQuantity(quantity);

                        System.out.println("--------------------------------");
                        break;
                    case 3:
                        System.out.println("--------------------------------");
                        System.out.print("Enter new product price: ");
                        double price = s.nextInt();
        
                        inventoryProduct.updateProductPrice(price);

                        System.out.println("--------------------------------");
                        break;
                    default:
                        System.out.println("Invalid");
                }

                System.out.println("Product updated successfully!");

                return;
            }
        }

        System.out.println("Product not found!");
    }

    static void removeProduct() {
        System.out.println("--------------------------------");

        if(Inventory.isEmpty()) {
            System.out.println("No inventory!");
            return;
        }

        System.out.print("Enter product id to remove: ");
        int productID = s.nextInt();

        s.nextLine();

        for(int i = 0; i < Inventory.size(); i++) {
            Inventory inventoryProduct = Inventory.get(i);

            if(inventoryProduct.getProductID() == productID) {
                Inventory.remove(i);

                System.out.println("Product removed!");

                return;
            }
        }

        System.out.println("Product not found!");
    }

    static void searchProduct() {
        System.out.println("--------------------------------");

        System.out.print("Enter product name to search: ");
        String productName = s.nextLine();

        for(int i = 0; i < Inventory.size(); i++) {
            if(Inventory.get(i).getProductName().equalsIgnoreCase(productName)) {
                System.out.println("--------------------------------");
                System.out.println("Product found: " + "\n" + Inventory.get(i));
                return;
            }
        }

        System.out.println("Product not found!");
    }

    static void exitApp() {
        System.out.println("Thank you for using the Inventory Management System. Goodbye!");
        s.close();
    }

    public static void main(String[] args) {
        while(true) {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            int choice = s.nextInt();
    
            s.nextLine();
    
            switch(choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayInventory();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    exitApp();
                    return;
            }
        }
    }    
}
