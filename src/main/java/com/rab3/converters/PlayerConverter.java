package com.rab3.converters;

import com.rab3.dtos.PlayerDto;
import com.rab3.entities.PlayerEntity;

public class PlayerConverter {

	public static PlayerEntity convert(PlayerDto dto) {
		PlayerEntity p = null;
		if (dto != null) {
			p = new PlayerEntity();
			p.setName(dto.getName());
			p.setPosition(dto.getPosition());
			p.setAge(dto.getAge());
		}
		return p;
	}
	
	public static PlayerDto convert(PlayerEntity entity) {
		PlayerDto dto = null;
		if (entity != null) {
			dto = new PlayerDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setPosition(entity.getPosition());
			dto.setAge(entity.getAge());
		}
		return dto;
	}
}
