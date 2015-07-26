package backend;

/**
 * Created by Filip on 2015-07-26.
 */
public class BillImpl implements Bill {

    private Order order;

    public BillImpl(Order order){
        this.order = order;
    }

    @Override
    public int getPrice() {

        int price = 0;
        for(Product product : order.getProducts()) price += product.getPrice();
        return price;

    }

    @Override
    public Order getOrder() {
        return order;
    }
}
