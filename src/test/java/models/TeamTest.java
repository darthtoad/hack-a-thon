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
}