package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User userExemple1 = new User("Магомед", "Зулпукаров", "pochta@mail.ru");
        User userExemple2 = new User("Магомед", "Зулпукаров", "pochta@mail.ru");
        User userExemple3 = new User("Магомед", "Зулпукаров", "pochta@mail.ru");

        userExemple1.setCar(new Car("Lada", 2107));
        userExemple2.setCar(new Car("Lada", 2107));
        userExemple3.setCar(new Car("Lada", 2107));

        userService.add(userExemple1);
        userService.add(userExemple2);
        userService.add(userExemple3);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<User> users2 = userService.findUsers("Lada", 2107);
        for (User user : users2) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
