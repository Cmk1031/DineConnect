package com.dineConnect.springboot.dineConnect.LoginController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	//@ResponseBody를 지워야 home.jsp로 리디렉션한다!
    @RequestMapping(value="/", method = RequestMethod.GET) //~~login?name=Ranga //요청에서 나온 name이 변수에 연계
	   public String gotowelcomePage(ModelMap model) { 
			model.put("name", getLoggedinUsername());
			//login.jsp로 리디렉션!
			return "welcome";
			} 
    private String getLoggedinUsername() {
    	Authentication authentication = 
    			SecurityContextHolder.getContext().getAuthentication();
    	return authentication.getName();
    	
    }
	/**
	private AuthenticationService authenticationService;
	//생성자 만들기
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	
	}
	*/
	 /**
	//@ResponseBody를 지워야 home.jsp로 리디렉션한다!
		@RequestMapping("login") //~~login?name=Ranga //요청에서 나온 name이 변수에 연계
		public String loginhtml(@RequestParam String name, ModelMap model) { 
			model.put("name", name);
			
			//login.jsp로 리디렉션!
			return "login";
		} 
		*/
	
      /**
	//로그인 name과 password를 ModelMap model을 통해 모델에 넣고 welcome.jsp파일로 정보 보냄
       @RequestMapping(value="login", method = RequestMethod.POST) //~~login?name=Ranga //요청에서 나온 name이 변수에 연계
	   public String gotoWelcomePage(@RequestParam String name,
			   @RequestParam String password, ModelMap model) { 
    	   
    	   if(authenticationService.authenticate(name, password)) {
    	   
			model.put("name", name);
	
    	   
			//login.jsp로 리디렉션!
			return "welcome";
			} 
    	   
    	   model.put("errorMessage", "Invalid Credentials! Please try again.");
    	   return "login";
       }
       
       */
}
