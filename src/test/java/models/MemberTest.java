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
    public void getLastName_getsFirstName_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        assertEquals("the Enchanter", testMember.getLastName());
    }
}