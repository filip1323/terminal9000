package backend;

/**
 * Created by Filip on 2015-07-23.
 */
public interface Product {
    int getPrice();
    String getName();
    String getCategory();
    interface ProductBuilder{
        Product build();
        void setName(String name);
        void setCategory(String category);
        void setPrice(int price);
    }
}
