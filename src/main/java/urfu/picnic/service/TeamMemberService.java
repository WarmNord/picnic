package urfu.picnic.service;

import urfu.picnic.dto.TeamMemberDto;
import urfu.picnic.entity.TeamMember;

public interface TeamMemberService {

    void addNewMember(TeamMemberDto teamMemberDto);
}
