package fr.jaipasid.remiseenforme.Adapteur;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import fr.jaipasid.remiseenforme.R;


public class MyHolderUsers extends RecyclerView.ViewHolder {

    TextView name, firstName, photoProfile;
    public MyHolderUsers(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.userName);
        firstName = itemView.findViewById(R.id.firstName);
        photoProfile = itemView.findViewById(R.id.userPhotoProfile);

    }
}
