package com.dineConnect.springboot.dineConnect.reservation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	public List<Reservation> findByUsername(String username);

}
