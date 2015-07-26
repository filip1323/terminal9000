package backend;

/**
 * Created by Filip on 2015-07-26.
 */
public class ProductImpl implements Product {
    private String name;
    private String category;
    private int price;

    public ProductImpl(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
