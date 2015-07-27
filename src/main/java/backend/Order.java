package backend;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Order {
    void addProduct(Product product);
    void setTable(Table table);
    int getId();
    Table getTable() throws UnexpectedException;
    Bill getBill();
    ArrayList<Product> getProducts();
}
