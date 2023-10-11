package fr.jaipasid.remiseenforme.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import fr.jaipasid.remiseenforme.R;
import fr.jaipasid.remiseenforme.Room.UserEntity;
import fr.jaipasid.remiseenforme.ViewModel.ViewModelFactory;
import fr.jaipasid.remiseenforme.ViewModel.ViewModelUser;

public class CreateProfile extends AppCompatActivity {



    private List<UserEntity> mUserEntities;
    private ViewModelUser mViewModelUser;

    private final ArrayList<UserEntity> mUserEntityArrayList =new ArrayList<>();

    @NonNull
    private final ArrayList<UserEntity> tasks =new ArrayList<>();

    EditText name, firstName, photoProfile;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);


        name = findViewById(R.id.name);
        firstName = findViewById(R.id.firstName);
        photoProfile = findViewById(R.id.photoProfile);
        save = findViewById(R.id.saveInformation);

        mViewModelUser =new ViewModelProvider(this, ViewModelFactory.getInstance(CreateProfile.this)).get(ViewModelUser.class);
        mViewModelUser.getListLiveData().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> pUserEntities) {
                mUserEntities =pUserEntities;
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View pView) {
                onPositiveButtonClick();
                Intent lvIntent = new Intent(CreateProfile.this, MainActivity.class);
                startActivity(lvIntent);

            }
        });
    }
    private void addTask(UserEntity task){
        mViewModelUser.insertUser(task);
    }


    private void onPositiveButtonClick() {
        if (name != null && firstName != null && photoProfile != null) {
            String userName = name.getText().toString();
            String userFirstName = firstName.getText().toString();
            String userphotoProfile = photoProfile.getText().toString();


            if (userName.trim().isEmpty() || userFirstName.trim().isEmpty() || userphotoProfile.trim().isEmpty()) {

            } else {
                UserEntity newUser = new UserEntity(
                        userName,
                        userFirstName,
                        userphotoProfile);
                addTask(newUser);

            }

        }
    }

}


