package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void memberInstantiatesCorrectly() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "java");
        assertEquals(true, testMember instanceof Member);
    }

    @Test
    public void getFirstName_getsFirstName_Tim() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        assertEquals("Tim", testMember.getFirstName());
    }

    @Test
    public void getLastName_getsLastName_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        assertEquals("the Enchanter", testMember.getLastName());
    }
//
    @Test
    public void getEmail_getsEmail_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        assertEquals("thing@thing.com", testMember.getEmail());
    }
    @Test
    public void getFavoriteColor_getsFavoriteColor_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        assertEquals("blue", testMember.getFavoriteColor());
    }
//
    @Test
    public void getSkills_getsSkills_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        assertEquals("Java", testMember.getSkills());
    }

    @Test
    public void setFirstName_setsFirstName_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        testMember.setFirstName("John");
        assertEquals("John", testMember.getFirstName());
    }

    @Test
    public void setLastName_setsLastName_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        testMember.setLastName("John");
        assertEquals("John", testMember.getLastName());
    }
//
    @Test
    public void setEmail_setsEmail_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        testMember.setEmail("com@com.com");
        assertEquals("com@com.com", testMember.getEmail());
    }
//
    @Test
    public void setFavoriteColor_setsFavoriteColor_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "ava");
        testMember.setFavoriteColor("Ultraviolet");
        assertEquals("Ultraviolet", testMember.getFavoriteColor());
    }
//
    @Test
    public void setSkills_setsSkills_String() throws Exception {
        Member testMember = new Member(1,"Tim", "the Enchanter", "thing@thing.com", "blue", "Java");
        testMember.setSkills("Kung Fu");
        assertEquals("Kung Fu", testMember.getSkills());
    }
}