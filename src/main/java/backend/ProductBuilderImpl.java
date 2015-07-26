package backend;

/**
 * Created by Filip on 2015-07-26.
 */
public class ProductBuilderImpl implements Product.ProductBuilder {

    private String name;
    private String category;
    private int price;

    @Override
    public Product build() {
        return new ProductImpl(name,category,price);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
