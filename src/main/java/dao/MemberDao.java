package dao;

import models.Member;
import models.Team;

import java.util.List;

public interface MemberDao {
    void add(Member member);

    List<Member> getAll();

    Member findById(int memberId);
}
