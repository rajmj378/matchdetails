package com.rab3.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rab3.dtos.TeamDto;
import com.rab3.entities.TeamEntity;
import com.rab3.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;

	public void createTeam(TeamDto dto) {
		TeamEntity team = new TeamEntity();
		team.setName(dto.getName());
		team.setCountry(dto.getCountry());
		team.setManager(dto.getMngr());
		team.setCreatedAt(new Date());
		team.setUpdatedAt(new Date());
		
		teamRepository.save(team);
		
	}
}
