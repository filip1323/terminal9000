package backend;

import editor.TableSetup;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Table extends TableSetup {

    ArrayList<Order> getOrders();

    void addOrder(Order order);
    void clearOrder(Order order);
}
