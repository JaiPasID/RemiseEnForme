package fr.jaipasid.remiseenforme.Repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.jaipasid.remiseenforme.Room.UserDAO;
import fr.jaipasid.remiseenforme.Room.UserEntity;

public class UserRepository {
    private UserDAO mUserDAO;

    public UserRepository(UserDAO pUserDAO) {
        mUserDAO = pUserDAO;
    }

    public void insert (UserEntity pUserEntity) { mUserDAO.insertUser(pUserEntity);}
    public void update (UserEntity pUserEntity) {mUserDAO.updateUser(pUserEntity);}
    public void delete (UserEntity pUserEntity) {mUserDAO.deleteUser(pUserEntity);}

    public LiveData<List<UserEntity>> getAllUser(){
        return mUserDAO.getUserInformation();
    }
}
