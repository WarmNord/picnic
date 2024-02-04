package urfu.picnic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.Team;
import urfu.picnic.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable(value = "id") Long teamId) {
        return teamService.getTeamById(teamId);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTeam(@PathVariable(value = "id") Long teamId, @RequestBody Team teamDetails) {
        Team updatedTeam = teamService.updateTeam(teamId, teamDetails);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeam(@PathVariable(value = "id") Long teamId) {
        teamService.deleteTeam(teamId);
        return ResponseEntity.ok().build();
    }
}
