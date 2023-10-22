package fr.jaipasid.remiseenforme.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface UserDAO {


    @Insert
    void insertUser(UserEntity pUserEntity);

    @Update
    void updateUser(UserEntity pUserEntity);


    //On peut faire un delete par id
    @Delete
    void deleteUser (UserEntity pUserEntity);


    @Query("DELETE FROM data_user")
    void deleteAll();

    @Query("SELECT * FROM data_user")
    LiveData<List<UserEntity>> getUserInformation();

}
