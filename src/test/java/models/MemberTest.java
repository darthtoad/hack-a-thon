package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MemberTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Member.clearAllMembers();
    }

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

    @Test
    public void setEmail_setsEmail_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        testMember.setEmail("com@com.com");
        assertEquals("com@com.com", testMember.getEmail());
    }

    @Test
    public void setFavoriteColor_setsFavoriteColor_String() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        testMember.setFavoriteColor("Ultraviolet");
        assertEquals("Ultraviolet", testMember.getFavoriteColor());
    }

    @Test
    public void setSkills_setsSkills_ArrayList() throws Exception {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        Member testMember = new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
        ArrayList differentSkills = new ArrayList();
        differentSkills.add("React");
        testMember.setSkills(differentSkills);
        assertEquals(differentSkills, testMember.getSkills());
    }

    @Test
    public void getMemberId_getsMemberId_int() throws Exception {
        Member m1 = setupNewMember();
        Member m2 = setupNewMember2();
        assertEquals(1, m1.getMemberId());
    }

    @Test
    public void getMemberId_getsMemberIdWithMutlipleMembers_int() throws Exception {
        Member m1 = setupNewMember();
        Member m2 = setupNewMember2();
        assertEquals(2, m2.getMemberId());
    }

    @Test
    public void getAllMembers_AllMembersAreCorrectlyReturned_ArrayList() {
        setupNewMember();
        setupNewMember2();
        assertEquals(2, Member.getAllMembers().size());
    }

    @Test
    public void getAllMembers_AllMembersContainAllMembers_true() {
        setupNewMember();
        setupNewMember2();
        assertTrue(Member.getAllMembers().contains(setupNewMember()));
        assertTrue(Member.getAllMembers().contains(setupNewMember2()));
    }

    public Member setupNewMember(){
        ArrayList newSkills = new ArrayList();
        newSkills.add("Throwing");
        newSkills.add("Driving");
        return new Member("Mr.", "T", "IPity@theFool.com", "Gold (chains)", newSkills);
    }

    public Member setupNewMember2() {
        ArrayList skills = new ArrayList();
        skills.add("Java");
        return new Member("Tim", "the Enchanter", "thing@thing.com", "blue", skills);
    }
}