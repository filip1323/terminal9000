package ctrl;

import backend.MenuImpl;
import backend.Product;
import backend.Table;
import editor.TableSetupImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Filip on 2015-07-25.
 */
@RestController
@RequestMapping(value = "/rest/*")
public class RESTController {


    @RequestMapping(value="/rest/single", method = RequestMethod.POST)
    public @ResponseBody TableSetupImpl singleTable( @RequestBody final TableSetupImpl tableSetup) {
        System.out.println("REST CONTROLLER REQUEST SINGLE");
        //for(TableSetupImpl tableSetup : tableSetups)
        //   DatabaseImpl.getInstance().addTableSetup(tableSetup);
        //System.out.println(tableSetup);
        return tableSetup;
    }

    @RequestMapping(value="/rest/multi", method = RequestMethod.POST)
    public @ResponseBody List<TableSetupImpl> multipleTables( @RequestBody final List<TableSetupImpl> tableSetups) {
        System.out.println("REST CONTROLLER REQUEST MULTI");
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        editor.Database database = context.getBean("databaseEditor", editor.Database.class);
        for(TableSetupImpl tableSetup : tableSetups)
           database.addTableSetup(tableSetup);
        database.applyChanges();
        return tableSetups;
    }

    @RequestMapping(value="/rest/gettables", method = RequestMethod.POST)
    public @ResponseBody List<Table> getTables(  @RequestBody List<Table> incoming ) {
        System.out.println("REST CONTROLLER REQUEST GETTABLES");
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        backend.Database database = context.getBean("databaseManager", backend.Database.class);

        incoming = database.getTableSetup();

        return incoming;
    }
}
