package am.hitech.jdbc.service;

import am.hitech.jdbc.exeption.InternalServerEror;
import am.hitech.jdbc.exeption.NotFoundExeption;
import am.hitech.jdbc.model.Adress;
import am.hitech.jdbc.repo.AdressRepo;

import java.util.List;

public class AdressServise {
    AdressRepo adressRepo = new AdressRepo();

    public void creatAdress(Adress adress) throws InternalServerEror {
        int row = adressRepo.creatAdress(adress);
        if(row == 0){
            throw new InternalServerEror("creat eror");
        }
    }
    public void deleteAdress(int id) throws InternalServerEror {
        int row = adressRepo.deleteAdress(id);
        if(row == 0){
            throw new InternalServerEror("delete eror");
        }
    }
    public void updateAdress(Adress adress) throws InternalServerEror {
        int row = adressRepo.updateAdress(adress);
        if (row == 0) {
            throw new InternalServerEror("erorr");
        }
    }

    public Adress getById(int id) throws NotFoundExeption {
        Adress adress = adressRepo.getById(id);
        if (adress == null) {
            throw new NotFoundExeption("invalid id");
        }
        return adress;
    }

    public List<Adress> getAllAdress() throws InternalServerEror {
        try {
            return adressRepo.getAllAdress();
        } catch (RuntimeException e) {
            throw new InternalServerEror("runtimeExeption");
        }
    }
}
