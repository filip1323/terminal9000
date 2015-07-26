package backend;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Filip on 2015-07-26.
 */
public class DatabaseImpl implements Database {


    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public DatabaseImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    ArrayList<Product> products;

    @Override
    public ArrayList<Product> getAllProducts() {

        if (this.products == null) {

            String query = "SELECT * FROM `Products`";

            ArrayList<Product> products = new ArrayList<Product>();

            List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(query);
            for (Map row : rows) {
                Product.ProductBuilder productBuilder = new ProductBuilderImpl();
                productBuilder.setPrice((Integer) row.get("price"));
                productBuilder.setName((String) row.get("name"));
                productBuilder.setCategory((String) row.get("category"));
                products.add(productBuilder.build());
            }
            this.products = products;
        }

        return this.products;
    }

    ArrayList<Table> tables;

    @Override
    public ArrayList<Table> getTableSetup() {

        if (this.tables == null) {

            String query = "SELECT * FROM `TableSetups`";

            ArrayList<Table> tables = new ArrayList<Table>();

            List<Map<String, Object>> rows = jdbcTemplateObject.queryForList(query);
            for (Map row : rows) {
                Table table = new TableImpl();
                table.setHeight((Integer) row.get("height"));
                table.setWidth((Integer) row.get("width"));
                table.setxCoord((Integer) row.get("xCoord"));
                table.setyCoord((Integer) row.get("yCoord"));
                table.setId((String) row.get("id"));
                tables.add(table);
            }
            this.tables = tables;
        }
        return tables;
    }
}
