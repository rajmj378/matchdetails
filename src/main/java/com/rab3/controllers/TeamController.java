package com.rab3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	// TODO implement uploading the logo

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public TeamDto getTeamById(@PathVariable Long id) {
		return teamService.getTeamByID(id);
	}

}
