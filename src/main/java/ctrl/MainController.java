package ctrl;

import backend.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-26.
 */
public class MainController {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private Database database;

    private ArrayList<Table> tablesInUse;
    private ArrayList<Order> ordersInUse;
    public void init(){
        System.out.println("Application has began");
        tablesInUse = database.getTableSetup();
        ordersInUse = new ArrayList<Order>();
    }

    public Table getTableWithId(String id){
        for(Table table : tablesInUse){
            if(table.getId().equals(id)) return table;
        }
        System.out.println("NO TABLE WITH ID " + id);
        return null;
    }

    public Order getOrderWithId(int id) throws UnexpectedException{
        for(Order order : ordersInUse){
            if(order.getId() == id) return order;
        }
        System.out.println("NO ORDER WITH ID: " + id);
        throw new UnexpectedException("No table with id: " + id);
    }

    public Order createOrder(Table table){
        table = getTableWithId(table.getId());
        Order order = context.getBean("order", OrderImpl.class);
        order.setTable(table);
        table.addOrder(order);
        ordersInUse.add(order);
        return order;
    }
}
