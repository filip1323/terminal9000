package editor;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-25.
 */
public class DatabaseImpl implements Database {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public DatabaseImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void addProduct(ProductSetup productSetup) {
    }

    public ArrayList<String> tableSetupQuery = new ArrayList<String>();

    @Override
    public void addTableSetup(TableSetup tableSetup) {
        String query = "INSERT INTO `TableSetups` (`id`,`xCoord`,`yCoord`, `width`, `height`) VALUES(" +
                "'" + tableSetup.getId() + "'," +
                "'" + tableSetup.getxCoord() + "'," +
                "'" + tableSetup.getyCoord() + "'," +
                "'" + tableSetup.getWidth() + "'," +
                "'" + tableSetup.getHeight() + "');\n";
        tableSetupQuery.add(query);
    }

    @Override
    public void applyChanges() {
        jdbcTemplateObject.update("TRUNCATE TABLE TableSetups");
        for(String query : tableSetupQuery)
            jdbcTemplateObject.update(query);
    }
}
