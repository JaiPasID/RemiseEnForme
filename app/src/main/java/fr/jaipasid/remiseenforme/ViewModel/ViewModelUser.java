package fr.jaipasid.remiseenforme.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import fr.jaipasid.remiseenforme.Model.InformationUserList;
import fr.jaipasid.remiseenforme.Room.UserEntity;
import fr.jaipasid.remiseenforme.Repository.UserRepository;

public class ViewModelUser extends ViewModel {

        private UserRepository mUserRepository;
        private Executor mExecutor;

        public ViewModelUser(UserRepository pUserRepository) {
            //injection de dependance
            mUserRepository = pUserRepository;
            mExecutor = Executors.newFixedThreadPool(2);
        }

        public void insertUser(UserEntity pUserEntity){
            mExecutor.execute(()->mUserRepository.insert(pUserEntity));
        }

        public void updateUser(UserEntity pUserEntity){
            mExecutor.execute(()->mUserRepository.update(pUserEntity));
        }

        public void delete(UserEntity pUserEntity){
            mExecutor.execute(()->mUserRepository.delete(pUserEntity));
        }

        public LiveData<List<UserEntity>> getListLiveData (){

            return mUserRepository.getAllUser();}
}