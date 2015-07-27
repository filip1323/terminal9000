package backend;

import editor.TableSetupImpl;

import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-26.
 */
public class TableImpl extends TableSetupImpl implements Table {

    public ArrayList<Integer> ordersId = new ArrayList<Integer>();

    public TableImpl(){
        this.ordersId = new ArrayList<Integer>();
    }

    @Override
    public ArrayList<Order> getOrders() {
        return null;
    }

    @Override
    public void addOrder(Order order) {
        System.out.println(ordersId);
        this.ordersId.add(order.getId());
        System.out.println(ordersId);
    }

    @Override
    public void clearOrder(Order order) {
        this.ordersId.remove(order.getId());
    }

}
