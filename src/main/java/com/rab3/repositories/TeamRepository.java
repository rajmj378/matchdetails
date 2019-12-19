package com.rab3.repositories;

import java.util.List;

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
	
	public TeamEntity save(TeamEntity team) {
		return entityManager.merge(team);
	}
	
	public List<TeamEntity> getAll(){
		Query q = entityManager.createQuery("from TeamEntity");
		return q.getResultList();
	}
	
	public TeamEntity getById(Long id) {
		return entityManager.find(TeamEntity.class, id);
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
