package fr.jaipasid.remiseenforme.Adapteur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fr.jaipasid.remiseenforme.Model.InformationUserList;
import fr.jaipasid.remiseenforme.R;

public class MyUserRecyclerViewAdapter extends RecyclerView.Adapter<MyHolderUsers> {

    private final List<InformationUserList> mUser;


    public MyUserRecyclerViewAdapter(List<InformationUserList> mUser) {
        this.mUser = mUser;
    }
    @NonNull
    @Override
    public MyHolderUsers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_users, parent, false);
        MyHolderUsers holder = new MyHolderUsers(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderUsers holder, int position) {
        InformationUserList user = mUser.get(position);
        holder.name.setText(user.getName());
        holder.firstName.setText(user.getAge());
        holder.photoProfile.setText(user.getPhotoProfile());


    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }
}
