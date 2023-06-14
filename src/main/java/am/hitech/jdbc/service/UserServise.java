package am.hitech.jdbc.servise;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.repo.UserRepo;

import java.util.List;

public class UserServise {
    UserRepo userRepo = new UserRepo();

    public void deleteUser(String email) throws InternalServerEror {
        int row = userRepo.deleteEmail(email);
        if(row == 0){
            throw new InternalServerEror("delete eror");
        }
    }
    public void updateUser(User user) throws InternalServerEror {
        int row = userRepo.updateUser(user);
        if (row == 0) {
            throw new InternalServerEror("update eror");
        }
    }

    public void creatUserV2(User user) throws InternalServerEror {
        int row = userRepo.creatUserV2(user);

        if (row == 0) {
            throw new InternalServerEror("erorr");
        }

    }

    public User findName(String name) throws NotFoundExeption {//list veradarcni**
        User user = userRepo.findName(name);
        if (user == null) {
            throw new NotFoundExeption("the name is not in the database");
        }
        return user;
    }

    public List<User> getMaxAge18() throws InternalServerEror {
        try {
            return userRepo.getMaxAge18();
        } catch (RuntimeException e) {
            throw new InternalServerEror("something went wrong");
        }
    }

    public User getById(int id) throws NotFoundExeption, InternalServerEror {
        try {
            User user = userRepo.getById(id);
            if (user == null) {
                throw new NotFoundExeption("invalid id");
            }
            return user;
        } catch (RuntimeException e) {
            throw new InternalServerEror("something went wrong");
        }
    }

    public User getByUsername(String name) throws NotFoundExeption, InternalServerEror {
        try {
            User user = userRepo.getByUsername(name);
            if (user == null) {
                throw new NotFoundExeption("invalid name");
            }
            return user;
        } catch (RuntimeException e) {
            throw new InternalServerEror("something went wrong");
        }
    }
}
