package backend;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Menu {

    ArrayList<Product> getAllProducts();
    ArrayList<Product> getAllProductsWithCategory(String categoryName);
    Product getProduct(String name) throws UnexpectedException;
}
