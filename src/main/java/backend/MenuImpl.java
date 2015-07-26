package backend;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-27.
 */
public class MenuImpl implements Menu {

    private ArrayList<Product> products;
    public MenuImpl(ArrayList<Product> products){
        this.products = products;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    @Override
    public ArrayList<Product> getAllProductsWithCategory(String categoryName) {

        ArrayList<Product> matchingProducts = new ArrayList<Product>();
        for(Product product : this.products){
            if(product.getCategory().equals(categoryName)) matchingProducts.add(product);
        }
        return matchingProducts;
    }

    @Override
    public Product getProduct(String name) throws UnexpectedException{
        for(Product product : this.products){
            if(product.getName().equals(name)) return product;
        }
        throw new UnexpectedException("No product with name: " + name);
    }
}
