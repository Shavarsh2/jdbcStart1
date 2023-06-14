package am.hitech.jdbc;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.ModelFormExeption;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.model.NumberUser;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.repo.UserRepoJdbc;
import am.hitech.jdbc.repo.UserRepoJpa;
import am.hitech.jdbc.service.AdressServise;
import am.hitech.jdbc.service.UserServise;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ModelFormExeption {
       //UserRepoJdbc userRepoJdbc = new UserRepoJdbc();    //servisi mej constructor ka
       //UserRepoJpa userRepoJpa = new UserRepoJpa();
       //UserServise userServise;//kanstruktrov
       //if(args[0].equals("jdbc")){
       //    userServise = new UserServise(userRepoJdbc);
       //}else if(args[0].equals("jpa")){
       //    userServise = new UserServise(userRepoJpa);
       //}

       // UserServise userRepoJpa = new UserServise();
       // List<User> users = userRepoJpa.getByNameSearch1("a","k");
       // System.out.println(users);
        UserRepoJdbc userRepoJdbc = new UserRepoJdbc();
        User user = userRepoJdbc.getById(1);
        System.out.println(user);




    }
}
