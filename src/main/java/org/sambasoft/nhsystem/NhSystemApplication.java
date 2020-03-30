package org.sambasoft.nhsystem;

import org.sambasoft.nhsystem.entities.User;
import org.sambasoft.nhsystem.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NhSystemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NhSystemApplication.class, args);
    }

UserService userService;

    public NhSystemApplication(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
      /*  {
            User newUser = new User("user1@mail.com",
                    "user1","1234user1");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("admin1@mail.com",
                    "admin1","1234admin1");
            userService.createAdmin(newUser);
        }*/
    }
}
