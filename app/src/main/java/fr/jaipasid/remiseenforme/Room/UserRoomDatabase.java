package fr.jaipasid.remiseenforme.Room;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

import fr.jaipasid.remiseenforme.Activity.CreateProfile;


@Database(entities = (UserEntity.class), version = 1, exportSchema = false)
public abstract class UserRoomDatabase extends RoomDatabase {
    private static final String DB_Name = "DataRoom";
    private static UserRoomDatabase instance;

    public static synchronized UserRoomDatabase getInstance(Context pContext){
        if(instance == null){
            instance = Room.databaseBuilder(pContext.getApplicationContext(), UserRoomDatabase.class, DB_Name)
                    .fallbackToDestructiveMigration()
                    //ne sert que dans le cas de test addCallback
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    public abstract UserDAO mUserDAO();


    //No Obligatoire seulement pour test
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        /**
         * Called when the database is created for the first time. This is called after all the
         * tables are created.
         *
         * @param db The database.
         */
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            Executors.newSingleThreadExecutor().execute(() -> {

                instance.mUserDAO().insertUser(new UserEntity("name","age","photoProfile"));


            });

        }
    };
}
