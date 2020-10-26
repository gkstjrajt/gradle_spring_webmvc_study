package gradle_spring_webmvc_study.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gradle_spring_webmvc_study.dto.AuthInfo;
import gradle_spring_webmvc_study.dto.LoginCommand;
import gradle_spring_webmvc_study.exception.WrongIdPasswordException;
import gradle_spring_webmvc_study.service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;

	@GetMapping												// value 속성은 Cookie이름을 지정 (이름이 Remember인 쿠키를 Cookie 타입으로 전달받음, 지정한 이름을 가진 쿠키가 존재하지 않을 수도 있다면 required 속성을 false로 지정
	public String form(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required = false) Cookie rCookie) {
		if(rCookie != null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "/login/form";
	}

	@PostMapping
	public String submit(@Valid LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
//		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors())
			return "/login/form";
		try {
			AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
			// 세션에 authInfo 저장해야함
			session.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberEmail()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			
			return "/login/loginSuccess";
		} catch (WrongIdPasswordException ex) {
			errors.reject("idPasswordNotMatching");
			return "/login/form";
		}
	}
}

/*
 	@RequestMapping("/login")
	public String form(Login login) {
		return "login/loginForm";
	}



	// ${어쩌구} -> get어쩌구() 호출돼
	// ${studentCode} -> getStudentCode() <- 호출돼
	//getLoginTypes()
	@ModelAttribute("loginTypes")
	public List<String> getLoginTypes() {
		List<String> loginTypes = new ArrayList<String>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}

	@ModelAttribute("jobCodes")
	public List<Code> getJobCodes() {
		List<Code> jobCodes = new ArrayList<Code>();
		jobCodes.add(new Code("G", "사용자"));
		jobCodes.add(new Code("E", "관리자"));
		jobCodes.add(new Code("H", "개발자"));
		return jobCodes;
	}

	@ModelAttribute("tools")
	public List<String> getTools() {
		List<String> tools = new ArrayList<String>();
		tools.add("Eclipse");
		tools.add("IntelliJ");
		tools.add("VSCode");
		return tools;
	}

	@ModelAttribute("favorites")
	public List<String> getFavorites() {
		List<String> favorites = new ArrayList<String>();
		favorites.add("윈도우10");
		favorites.add("iOS");
		favorites.add("리눅스");
		return favorites;
	}

	@ModelAttribute("codes")
	public List<Code> getCodes() {
		List<Code> codes = new ArrayList<Code>();
		codes.add(new Code("S1", "운영체제"));
		codes.add(new Code("S2", "JAVA"));
		codes.add(new Code("S3", "Python"));
		return codes;
	}
	
	@PostMapping("/result")
	public String result(@ModelAttribute("login") Login login) {
		return "login/result";
	}
 */