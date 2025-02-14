package dynamiconlinemarketplace;


abstract class ProductCategory {
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

// Specific Categories
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}

// Generic Product Class
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct() {
        System.out.println(category.getCategoryName() + " - " + name + ": $" + price);
    }
}

// Utility Class with Generic Discount Method
class MarketplaceUtil {
    public static <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

// Main Class
public class DynamicMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 300.0, new GadgetCategory());

        System.out.println("Before Discount:");
        book.displayProduct();
        shirt.displayProduct();
        phone.displayProduct();

        MarketplaceUtil.applyDiscount(book, 10);
        MarketplaceUtil.applyDiscount(shirt, 15);
        MarketplaceUtil.applyDiscount(phone, 5);

        System.out.println("\nAfter Discount:");
        book.displayProduct();
        shirt.displayProduct();
        phone.displayProduct();
    }
}

