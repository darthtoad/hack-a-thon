package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oTeamDaoTest {
    private Sql2oTeamDao teamDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teamDao = new Sql2oTeamDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingTeamSetsId() throws Exception {
        Team team = new Team("The Awesome People", "We are awesome");
        int originalTeamId = team.getTeamId();
        teamDao.add(team);
        assertNotEquals(originalTeamId, team.getTeamId());
    }

    @Test
    public void existingTeamCanBeFoundById() throws Exception {
        Team team = new Team("The Awesome People", "We are awesome");
        teamDao.add(team);
        Team foundTeam = teamDao.findById(team.getTeamId());
        assertEquals(team.getTeamId(), foundTeam.getTeamId());
        assertEquals(team.getName(), foundTeam.getName());
    }

    @Test
    public void getAllGetsAllTeams() throws Exception {
        Team team = new Team("The Awesome People", "We are awesome");
        Team team2 = new Team("The A-Team", "In 1972, a crack commando unit...");
        teamDao.add(team);
        teamDao.add(team2);
        assertEquals(2, teamDao.getAll().size());
    }

    @Test
    public void editTeamEditsTeam() throws Exception {
        Team team = new Team("The Awesome People", "We are awesome");
        teamDao.add(team);
        teamDao.editTeam("Poop", "pee", team.getTeamId());
        Team updatedTeam = teamDao.findById(team.getTeamId());
        assertNotEquals("Poop", team.getName());
        assertEquals("Poop", updatedTeam.getName());
    }

    @Test
    public void deleteTeamDeletesTeam() throws Exception {
        Team team = new Team("The Awesome People", "We are awesome");
        teamDao.add(team);
        teamDao.deleteById(team.getTeamId());
        assertEquals(0, teamDao.getAll().size());
    }

    @Test
    public void clearAllTeamsDeletesAll() throws Exception {
        Team team = new Team("The Awesome People", "We are awesome");
        Team team2 = new Team("The A-Team", "In 1972, a crack commando unit...");
        teamDao.add(team);
        teamDao.add(team2);
        teamDao.clearAllTeams();
        assertEquals(0, teamDao.getAll().size());
    }

}