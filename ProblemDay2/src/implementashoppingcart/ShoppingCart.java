package implementashoppingcart;

import java.util.*;

class ShoppingCart {
    Map<String, Double> productPrices = new HashMap<>();
    Map<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }

    public Map<String, Double> getSortedCart() {
        Map<String, Double> sortedCart = new TreeMap<>(Comparator.comparingDouble(productPrices::get));
        for (String product : cart.keySet()) {
            sortedCart.put(product, productPrices.get(product));
        }
        return sortedCart;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 1.0);
        cart.addProduct("Orange", 2.0);

        System.out.println(cart.getSortedCart());
    }
}

