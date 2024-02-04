package urfu.picnic.service;

import urfu.picnic.entity.TeamMember;

import java.util.List;

public interface TeamMemberService {

    List getAllTeamMembers();

    TeamMember getTeamMemberById(Long teamMemberId);

    TeamMember createTeamMember(TeamMember teamMember);

    TeamMember updateTeamMember(Long teamMemberId, TeamMember teamMemberDetails);

    void deleteTeamMember(Long teamMemberId);
}
