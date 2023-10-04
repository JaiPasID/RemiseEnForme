package fr.jaipasid.remiseenforme.Class;

public class InformationUserList {

    String name;
    int age;
    String photoProfile;


    /** Constructor
     *
     * @param name
     * @param age
     * @param photoProfile
     */
    public InformationUserList(String name, int age, String photoProfile) {
        this.name = name;
        this.age = age;
        this.photoProfile = photoProfile;
    }

    /** Getter Settere*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }
}
