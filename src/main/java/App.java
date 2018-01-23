import models.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import dao.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/hack-a-thon.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oMemberDao memberDao = new Sql2oMemberDao(sql2o);
        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/new/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "new.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("team-name");
            String description = request.queryParams("description");
            Team newTeam = new Team(teamName, description);
            teamDao.add(newTeam);
            model.put("newTeam", newTeam);
            return new ModelAndView(model, "members.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:teamId/members/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int teamId = Integer.parseInt(request.params("teamId"));
            Team newTeam = teamDao.findById(teamId);
            List<Member> allMembers = teamDao.getAllTeamMembers(teamId);
            model.put("allMembers", allMembers);
            model.put("newTeam", newTeam);
            return new ModelAndView(model, "members.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:teamId/members/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String firstName = request.queryParams("first-name");
            String lastName = request.queryParams("last-name");
            String email = request.queryParams("email");
            String favoriteColor = request.queryParams("favorite-color").toLowerCase();
            String skills = request.queryParams("skills");
            int teamId = Integer.parseInt(request.params("teamId"));
            Member newMember = new Member(teamId, firstName, lastName, email, favoriteColor, skills);
            memberDao.add(newMember);
            List<Member> allMembers = teamDao.getAllTeamMembers(teamId);
            Team newTeam = teamDao.findById(teamId);
//            Team currentTeam = Team.findById(Team.getAllTeams().size());
//            ArrayList<Member> allMembers = currentTeam.getMembers();
//            allMembers.add(newMember);
//            Team.findById(Team.getAllTeams().size()).setMembers(allMembers);
            model.put("allMembers", allMembers);
            model.put("newTeam", newTeam);
            return new ModelAndView(model, "members.hbs");
        }, new HandlebarsTemplateEngine());
//
        get("/teams/display/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Team> teams = teamDao.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());
//
        get("/teams/:teamId", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(request.params("teamId"));
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            model.put("foundTeam", foundTeam);
//            List<Member> allMembers = teamDao.getAllTeamMembers(foundTeam.getTeamId());
//            model.put("allMembers", allMembers);
            return new ModelAndView(model, "edit.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:teamId/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(request.params("teamId"));
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            String teamName = request.queryParams("team-name");
            String description = request.queryParams("description");
            teamDao.editTeam(teamName, description, idOfTeamToFind);
            List<Member> allMembers = teamDao.getAllTeamMembers(idOfTeamToFind);
            model.put("foundTeam", foundTeam);
            model.put("allMembers", allMembers);
            return new ModelAndView(model, "edit-members.hbs");
        }, new HandlebarsTemplateEngine());
//
        post("/teams/:teamId/members/:memberId/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(request.params("teamId"));
            int idOfMemberToFind = Integer.parseInt(request.params("memberId"));
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            Member foundMember = memberDao.findById(idOfMemberToFind);
            String firstName = request.queryParams("first-name");
            String lastName = request.queryParams("last-name");
            String email = request.queryParams("email");
            String favoriteColor = request.queryParams("favorite-color").toLowerCase();
            String skills = request.queryParams("skills");
            memberDao.editMember(foundMember.getMemberId(), foundTeam.getTeamId(), firstName, lastName, email, favoriteColor, skills);
            List<Member> allMembers = teamDao.getAllTeamMembers(idOfTeamToFind);
            model.put("foundTeam", foundTeam);
            model.put("allMembers", allMembers);
            return new ModelAndView(model, "edit-members.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/delete/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "delete.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/delete/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            teamDao.clearAllTeams();
            memberDao.clearAllMembers();
            return new ModelAndView(model, "delete-success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:teamId/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToDelete = Integer.parseInt(request.params("teamId"));
            teamDao.deleteById(idOfTeamToDelete);
            List<Team> teams = teamDao.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "display.hbs");
        }, new HandlebarsTemplateEngine());

        post("teams/:teamId/members/:memberId/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfMemberToDelete = Integer.parseInt(request.params("memberId"));
            int idOfTeamToFind = Integer.parseInt(request.params("teamId"));
            memberDao.deleteMemberById(idOfMemberToDelete);
            List<Member> allMembers = teamDao.getAllTeamMembers(idOfTeamToFind);
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            model.put("foundTeam", foundTeam);
            model.put("allMembers", allMembers);
            return new ModelAndView(model, "edit-members.hbs");
        }, new HandlebarsTemplateEngine());
    }
}