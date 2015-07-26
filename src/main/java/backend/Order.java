package backend;

import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Order {
    void addProduct(Product product);
    ArrayList<Product> getProducts();
    Bill getBill();
}
