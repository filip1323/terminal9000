package backend;

import ctrl.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-26.
 */
public class OrderImpl implements Order {
    static private int number;
    private int id;
    private ArrayList<Product> products;
    private Bill bill;
    private String tableId;

    @Autowired
    private ApplicationContext context;

    public OrderImpl() {
        id = number++;
        products = new ArrayList<Product>();
        bill = new BillImpl(this);
    }



    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void setTable(Table table) {
        this.tableId = table.getId();
    }

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Table getTable() throws UnexpectedException {
        MainController controller = context.getBean("mainController", MainController.class);
        return controller.getTableWithId(tableId);
    }

    @Override
    public Bill getBill() {
        return this.bill;
    }
}
