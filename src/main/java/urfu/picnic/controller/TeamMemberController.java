package urfu.picnic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.TeamMember;
import urfu.picnic.repository.TeamMemberRepository;

import java.util.List;

@RestController
@RequestMapping("/api/teamMembers")
public class TeamMemberController {

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @GetMapping
    public List getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }

    @GetMapping("/{id}")
    public TeamMember getTeamMember(@PathVariable Long id) {
        return teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team Member not found"));
    }

    @PostMapping
    public ResponseEntity createTeamMember(@RequestBody TeamMember teamMember) {
        TeamMember savedTeamMember = teamMemberRepository.save(teamMember);
        return new ResponseEntity<>(savedTeamMember, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTeamMember(@PathVariable Long id,
                                           @RequestBody TeamMember teamMemberDetails) {
        TeamMember existingTeamMember = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team Member not found"));

        existingTeamMember.setUserId(teamMemberDetails.getUserId());
        existingTeamMember.setTeamId(teamMemberDetails.getTeamId());


        TeamMember updatedTeamMember = teamMemberRepository.save(existingTeamMember);
        return new ResponseEntity<>(updatedTeamMember, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeamMember(@PathVariable Long id) {
        TeamMember existingTeamMember = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team Member not found"));
        teamMemberRepository.delete(existingTeamMember);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}