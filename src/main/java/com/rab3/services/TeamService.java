package com.rab3.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rab3.converters.PlayerConverter;
import com.rab3.dtos.PlayerDto;
import com.rab3.dtos.TeamDto;
import com.rab3.entities.PlayerEntity;
import com.rab3.entities.TeamEntity;
import com.rab3.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private LogoService logoService;

	public TeamDto createTeam(TeamDto dto) {

		TeamEntity team = new TeamEntity();
		team.setName(dto.getName());
		team.setCountry(dto.getCountry());
		team.setManager(dto.getMngr());
		team.setCreatedAt(new Date());
		team.setUpdatedAt(new Date());

		return convert(teamRepository.save(team));

	}

	public TeamDto getTeamByID(long id) {
		TeamEntity team = teamRepository.getById(id);
		TeamDto d = convert(team);
		return d;

	}

	public List<TeamDto> getAllTeam() {
		List<TeamEntity> teams = teamRepository.getAll();

		List<TeamDto> returnList = new ArrayList<TeamDto>();
		for (TeamEntity t : teams) {
			TeamDto d = convert(t);
			returnList.add(d);
		}
		return returnList;

	}
	
	public void uploadLogo(MultipartFile file, Long teamId) throws Exception {
		TeamEntity team = teamRepository.getById(teamId);
		if(team == null) {
			throw new Exception("Team doesnt exist : " + teamId);
		}
		String fileName = "logo-" + teamId + ".jpg";
		String finalName = logoService.uploadLogo(file, fileName);
		
		team.setLogo(finalName);
		teamRepository.save(team);
		
	}

	private TeamDto convert(TeamEntity te) {
		TeamDto dto = null;
		if (te != null) {
			dto = new TeamDto();
			dto.setId(te.getId());
			dto.setName(te.getName());
			dto.setLogo(te.getLogo());
			dto.setMngr(te.getManager());
			dto.setCountry(te.getCountry());
			
			List<PlayerDto> playerDtos = new ArrayList<PlayerDto>();
			for(PlayerEntity p : te.getPlayers()) {
				PlayerDto pd = PlayerConverter.convert(p);
				playerDtos.add(pd);
			}
			dto.setPlayers(playerDtos);
		}

		return dto;
	}
}
