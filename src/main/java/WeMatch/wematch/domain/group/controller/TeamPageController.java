package WeMatch.wematch.domain.group.controller;

import WeMatch.wematch.domain.group.dto.TeamEventsResponseDto;
import WeMatch.wematch.domain.group.service.TeamService;
import WeMatch.wematch.response.Response;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static WeMatch.wematch.response.Response.success;
import static WeMatch.wematch.response.ResponseMessage.*;

@RestController
@AllArgsConstructor
@RequestMapping("/team")
public class TeamPageController {
    private final TeamService teamService;

    public Response getEvents(@RequestParam long groupId) {
        List<TeamEventsResponseDto> result = teamService.getEvents(groupId);
        return success(SUCCESS_GET_TEAM_EVENTS,result);
    }

    @RequestMapping("/info")
    public Response getTeam(@RequestParam long groupId) {
        return success(SUCCESS_GET_TEAM_INFO,teamService.getTeamInfo(groupId));
    }
}