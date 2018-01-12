package models;

import java.util.ArrayList;

public class Team {
    private String name;
    private String description;
    private ArrayList<Member> members;
    public Team(String name, String description, ArrayList<Member> members) {
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public String getName() {
        return this.name;
    }
}
