package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.dto.TeamDto;
import urfu.picnic.entity.Team;
import urfu.picnic.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {


    private TeamRepository teamRepository;

    @Autowired
    public void TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getTeam(Long id) throws Throwable {
        return (Team) teamRepository.findByTeamId(id)
                .orElseThrow(() -> new RuntimeException("Team Not Found"));
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(int id) {
        teamRepository.deleteByTeamId(id);
    }

    @Override
    public void addNewTeam(TeamDto teamDto) {

    }
}
