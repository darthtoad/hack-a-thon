package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oMemberDao implements MemberDao {
    private final Sql2o sql2o;

    public Sql2oMemberDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Member member) {
        String sql = "INSERT INTO member (teamId, firstName, lastName, email, favoriteColor, skills) VALUES (:teamId, :firstName, :lastName, :email, :favoriteColor, :skills)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(member)
                    .executeUpdate()
                    .getKey();
            member.setMemberId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Member> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM member")
                    .executeAndFetch(Member.class);
        }
    }

    @Override
    public Member findById(int memberId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM member WHERE memberId = :memberId")
                    .addParameter("memberId", memberId)
                    .executeAndFetchFirst(Member.class);
        }
    }

    @Override
    public void editMember(int memberId, int teamId, String firstName, String lastName, String email, String favoriteColor, String skills) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE member SET teamId = :teamId, firstName = :firstName, lastName = :lastName, email = :email, favoriteColor = :favoriteColor, skills = :skills WHERE memberId = :memberId")
                    .addParameter("teamId", teamId)
                    .addParameter("firstName", firstName)
                    .addParameter("lastName", lastName)
                    .addParameter("email", email)
                    .addParameter("favoriteColor", favoriteColor)
                    .addParameter("skills", skills)
                    .addParameter("memberId", memberId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteMemberById(int memberId) {
        try (Connection con = sql2o.open()) {
            con.createQuery("DELETE FROM member WHERE memberId = :memberId")
                    .addParameter("memberId", memberId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
