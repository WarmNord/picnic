package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.dto.TeamMemberDto;
import urfu.picnic.entity.TeamMember;
import urfu.picnic.repository.TeamMemberRepository;

@Service
public class TeamMemberServiceImpl implements TeamMemberService{

    private TeamMemberRepository teamMemberRepository;

    @Autowired
    public void TeamMemberService(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    public TeamMember getTeamMember(Long id) throws Throwable {
        return (TeamMember) teamMemberRepository.findByMemberId(id)
                .orElseThrow(() -> new RuntimeException("Team member Not Found"));
    }

    public TeamMember saveTeamMember(TeamMember teamMember) {
        return teamMemberRepository.save(teamMember);
    }

    public void deleteTeamMember(Long id) {
        teamMemberRepository.deleteByMemberId(id);
    }

    @Override
    public void addNewMember(TeamMemberDto teamMemberDto) {

    }
}
