package com.albert.musiclive.models;

public class Artist {

    private String artistId;

    private String name,phone,email,adress,image,nbreAbon,createAt,updateAt,songCount;

    public String getSongCount() {
        return songCount;
    }

    public void setSongCount(String songCount) {
        this.songCount = songCount;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Artist(){

    }

    public Artist(String adress,  String createAt,String email, String image,String name,String nbreAbon, String phone, String songCount,String updateAt
                 ) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.image = image;
        this.songCount = songCount;
        if(nbreAbon.trim().equals(""))
        {
            this.nbreAbon = "0";
        }
        else
        {
            this.nbreAbon = nbreAbon;
        }


        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
