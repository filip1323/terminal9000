package backend;

import editor.TableSetupImpl;

import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-26.
 */
public class TableImpl extends TableSetupImpl implements Table {

    ArrayList<Order> orders;

    public TableImpl(){
        this.orders = new ArrayList<Order>();
    }

    @Override
    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public void clearOrder(Order order) {
        this.orders.remove(order);
    }

}
