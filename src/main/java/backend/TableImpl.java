package backend;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ctrl.MainController;
import editor.TableSetupImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-26.
 */
public class TableImpl extends TableSetupImpl implements Table {

    private ArrayList<Order> orders = new ArrayList<Order>();

    @JsonIgnore
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
