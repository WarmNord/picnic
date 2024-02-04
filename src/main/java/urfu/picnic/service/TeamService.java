package urfu.picnic.service;

import urfu.picnic.entity.Team;

import java.util.List;

public interface TeamService {

    List getAllTeams();

    Team getTeamById(Long teamId);

    Team createTeam(Team team);

    Team updateTeam(Long teamId, Team teamDetails);

    void deleteTeam(Long teamId);
}
