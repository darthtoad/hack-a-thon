package models;

public class Member {
    private String firstName;
    private String lastName;
    private String email;
    private String favoriteColor;
    private String skills;
    private int memberId;
    private int teamId;
    public Member(int teamId, String firstName, String lastName, String email, String favoriteColor, String skills) {
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favoriteColor = favoriteColor;
        this.skills = skills;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFavoriteColor() {
        return this.favoriteColor;
    }

    public String getSkills() {
        return this.skills;
    }

    public int getMemberId() {
        return this.memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (memberId != member.memberId) return false;
        if (teamId != member.teamId) return false;
        if (!firstName.equals(member.firstName)) return false;
        if (!lastName.equals(member.lastName)) return false;
        if (email != null ? !email.equals(member.email) : member.email != null) return false;
        if (favoriteColor != null ? !favoriteColor.equals(member.favoriteColor) : member.favoriteColor != null)
            return false;
        return skills != null ? skills.equals(member.skills) : member.skills == null;
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (favoriteColor != null ? favoriteColor.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        result = 31 * result + memberId;
        result = 31 * result + teamId;
        return result;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
