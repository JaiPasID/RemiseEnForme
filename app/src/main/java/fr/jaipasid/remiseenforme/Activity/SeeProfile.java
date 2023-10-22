package fr.jaipasid.remiseenforme.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import fr.jaipasid.remiseenforme.Adapteur.MyUserRecyclerViewAdapter;
import fr.jaipasid.remiseenforme.R;
import fr.jaipasid.remiseenforme.Room.UserEntity;
import fr.jaipasid.remiseenforme.ViewModel.ViewModelFactory;
import fr.jaipasid.remiseenforme.ViewModel.ViewModelUser;

public class SeeProfile extends AppCompatActivity {


    //TODO Utiliser l'adapteur Creer instance de viewModel


    private List<UserEntity> mUserEntities;
    private ViewModelUser mViewModelUser;

    MyUserRecyclerViewAdapter myUserRecyclerViewAdapter;

    private final ArrayList<UserEntity> mUserEntityArrayList =new ArrayList<>();

    @NonNull
    private final ArrayList<UserEntity> tasks =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_profile);



        // Pour creer une instance de viewModel
        mViewModelUser =new ViewModelProvider(this,ViewModelFactory.getInstance(SeeProfile.this)).get(ViewModelUser .class);


        mViewModelUser.getListLiveData().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> pUserEntities) {
                mUserEntities =pUserEntities;
                myUserRecyclerViewAdapter = new MyUserRecyclerViewAdapter(mUserEntities);
            }
        });
    }


}