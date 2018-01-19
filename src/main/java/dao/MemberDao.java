package dao;

import models.Member;
import models.Team;

import java.util.List;

public interface MemberDao {
    void add(Member member);

    List<Member> getAll();

    Member findById(int memberId);

    void editMember(int memberId, int teamId, String firstName, String lastName, String email, String favoriteColor, String skills);

    void deleteMemberById(int memberId);

    void clearAllMembers();
}
