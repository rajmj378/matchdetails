package com.rab3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rab3.dtos.TeamDto;
import com.rab3.services.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void createTeam(@RequestBody TeamDto dto) {
		teamService.createTeam(dto);
	}

}
