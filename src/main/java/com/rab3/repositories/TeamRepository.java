package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rab3.entities.TeamEntity;

@Repository
@Transactional
public class TeamRepository {

	private EntityManager entityManager;
	
	public void save(TeamEntity team) {
		entityManager.persist(team);
	}
	
	public TeamEntity getTeamByName(String teamName) {
		Query q = entityManager.createQuery("select t from TeamEntity where t.name =:name");
		q.setParameter("name", teamName);
		return (TeamEntity) q.getSingleResult();	
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
}
