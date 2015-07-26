package backend;

import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-26.
 */
public class OrderImpl implements Order {
    private ArrayList<Product> products;
    private Bill bill;

    public OrderImpl() {
        products = new ArrayList<Product>();
        bill = new BillImpl(this);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public Bill getBill() {
        return bill;
    }
}
