package models;

import java.util.ArrayList;

public class Member {
    private String name;
    private String email;
    private String favoriteColor;
    private ArrayList<String> skills;
    public Member(String name, String email, String favoriteColor, ArrayList<String> skills) {
        this.name = name;
        this.email = email;
        this.favoriteColor = favoriteColor;
        this.skills = skills;
    }
}
