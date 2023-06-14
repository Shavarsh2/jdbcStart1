package am.hitech.jdbc;

import am.hitech.jdbc.autoTest.TestClass;
import am.hitech.jdbc.interfaces.UserRepo;
import am.hitech.jdbc.interfaces.UserRepository;
import am.hitech.jdbc.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        UserRepo userRepo = context.getBean(UserRepo.class);
        Pageable pageable = PageRequest.of(1,2);
        Page<User> userPage = userRepo.getAll(pageable);

        //List<User> users = userRepo.findAllByAge(45);
        //userRepo.updateAge(15,1);
        // User user = userRepo.getByEmailAndAge("vaxo@gmail.com",45);
        //long user = userRepo.count();
        //User user = userRepo.getByUsernameAndAge1("hayko@gmail.com",14);
        //user.setEmail(user.getEmail() + "_new1");
        //user.setId(0);
        //userRepo.save(user);
        //userRepo.deleteById(user.getId());
        //userRepo.delete(user);


    }
}
