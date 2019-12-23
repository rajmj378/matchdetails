package com.rab3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rab3.dtos.TeamDto;
import com.rab3.services.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public TeamDto createTeam(@RequestBody TeamDto dto) {
		return teamService.createTeam(dto);
	}

	// pagination
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<TeamDto> getAllTeams(@RequestParam(required = false) Integer limit,
			@RequestParam(required = false) Integer offset) {
		return teamService.getAllTeam();
	}

	@RequestMapping(value = "/logo/upload", method = RequestMethod.POST)
	public void uploadFileHandler(@RequestParam("teamId") Long teamId,
			@RequestParam("file") MultipartFile file) throws Exception {

		teamService.uploadLogo(file, teamId);
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public TeamDto getTeamById(@PathVariable Long id) {
		return teamService.getTeamByID(id);
	}

}
