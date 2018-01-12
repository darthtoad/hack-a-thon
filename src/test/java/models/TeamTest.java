package models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {
    @Test
    public void TeamInstantiatesCorrectly() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        assertEquals(true, testTeam instanceof Team);
    }

    @Test
    public void getName_getsName_String() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        assertEquals("The A-Team", testTeam.getName());
    }

    @Test
    public void getDescription_getsDescription_String() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        assertEquals("In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", testTeam.getDescription());
    }

    @Test
    public void getMembers_getsMembers_ArrayList() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        assertEquals(members, testTeam.getMembers());
    }

    @Test
    public void setName_setsName_String() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        testTeam.setName("A Team");
        assertEquals("A Team", testTeam.getName());
    }

    @Test
    public void setDescription_setsDescription_String() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        testTeam.setDescription("A Team");
        assertEquals("A Team", testTeam.getDescription());
    }

    @Test
    public void setMembers_setsMembers_ArrayList() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        ArrayList<Member> newMembers = new ArrayList<>();
        ArrayList newSkills = new ArrayList();
        newSkills.add("Throwing");
        newSkills.add("Driving");
        Member newTestMember = new Member("Mr.", "T", "IPity@theFool.com", "Gold (chains)", newSkills);
        newMembers.add(newTestMember);
        newMembers.add(testMember);
        testTeam.setMembers(newMembers);
        assertEquals(newMembers, testTeam.getMembers());
    }

    @Test
    public void getTeamId_getsTeamId_Int() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList<Member> members = new ArrayList<>();
        members.add(testMember);
        Team testTeam = new Team("The A-Team", "In 1972, a crack commando unit was sent to prison by a military court for a crime they didn't commit", members);
        assertEquals(0, testTeam.getTeamId());
    }
}