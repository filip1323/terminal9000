package ctrl;

import backend.Database;
import backend.MenuImpl;
import backend.Product;
import backend.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * Created by Filip on 2015-07-26.
 */
public class MainController {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private Database database;

    private ArrayList<Table> tablesInUse;
    public void init(){
        System.out.println("Application has began");
        tablesInUse = database.getTableSetup();
    }

    public Table getTableWithId(String id) throws UnexpectedException{
        for(Table table : tablesInUse){
            if(table.getId().equals(id)) return table;
        }
        throw new UnexpectedException("No table with id: " + id);
    }
}
