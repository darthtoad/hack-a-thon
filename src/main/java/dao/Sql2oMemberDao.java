package dao;

import models.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oMemberDao implements MemberDao {
    private final Sql2o sql2o;

    public Sql2oMemberDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add(Member member) {
        String sql = "INSERT INTO member (teamId, firstName, lastName, email, favoriteColor, skills) VALUES (:teamId, :firstName, :lastName, email, favoriteColor, skills)";
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
}
