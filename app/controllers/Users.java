package controllers;
 
import static controllers.Security.authenticate;
import models.User;
import play.*;
import play.mvc.*;

@With(Secure.class)
@Check("administrator")
public class Users extends CRUD {  

    @Before
    static void admin() {
        if (!authenticate("test@test.com", "test")) {
            User admin = new User();
            admin.name = "test";
            admin.email = "test@test.com";
            admin.password = "test";
            admin.save();
            System.out.println("test");
        }
    }
}
