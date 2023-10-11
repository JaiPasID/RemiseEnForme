package fr.jaipasid.remiseenforme.Room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "data_user")
public class UserEntity {


    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo (name = "Name")
    private String name;

    @ColumnInfo (name = "Age")
    private String  age;

    @ColumnInfo (name = "PhotoProfile" )
    private String photoProfile;


    public UserEntity(){}

    public UserEntity(String name, String age, String photoProfile) {
        this.name = name;
        this.age = age;
        this.photoProfile = photoProfile;
    }
}
