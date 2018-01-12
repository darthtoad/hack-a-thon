package models;

import java.util.ArrayList;

public class Member {
    private String firstName;
    private String lastName;
    private String email;
    private String favoriteColor;
    private ArrayList<String> skills;
    public Member(String firstName, String lastName, String email, String favoriteColor, ArrayList<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favoriteColor = favoriteColor;
        this.skills = skills;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFavoriteColor() {
        return this.favoriteColor;
    }

    public ArrayList<String> getSkills() {
        return this.skills;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
