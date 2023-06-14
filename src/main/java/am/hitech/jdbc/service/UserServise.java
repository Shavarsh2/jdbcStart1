package am.hitech.jdbc.service;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.ModelFormExeption;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.interfaces.UserRepository;
import am.hitech.jdbc.model.User;
import am.hitech.jdbc.repo.UserRepoJpa;

import java.util.List;

public class UserServise {
    UserRepository userRepo = new UserRepoJpa();

    //UserRepo userRepo;
    //public UserServise(UserRepo userRepo){
    //    this.userRepo = userRepo;
    //}

   public List<User> getByNameSearch1(String name,String userName)  {//petq chi
       List<User> users = null;
       String name1 = name.toLowerCase();
       String name2 = userName.toLowerCase();
       return userRepo.getByNameSearch(name1,name2);
   }
    public List<User> getByName(String name) {
        List<User> users = userRepo.getByName(name);
        return users;
    }

    public void deleteUser(User user) throws InternalServerEror {
        int row = userRepo.deleteUser(user);
        if (row == 0) {
            throw new InternalServerEror("delete eror");
        }
    }

    public void updateUser(User user) throws InternalServerEror {
        int row = userRepo.updateUser(user);
        if (row == 0) {
            throw new InternalServerEror("update eror");
        }
    }

    public void creatUserV2(User user) throws InternalServerEror, ModelFormExeption, NotFoundExeption {
        User user1 = formUser(user);
        int row = userRepo.creatUserV2(user1);

        if (row == 0) {
            throw new InternalServerEror("erorr");
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

    public User getbyPassToken(String pass) throws NotFoundExeption {
        User user = userRepo.getbyPassToken(pass);
        if (user == null) {
            throw new NotFoundExeption("invalid password_token");
        }
        return user;
    }

    public void updateUserPass(User user) throws InternalServerEror {
        int row = userRepo.updateUserPass(user);
        if (row == 0) {
            throw new InternalServerEror("update eror");
        }
    }

    private User formUser(User user) throws ModelFormExeption {
        int count = 0;
        boolean a = false;
        String text;
        int shnikCount = 0;

        if (user.getAge() > 10 && user.getAge() < 100 && user.getFirstName().length() >= 3 && user.getLastName().length() >= 3) {
            if (user.getPassword().length() >= 6) {
                int lowerCount = 0;
                int upperCount = 0;
                int numberCount = 0;
                for (int i = 0; i < user.getPassword().length(); i++) {
                    if (user.getPassword().charAt(i) >= 97 && user.getPassword().charAt(i) <= 122) {
                        lowerCount++;
                    } else if (user.getPassword().charAt(i) >= 65 && user.getPassword().charAt(i) <= 90) {
                        upperCount++;
                    } else if (user.getPassword().charAt(i) >= 48 && user.getPassword().charAt(i) <= 57) {
                        numberCount++;
                    }
                }
                if (lowerCount >= 2 && upperCount >= 2 && numberCount >= 2) {
                    a = true;
                }
            }
            for (int i = 0; i < user.getEmail().length(); i++) {
                if (user.getEmail().charAt(i) == 64) {
                    shnikCount++;
                    text = user.getEmail().substring(i);
                    if (shnikCount == 1) {
                        for (int j = 0; j < text.length(); j++) {
                            if ((text.charAt(j) >= 97 && text.charAt(j) <= 122)) {
                                count++;
                            } else if (text.charAt(j) == 46) {
                                break;
                            }
                        }
                    }
                }
            }
            if (a && shnikCount == 1 && count >= 3 && (user.getEmail().endsWith(".com") || user.getEmail().endsWith(".ru"))) {
                return user;
            }
        }
        throw new ModelFormExeption("form error");
    }
    //public Map<Integer, User> getAllNumberMap() {
    //    Map<Integer, User> map = userRepo.getAllNumberMap();
    //    return map;
    //}
    // public User getByIdWeb() {
    //     User user = userRepo.getByIdWeb();
    //     return user;
    // }
    //public List<NumberUser> getAllNumbers() {
    //    List<NumberUser> list = userRepo.getAllNumber();
    //    return list;
    //}

    //public User findName(String name) throws NotFoundExeption {//list veradarcni**
    //        User user = userRepo.findEmail(name);
    //    if (user == null) {
    //        throw new NotFoundExeption("name exists");
    //    }
    //    return user;
    //}

    //public List<User> getMaxAge18() throws InternalServerEror {
    //    try {
    //        return userRepo.getMaxAge18();
    //    } catch (RuntimeException e) {
    //        throw new InternalServerEror("something went wrong");
    //    }
    //}


}
