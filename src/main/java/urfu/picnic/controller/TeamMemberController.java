package urfu.picnic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.TeamMember;
import urfu.picnic.service.TeamMemberService;

import java.util.List;

@RestController
@RequestMapping("/api/teamMembers")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    public TeamMemberController(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @GetMapping
    public List getAllTeamMembers() {
        return teamMemberService.getAllTeamMembers();
    }

    @GetMapping("/{id}")
    public TeamMember getTeamMemberById(@PathVariable(value = "id") Long teamMemberId) {
        return teamMemberService.getTeamMemberById(teamMemberId);
    }

    @PostMapping
    public TeamMember createTeamMember(@RequestBody TeamMember teamMember) {
        return teamMemberService.createTeamMember(teamMember);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTeamMember(@PathVariable(value = "id") Long teamMemberId, @RequestBody TeamMember teamMemberDetails) {
        TeamMember updatedTeamMember = teamMemberService.updateTeamMember(teamMemberId, teamMemberDetails);
        return ResponseEntity.ok(updatedTeamMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeamMember(@PathVariable(value = "id") Long teamMemberId) {
        teamMemberService.deleteTeamMember(teamMemberId);
        return ResponseEntity.ok().build();
    }
}