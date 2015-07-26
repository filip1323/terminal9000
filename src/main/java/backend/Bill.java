package backend;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Bill {
    int getPrice();
    Order getOrder();

    interface BillBuilder {
        void setPrice(int price);
        void addOrder(Order order);
    }
}
