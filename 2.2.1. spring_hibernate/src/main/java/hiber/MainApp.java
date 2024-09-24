package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {


        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

            UserService userService = context.getBean(UserService.class);
            CarService carService = context.getBean(CarService.class);

            Car carExample = new Car("Priora", 2000);
            Car carExample2 = new Car("Priora", 2000);
            Car carExample3 = new Car("Priora", 2000);
            Car carExample4 = new Car("Lada", 2107);
            Car carExample5 = new Car("Lada", 2107);
            Car carExample6 = new Car("Lada", 2107);
            Car carExample7 = new Car("Lada", 2107);

            carService.add(carExample);
            carService.add(carExample2);
            carService.add(carExample3);
            carService.add(carExample4);
            carService.add(carExample5);
            carService.add(carExample6);
            carService.add(carExample7);

            User userExemple1 = new User("Магомед", "Зулпукаров", "pochta@mail.ru", carExample);
            User userExemple2 = new User("Магомед", "Зулпукаров", "pochta@mail.ru", carExample2);
            User userExemple3 = new User("Магомед", "Зулпукаров", "pochta@mail.ru", carExample3);

            userService.add(userExemple1);
            userService.add(userExemple2);
            userService.add(userExemple3);

            userService.add(new User("User1", "Lastname1", "user1@mail.ru", carExample4));
            userService.add(new User("User2", "Lastname2", "user2@mail.ru", carExample5));
            userService.add(new User("User3", "Lastname3", "user3@mail.ru", carExample6));
            userService.add(new User("User4", "Lastname4", "user4@mail.ru", carExample7));

            List<User> users = userService.listUsers();
            for (User user : users) {
                System.out.println("Id = " + user.getId());
                System.out.println("First Name = " + user.getFirstName());
                System.out.println("Last Name = " + user.getLastName());
                System.out.println("Email = " + user.getEmail());
                System.out.println();
            }

            List<User> users2 = userService.findUsers("Priora", 2000);
            for (User user : users2) {
                System.out.println("Id = " + user.getId());
                System.out.println("First Name = " + user.getFirstName());
                System.out.println("Last Name = " + user.getLastName());
                System.out.println("Email = " + user.getEmail());
                System.out.println();
            }
        }

    }
}
