package ctrl;

import backend.MenuImpl;
import backend.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Filip on 2015-07-26.
 */
public class MainController {
    private static ApplicationContext context;
    public void init(){
//        if(context == null)
//            context = new ClassPathXmlApplicationContext("context.xml");
//        MenuImpl menu = context.getBean("menu", MenuImpl.class);
//        for(Product product : menu.getAllProducts()){
//            System.out.println(product.getName());
//        }
        System.out.println("Application has began");
    }
}
