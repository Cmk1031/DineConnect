package com.dineConnect.springboot.dineConnect.reservation;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ReservationControllerJpa {
	
	//여기부터 5/5
	@Autowired
	private ReservationService reservationService;
	
	
	
	
	
	
	//ReservationService 이용!
	
	
	

	//생성자 -> 자동으로 결합됨
	//reservationService를 사용해 Reservation 리스트를 받을 수 있다
	public ReservationControllerJpa(ReservationService reservationService, ReservationRepository reservationRepository) {
		super();
		this.reservationService = reservationService;
		this.reservationRepository = reservationRepository;
	}
	
	
	
	//인스턴스 생성
	
	private ReservationRepository reservationRepository;
	
	

	@RequestMapping("list-reservations")
	public String listAllReservations(ModelMap model) {
		String username = (String)model.get("name");
		//1번 가져
		reservationRepository.getById(1);
		
		//구문을 새 지역 변수에 지정을 선택
		List<Reservation> reservations = reservationRepository.findByUsername(username);
		model.addAttribute("reservations", reservations);
		return "listReservations";
	}
	//GET
	@RequestMapping(value="select-time", method=RequestMethod.GET)
	public String showtimeReservationPage() {
		//구문을 새 지역 변수에 지정을 선택
		
		return "selectTime";
	}

	// 예약하기 버튼 누르면 선택한 날짜, 시간 받음
	@RequestMapping(value="make-reservation", method=RequestMethod.GET)
	public String makeReservation(@RequestParam("date") String dateStr,
								  @RequestParam("time") String timeStr,
								  @ModelAttribute("name") String username) {
		LocalDate date = LocalDate.parse(dateStr);
        LocalTime time = LocalTime.parse(timeStr);
        
        Reservation newReservation = new Reservation();
        newReservation.setUsername(username);
        newReservation.setDate(date);
        newReservation.setTime(time);
        
        reservationService.save(newReservation);
        
		// date와 time 파라미터를 이용한 처리 로직 구현
		System.out.println("예약 날짜: " + date + ", 예약 시간: " + time);
		// 처리 후 리다이렉트할 페이지 경로 반환
		return "redirect:/";
	}


	// 예약하기 버튼을 누르면 username, date, time 저장하도록
	@RequestMapping("submit")
	public String submit(@RequestParam String username, @RequestParam String dateStr,
						 @RequestParam String timeStr, ModelMap model) {
		//
		//문규
		//		LocalDate date = LocalDate.parse(dateStr);
			//	LocalTime time = LocalTime.parse(timeStr);
				
				
			//	Reservation newReservation = new Reservation();
			//	newReservation.setUsername(username);
			//	newReservation.setDate(date);
			//	newReservation.setTime(time);
			//	reservationService.save(newReservation);

		//
		
		List<Reservation> reservations = reservationService.findByUsername(username);
		model.addAttribute("reservations", reservations);

		return "listReservations";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String dateString = request.getParameter("date");
	    LocalDate date = LocalDate.parse(dateString);

	    // 데이터베이스에 연결하고 예약 정보를 저장하는 로직
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        // 데이터베이스 연결
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/reservations", "todos-user", "dummytodos");

	        // SQL 쿼리 작성
	        String sql = "INSERT INTO reservations (date) VALUES (?)";

	        // PreparedStatement 생성
	        pstmt = conn.prepareStatement(sql);

	        // 파라미터 설정
	        pstmt.setObject(1, date);

	        // 쿼리 실행
	        pstmt.executeUpdate();

	        // 작업이 완료되면 메시지를 설정하여 사용자에게 보여줄 수 있음
	        response.getWriter().write("Reservation successfully saved!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        response.getWriter().write("Error occurred while saving reservation!");
	    } finally {
	        // 리소스 해제
	        try {
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


	// 버튼에서 날짜 받아와서 위 데이터베이스 저장에 연결(시간은 아직 구현x)
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String dateString = request.getParameter("selectedDate");
//		LocalDate Date = LocalDate.parse(dateString);
//
//		// 여기에서 selectedDate를 사용하여 데이터베이스에 저장하는 로직 추가
//	}


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
