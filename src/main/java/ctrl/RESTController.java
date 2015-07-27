package ctrl;

import backend.*;
import editor.TableSetupImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.rmi.UnexpectedException;
import java.util.List;

/**
 * Created by Filip on 2015-07-25.
 */
@RestController
@RequestMapping(value = "/rest/*")
public class RESTController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping(value="/rest/save-table-setups", method = RequestMethod.POST)
    public @ResponseBody List<TableSetupImpl> saveTableSetups( @RequestBody final List<TableSetupImpl> tableSetups) {

        editor.Database database = context.getBean("databaseEditor", editor.Database.class);
        for(TableSetupImpl tableSetup : tableSetups)
           database.addTableSetup(tableSetup);
        database.applyChanges();
        return tableSetups;
    }

    @RequestMapping(value="/rest/get-tables", method = RequestMethod.POST)
    public @ResponseBody List<Table> getTables(  @RequestBody List<Table> incoming ) {
        backend.Database database = context.getBean("databaseManager", backend.Database.class);

        incoming = database.getTableSetup();

        return incoming;
    }

    @RequestMapping(value="/rest/get-table", method = RequestMethod.POST)
    public @ResponseBody Table getTable(  @RequestBody String id ){
        backend.Database database = context.getBean("databaseManager", backend.Database.class);
        MainController controller = context.getBean("mainController", MainController.class);
        Table table;

        table =  controller.getTableWithId(id);

        System.out.println("table given");
        return table;
    }

    @RequestMapping(value="/rest/create-order", method = RequestMethod.POST)
    public @ResponseBody
    void createOrder(  @RequestBody TableImpl table ){
        MainController controller = context.getBean("mainController", MainController.class);

        Order order = controller.createOrder(table);

        System.out.println("Order created");
    }

    @RequestMapping(value="/rest/get-order", method = RequestMethod.POST)
    public @ResponseBody
    Order getOrder(  @RequestBody Integer orderId ){
        MainController controller = context.getBean("mainController", MainController.class);
        Order order = null;
        try {
            order = controller.getOrderWithId(orderId);
        } catch (UnexpectedException e) {
            e.printStackTrace();
        }

        return order;
    }


}
