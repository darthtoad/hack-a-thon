import models.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "new.hbs");
        }, new HandlebarsTemplateEngine());

        post("teams/new/members",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("team-name");
            String description = request.queryParams("description");
            Team newTeam = new Team(teamName, description);
            model.put("newTeam", newTeam);
            return new ModelAndView(model, "members.hbs");
        }, new HandlebarsTemplateEngine());

//        post("teams/new/members/next", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            String firstName = request.queryParams("first-name");
//            String lastName = request.queryParams("last-name");
//            String email = request.queryParams("email");
//            String favoriteColor = request.queryParams("favorite-color").toLowerCase();
//            String[] skillsArr = request.queryParams("skills").split(" ");
//            ArrayList<String> skills = new ArrayList<String>();
//            for(String skill : skillsArr) {
//                skills.add(skill);
//            }
//            Member newMember = new Member(firstName, lastName, email, favoriteColor, skills);
//            Team currentTeam = Team.findById(Team.getAllTeams().size());
//            ArrayList<Member> allMembers = currentTeam.getMembers();
//            allMembers.add(newMember);
//            Team.findById(Team.getAllTeams().size()).setMembers(allMembers);
//            model.put("allMembers", allMembers);
//            model.put("currentTeam", currentTeam);
//            return new ModelAndView(model, "members.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/teams/display", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            ArrayList teams = Team.getAllTeams();
//            model.put("teams", teams);
//            return new ModelAndView(model, "display.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/teams/display/finish", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            ArrayList teams = Team.getAllTeams();
//            model.put("teams", teams);
//            return new ModelAndView(model, "display.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/teams/:teamId", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToFind = Integer.parseInt(request.params("teamId"));
//            Team foundTeam = Team.findById(idOfTeamToFind);
//            model.put("foundTeam", foundTeam);
//            return new ModelAndView(model, "edit.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/teams/:teamId/edit", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToFind = Integer.parseInt(request.params("teamId"));
//            Team foundTeam = Team.findById(idOfTeamToFind);
//            String teamName = request.queryParams("team-name");
//            String description = request.queryParams("description");
//            foundTeam.setName(teamName);
//            foundTeam.setDescription(description);
//            ArrayList<Member> allMembers = foundTeam.getMembers();
//            model.put("foundTeam", foundTeam);
//            model.put("allMembers", allMembers);
//            return new ModelAndView(model, "edit-members.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/teams/:teamId/edit/finish", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToFind = Integer.parseInt(request.params("teamId"));
//            Team foundTeam = Team.findById(idOfTeamToFind);
//            ArrayList<Member> allMembers = foundTeam.getMembers();
//            String firstName = request.queryParams("first-name");
//            String lastName = request.queryParams("last-name");
//            String email = request.queryParams("email");
//            String favoriteColor = request.queryParams("favorite-color").toLowerCase();
//            String[] skillsArr = request.queryParams("skills").split(" ");
//            ArrayList<String> skills = new ArrayList<String>();
//            for(String skill : skillsArr) {
//                skills.add(skill);
//            }
//            for(Member member : allMembers) {
//                member.setFirstName(firstName);
//                member.setLastName(lastName);
//                member.setEmail(email);
//                member.setFavoriteColor(favoriteColor);
//                member.setSkills(skills);
//            }
//            ArrayList teams = Team.getAllTeams();
//            model.put("teams", teams);
//            return new ModelAndView(model, "display.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}
