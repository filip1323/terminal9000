package backend;

import ctrl.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.rmi.UnexpectedException;

/**
 * Created by Filip on 2015-07-26.
 */
public class BillImpl implements Bill {

    private int orderId;

    @Autowired
    private ApplicationContext context;

    public BillImpl(Order order){
        this.orderId = order.getId();
    }

    @Override
    public int getPrice() {

        int price = 0;
        for(Product product : getOrder().getProducts()) price += product.getPrice();
        return price;

    }

    @Override
    public Order getOrder() {
        MainController controller = context.getBean("mainController", MainController.class);


        try {
            return controller.getOrderWithId(orderId);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
