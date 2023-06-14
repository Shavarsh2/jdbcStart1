package am.hitech.jdbc;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.model.Adress;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.servise.AdressServise;
import am.hitech.jdbc.servise.UserServise;

import java.util.List;

public class Main {
    UserServise userServise = new UserServise();
    AdressServise adressServise = new AdressServise();

    public static void main(String[] args) throws InternalServerEror, NotFoundExeption {
        Main main = new Main();



    }
}
