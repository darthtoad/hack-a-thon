package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
//        Team.clearAllTeams();
    }

    @Test
    public void TeamInstantiatesCorrectly() {
//        ArrayList skills = new ArrayList();
//        skills.add("Java");
//        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
//        ArrayList<Member> members = new ArrayList<>();
//        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        assertEquals(true, testTeam instanceof Team);
    }

    @Test
    public void getName_getsName_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        assertEquals("The A-Team", testTeam.getName());
    }

    @Test
    public void getDescription_getsDescription_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        assertEquals("In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", testTeam.getDescription());
    }
//

    @Test
    public void setName_setsName_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        testTeam.setName("A Team");
        assertEquals("A Team", testTeam.getName());
    }

    @Test
    public void setDescription_setsDescription_String() {
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit");
        testTeam.setDescription("A Team");
        assertEquals("A Team", testTeam.getDescription());
    }
//
//    @Test
//    public void setMembers_setsMembers_ArrayList() {
//        ArrayList skills = new ArrayList();
//        skills.add("Java");
//        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
//        ArrayList<Member> members = new ArrayList<>();
//        members.add(testMember);
//        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
//        ArrayList<Member> newMembers = new ArrayList<>();
//        ArrayList newSkills = new ArrayList();
//        newSkills.add("Throwing");
//        newSkills.add("Driving");
//        Member newTestMember = new Member("Mr.", "T", "IPity@theFool.com", "Gold (chains)", newSkills);
//        newMembers.add(newTestMember);
//        newMembers.add(testMember);
//        testTeam.setMembers(newMembers);
//        assertEquals(newMembers, testTeam.getMembers());
//    }
//
//    @Test
//    public void getTeamId_getsTeamId_Int() {
//        ArrayList skills = new ArrayList();
//        skills.add("Java");
//        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
//        ArrayList<Member> members = new ArrayList<>();
//        members.add(testMember);
//        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
//        assertEquals(1, testTeam.getTeamId());
//    }
//
//    @Test
//    public void getAllTeams_AllTeamsAreCorrectlyReturned_ArrayList() {
//        setupNewTeam();
//        setupNewTeam2();
//        assertEquals(2, Team.getAllTeams().size());
//    }
//
//    @Test
//    public void getAllTeams_AllTeamsContainAllTeams_true() {
//        setupNewTeam();
//        setupNewTeam2();
//        assertTrue(Team.getAllTeams().contains(setupNewTeam()));
//        assertTrue(Team.getAllTeams().contains(setupNewTeam2()));
//    }
//
//    @Test
//    public void findById_returnsCorrectTeam_Team() throws Exception {
//        Team t1 = setupNewTeam();
//        Team t2 = setupNewTeam2();
//        assertEquals(1, Team.findById(t1.getTeamId()).getTeamId());
//    }
//
//    @Test
//    public void findById_returnsCorrectSecondTeam_Team() throws Exception {
//        Team t1 = setupNewTeam();
//        Team t2 = setupNewTeam2();
//        assertEquals(2, Team.findById(t2.getTeamId()).getTeamId());
//    }

//    public Member setupNewMember(){
//        ArrayList newSkills = new ArrayList();
//        newSkills.add("Throwing");
//        newSkills.add("Driving");
//        return new Member("Mr.", "T", "IPity@theFool.com", "Gold (chains)", newSkills);
//    }
//
//    public Member setupNewMember2() {
//        ArrayList skills = new ArrayList();
//        skills.add("Java");
//        return new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
//    }
//
//    public Member setupNewMember3() {
//        ArrayList skills = new ArrayList();
//        skills.add("Javascript");
//        skills.add("Node.js");
//        skills.add("React.js");
//        skills.add("SQL");
//        return new Member("Loren", "Ipsum", "blah@blah.com", "grey", skills);
//    }
//
//    public Member setupNewMember4() {
//        ArrayList skills = new ArrayList();
//        skills.add("Assembly");
//        skills.add("Machine Code");
//        skills.add("C");
//        skills.add("C++");
//        return new Member("Darth", "Toad", "darth.toad@blah.com", "red", skills);
//    }
//
//    public Team setupNewTeam() {
//        ArrayList<Member> members = new ArrayList<>();
//        members.add(setupNewMember());
//        members.add(setupNewMember2());
//        return new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
//    }
//
//    public Team setupNewTeam2() {
//        ArrayList<Member> members = new ArrayList<>();
//        members.add(setupNewMember3());
//        members.add(setupNewMember4());
//        return new Team("The League of Unextraordinary Wildmen", "Normal men of the wild who want to shut down a coal power plant in Nevada", members);
//    }
}