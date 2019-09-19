package com.albert.musiclive;

import java.io.Serializable;

public class User implements Serializable {
private String Name;
private String Password;
private String phone,email,adress,image,userName,nbreAbon,createAt,updateAt;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNbreAbon() {
        return nbreAbon;
    }

    public void setNbreAbon(String nbreAbon) {
        this.nbreAbon = nbreAbon;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User() {
    }

    public User(String name, String password, String phone, String email, String adress, String image, String userName, String nbreAbon, String createAt, String updateAt) {
        Name = name;
        Password = password;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.image = image;
        this.userName = userName;
        this.nbreAbon = nbreAbon;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
