package user.system.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import user.system.entities.User;
import user.system.servicesImpl.TownServiceImpl;
import user.system.servicesImpl.UserServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
public class ConsoleReader implements CommandLineRunner {

    private final UserServiceImpl userServiceInter;
    private final TownServiceImpl townServiceInterf;

    @Autowired
    public ConsoleReader(UserServiceImpl userServiceInter, TownServiceImpl townServiceInterf) {
        this.userServiceInter = userServiceInter;
        this.townServiceInterf = townServiceInterf;
    }


    @Override
    public void run(String... strings) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       // seedDatabase();
//
     //   Get user by email provider

//        String provider = reader.readLine();
//        List<Object[]> usersByProvider = this.userServiceInter.getUsersByEmailProvider(provider);
//
//        if (usersByProvider.isEmpty()){
//            System.out.println("No user with such provider");
//        }
//        else {
//            usersByProvider.stream().forEach(k->
//                    System.out.println(k[0] + " " + k[1]));
//        }

        //Count users with bigger pictures


        //Remove Inactive Users

//        String inputDateASString = reader.readLine();
//
//        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
//
//        Date inputDate = date.parse(inputDateASString);
//
//        List<User> inactiveUsers = this.userServiceInter.getNotActiveUsers(inputDate);
//
//        int userCount = inactiveUsers.size();
//
//        if (userCount<=0){
//            System.out.println("No users have been deleted");
//        }else if(userCount == 1){
//            System.out.println("1 user has been deleted");
//            this.userServiceInter.delete(inactiveUsers.get(0));
//        }
//        else {
//            System.out.printf("%f users have been deleted", userCount);
//            for (User user:inactiveUsers) {
//                this.userServiceInter.delete(user);
//            }
//        }

    }
    private void seedDatabase()throws ParseException {

        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");

        User user = new User();
        user.setUsername("Vader");
        user.setPassword("pklgshS123?");
        user.setEmail("vader@abv.bg");
        user.setAge(15);
        user.setLastTimeLoggedIn(date.parse("03.06.2013"));

        this.userServiceInter.persist(user);

        User user2 = new User();
        user2.setUsername("Vladimir");
        user2.setPassword("klK523?");
        user2.setEmail("vlado@abv.com");
        user2.setAge(55);
        user2.setLastTimeLoggedIn(date.parse("23.05.2015"));

        this.userServiceInter.persist(user2);

        User user3 = new User();
        user3.setUsername("Nikol");
        user3.setPassword("paS123?");
        user3.setEmail("nikol@abv.bg");
        user3.setAge(35);
        user3.setLastTimeLoggedIn(date.parse("10.06.2014"));

        this.userServiceInter.persist(user3);

        User user4 = new User();
        user4.setUsername("Iskra");
        user4.setPassword("iskraS123?");
        user4.setEmail("iskra@gmail.bg");
        user4.setAge(18);
        user4.setLastTimeLoggedIn(date.parse("10.10.2016"));

        this.userServiceInter.persist(user4);
    }
}
