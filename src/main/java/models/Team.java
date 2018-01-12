package models;

import java.util.ArrayList;

public class Team {
    private String name;
    private String description;
    private ArrayList<Member> members;
    private static ArrayList<Team> instances = new ArrayList<>();
    private int teamId;
    public Team(String name, String description, ArrayList<Member> members) {
        this.name = name;
        this.description = description;
        this.members = members;
        instances.add(this);
        this.teamId = instances.size();
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

    public int getTeamId() {
        return this.teamId;
    }

    public static ArrayList<Team> getAllTeams() {
        return instances;
    }

    public static void clearAllTeams() {
        instances.clear();
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }
}
