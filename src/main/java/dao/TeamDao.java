package dao;

import models.Member;
import models.Team;

import java.util.List;

public interface TeamDao {
    void add (Team team);

    List<Team> getAll();
//
//    List<Member> getAllTeamMembers(int teamId);
//
    Team findById(int teamId);
//
    void editTeam(String name, String description, int teamId);
//
    void deleteById(int teamId);
//
    void clearAllTeams();
}
