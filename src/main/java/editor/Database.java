package editor;

import backend.Product;
import backend.Table;

import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Database {
    void addProduct(ProductSetup productSetup);
    void addTableSetup(TableSetup tableSetup);

    void applyChanges();
}
