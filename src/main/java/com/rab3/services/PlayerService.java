package com.rab3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3.converters.PlayerConverter;
import com.rab3.dtos.PlayerDto;
import com.rab3.entities.PlayerEntity;
import com.rab3.entities.TeamEntity;
import com.rab3.repositories.PlayerRepository;
import com.rab3.repositories.TeamRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private TeamRepository teamRepository;

	public void createPlayer(Long teamId, PlayerDto dto) throws Exception {
		TeamEntity team = teamRepository.getById(teamId);
		if (team == null) {
			throw new Exception("Team doesnt exist : " + teamId);
		} else {
			PlayerEntity p = PlayerConverter.convert(dto);
			p.setTeam(team);
			if (p != null) {
				playerRepository.save(p);
			}
		}

	}

	
}
