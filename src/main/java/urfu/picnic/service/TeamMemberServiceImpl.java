package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.entity.TeamMember;
import urfu.picnic.repository.TeamMemberRepository;

import java.util.List;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {

    private TeamMemberRepository teamMemberRepository;

    @Autowired
    public void TeamMemberService(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @Override
    public List getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    @Override
    public TeamMember getTeamMemberById(Long teamMemberId) {
        return teamMemberRepository.findByMemberId(teamMemberId);
    }

    @Override
    public TeamMember createTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    @Override
    public TeamMember updateTeamMember(Long teamMemberId, TeamMember teamMemberDetails) {
        TeamMember existingTeamMember = teamMemberRepository.findById(teamMemberId)
                .orElseThrow(() -> new RuntimeException("Team Member not found"));

        existingTeamMember.setUserId(teamMemberDetails.getUserId());
        existingTeamMember.setTeamId(teamMemberDetails.getTeamId());

        TeamMember updatedTeamMember = teamMemberRepository.save(existingTeamMember);
        return updatedTeamMember;
    }

    @Override
    public void deleteTeamMember(Long teamMemberId) {
        TeamMember existingTeamMember = teamMemberRepository.findById(teamMemberId)
                .orElseThrow(() -> new RuntimeException("Team Member not found"));
        teamMemberRepository.delete(existingTeamMember);

    }
}
