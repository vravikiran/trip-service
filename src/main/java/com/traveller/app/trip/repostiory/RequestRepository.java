package com.traveller.app.trip.repostiory;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.traveller.app.trip.entities.Request;

import jakarta.transaction.Transactional;

public interface RequestRepository extends CrudRepository<Request, Integer> {
	@Modifying
	@Transactional
	@Query(value = "update Request r set r.status= :status where r.id =:id")
	public void updateStatus(@Param("id") int id, @Param("status") String status);
}
