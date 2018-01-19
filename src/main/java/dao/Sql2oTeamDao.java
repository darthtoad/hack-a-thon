package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oTeamDao implements TeamDao {
    private final Sql2o sql2o;

    public Sql2oTeamDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Team team) {
        String sql = "INSERT INTO team (name, description) VALUES (:name, :description)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(team)
                    .executeUpdate()
                    .getKey();
            team.setTeamId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Team findById(int teamId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM team WHERE teamId = :teamId")
                    .addParameter("teamId", teamId)
                    .executeAndFetchFirst(Team.class);
        }
    }

    @Override
    public List<Team> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM team")
            .executeAndFetch(Team.class);
        }
    }

    @Override
    public void editTeam(String name, String description, int teamId) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE team SET name = :name, description = :description WHERE teamId = :teamId")
                    .addParameter("name", name)
                    .addParameter("description", description)
                    .addParameter("teamId", teamId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int teamId) {
        try (Connection con = sql2o.open()) {
            con.createQuery("DELETE * FROM team WHERE teamId = :teamId")
                    .addParameter("teamId", teamId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
