package com.sib4u.chatbox.models;

public class UserModel {
    private String name, number, photo, story ;

    public UserModel() {
    }


    public UserModel(String name, String number, String photo,String story) {
        this.name = name;
        this.number = number;
        this.photo = photo;
        this.story=story;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", photo='" + photo + '\'' +
                ", story='" + story + '\'' +
                '}';
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
