package backend;

import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Database {
    ArrayList<Product> getAllProducts();
    ArrayList<Table> getTableSetup();
}
