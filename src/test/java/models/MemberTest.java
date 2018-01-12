package models;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberTest {
    @Test
    public void memberInstantiatesCorrectly() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        assertEquals(true, testMember instanceof Member);
    }

    @Test
    public void getFirstName_getsFirstName_Tim() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        assertEquals("Tim", testMember.getFirstName());
    }

    @Test
    public void getLastName_getsLastName_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        assertEquals("the Enchanter", testMember.getLastName());
    }

    @Test
    public void getEmail_getsEmail_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        assertEquals("thing@thing.com", testMember.getEmail());
    }
    @Test
    public void getFavoriteColor_getsFavoriteColor_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        assertEquals("blue", testMember.getFavoriteColor());
    }

    @Test
    public void getSkills_getsSkills_ArrayList() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        assertEquals(skills, testMember.getSkills());
    }

    @Test
    public void setFirstName_setsFirstName_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        testMember.setFirstName("John");
        assertEquals("John", testMember.getFirstName());
    }

    @Test
    public void setLastName_setsLastName_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        testMember.setLastName("John");
        assertEquals("John", testMember.getLastName());
    }
}