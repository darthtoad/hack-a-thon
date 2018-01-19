package dao;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oMemberDaoTest {
    private Sql2oMemberDao memberDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingNewMemberSetsId() throws Exception {
        Member member = new Member(1, "Mr", "T", "pity@the.fool", "Gold", "Throwing helluva far, Javascript");
        int originalMemberId = member.getMemberId();
        memberDao.add(member);
        assertNotEquals(originalMemberId, member.getMemberId());
    }

    @Test
    public void getAllMembersGetsAllMembers() throws Exception {
        Member member = new Member(1, "Mr", "T", "pity@the.fool", "Gold", "Throwing helluva far, Javascript");
        Member member1 = new Member(2, "Comma", "Chameleon", "Icome@and.go", "Green", "Chamoflauge, eating pizza");
        memberDao.add(member);
        memberDao.add(member1);
        assertEquals(2, memberDao.getAll().size());
    }

    @Test
    public void findByIdFindsMemberById() throws Exception {
        Member member = new Member(1, "Mr", "T", "pity@the.fool", "Gold", "Throwing helluva far, Javascript");
        Member member1 = new Member(2, "Comma", "Chameleon", "Icome@and.go", "Green", "Chamoflauge, eating pizza");
        memberDao.add(member);
        memberDao.add(member1);
        assertEquals(member, memberDao.findById(1));
        assertEquals(member1, memberDao.findById(2));
    }

}