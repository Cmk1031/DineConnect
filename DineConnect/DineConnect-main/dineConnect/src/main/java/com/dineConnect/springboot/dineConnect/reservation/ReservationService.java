package com.dineConnect.springboot.dineConnect.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	//정적리스트
	private static List<Reservation> reservations = new ArrayList<>();
	

	public ReservationService( ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	private ReservationRepository reservationRepository;


	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}
	
	//reservation 리턴 메서드 예약 목록 조회?
	public List<Reservation> findByUsername(String username) {
	//username이 주어지면 모든 Reservation을 찾아서 그걸 리턴
		Predicate<? super Reservation> predicate = 
				reservation -> reservation.getUsername().equalsIgnoreCase(username);
		return reservations.stream().filter(predicate).toList();
	}



	
	
	
		
}
