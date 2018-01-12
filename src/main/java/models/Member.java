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
        return "";
    }

}
