package com.dineConnect.springboot.dineConnect.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("name")
public class ReservationController {
	
	//ReservationService 이용!
	private ReservationService reservationService;
	
	//생성자 -> 자동으로 결합됨
	//reservationService를 사용해 Reservation 리스트를 받을 수 있다
	public ReservationController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}

	@RequestMapping("list-reservations")
	public String listAllReservations(ModelMap model) {
		String username = (String)model.get("name");
		//구문을 새 지역 변수에 지정을 선택
		List<Reservation> reservations = reservationService.findByUsername(username);
		model.addAttribute("reservations", reservations);
		return "listReservations";
	}
	//GET
	@RequestMapping(value="select-time", method=RequestMethod.GET)
	public String showtimeReservationPage(
//			@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
//			@RequestParam("time") LocalTime time) {
		// ISO타입으로 날짜를 받음(YYYY-MM-DD)
		// 시간을 int 타입으로 받아서 1시간 단위 예약
		//구문을 새 지역 변수에 지정을 선택
		@RequestParam("time") LocalTime time) {



		return "selectTime";
	}

	@RequestMapping("submit")
	public String submit(@RequestParam String username, ModelMap model) {
		List<Reservation> reservations = reservationService.findByUsername(username);
		model.addAttribute("reservations", reservations);
		return "listReservations";
	}


	//GE

	/** 임시삭제
	//POST
	@RequestMapping(value="select-time", method=RequestMethod.POST)
	public String NshowtimeReservationPage(@RequestParam String description) {
		//구문을 새 지역 변수에 지정을 선택
		reservationService.addReservation(description);
		return "selectTime";
	}
	*/
	
	
	
	
	
}
