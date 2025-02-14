package smartwarehousemanagementsystem;

import java.util.ArrayList;
import java.util.List;

// Step 1: Abstract class for warehouse items
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getType();
}

// Step 2: Subclasses representing different item types
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Furniture";
    }
}

// Step 3: Generic Storage class with bounded type parameter
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public List<T> getAllItems() {
        return items;
    }
}

// Step 4: Wildcard method to display any type of warehouse items
class WarehouseUtil {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getType() + ": " + item.getName());
        }
    }
}

// Step 5: Testing the implementation
public class SmartWarehouse {
    public static void main(String[] args) {
        // Creating storages for different item types
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Adding items to storages
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Rice"));

        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Displaying all items using wildcard method
        System.out.println("Electronics Storage:");
        WarehouseUtil.displayItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries Storage:");
        WarehouseUtil.displayItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture Storage:");
        WarehouseUtil.displayItems(furnitureStorage.getAllItems());
    }
}

