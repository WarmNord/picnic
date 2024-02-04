package urfu.picnic.service;

import urfu.picnic.dto.TeamDto;
import urfu.picnic.entity.Team;

import java.util.List;

public interface TeamService {

    void addNewTeam(TeamDto teamDto);

    List getAllTeams();

    Team getTeamById(Long teamId);

    Team createTeam(Team team);

    Team updateTeam(Long teamId, Team teamDetails);

    void deleteTeam(Long teamId);
}
