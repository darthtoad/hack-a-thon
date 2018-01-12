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

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Member> getMembers() {
        return this.members;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        //this.description = description;
    }
}
