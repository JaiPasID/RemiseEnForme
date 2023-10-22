package fr.jaipasid.remiseenforme.ViewModel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import fr.jaipasid.remiseenforme.Activity.CreateProfile;
import fr.jaipasid.remiseenforme.Repository.UserRepository;
import fr.jaipasid.remiseenforme.Room.UserRoomDatabase;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory sViewModelFactory;
    private UserRepository pUserRepository;


    public static ViewModelFactory getInstance(Context pContext){
        if  (sViewModelFactory == null) {
            synchronized (ViewModelFactory.class){
                sViewModelFactory = new ViewModelFactory(pContext);
            }
        }
        return sViewModelFactory;
    }

    public ViewModelFactory(Context pContext) {
        UserRoomDatabase lvDatabaseRoom =UserRoomDatabase.getInstance(pContext);
        pUserRepository = new UserRepository(lvDatabaseRoom.mUserDAO());

    }



    /**
     * Creates a new instance of the given {@code Class}.
     * <p>
     *
     * @param modelClass a {@code Class} whose instance is requested
     * @return a newly created ViewModel
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(ViewModelUser.class)) {

            return (T) new ViewModelUser(pUserRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
