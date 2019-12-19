package com.rab3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rab3.dtos.PlayerDto;
import com.rab3.services.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public void addPlayer(@RequestParam(value="teamId") Long teamId,
			@RequestBody PlayerDto playerDto) throws Exception {

		playerService.createPlayer(teamId, playerDto);
	}
}
