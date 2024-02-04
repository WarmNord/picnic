package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.dto.TeamDto;
import urfu.picnic.entity.Team;
import urfu.picnic.repository.TeamRepository;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public void TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findByTeamId(id);
    }

    @Override
    public void addNewTeam(TeamDto teamDto) {

    }

    @Override
    public List getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team createTeam(Team team) {

        teamRepository.save(team);
        return null;
    }

    @Override
    public Team updateTeam(Long teamId, Team teamDetails) {

        Team existingTeam = teamRepository.findById(Math.toIntExact(teamId))
                .orElseThrow(() -> new RuntimeException("Team not found"));

        existingTeam.setTeamName(teamDetails.getTeamName());
        existingTeam.setTeamName(teamDetails.getMemberId());

        Team updatedTeam = teamRepository.save(existingTeam);
        return updatedTeam;
    }

    @Override
    public void deleteTeam(Long teamId) {
        teamRepository.deleteByTeamId(Math.toIntExact(teamId));
    }

}
