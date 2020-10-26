package gradle_spring_webmvc_study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gradle_spring_webmvc_study.dto.Code;
import gradle_spring_webmvc_study.dto.Login;

@Controller
@RequestMapping("/log")
public class LoginControllerTwo {
	
	@GetMapping
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
		codes.add(new Code("S1", "ORACLE"));
		codes.add(new Code("S2", "JAVA"));
		codes.add(new Code("S3", "Python"));
		return codes;
	}
	
//	@PostMapping("/result")
//	public String result(@ModelAttribute("login") Login login) {
//		 login.setSubjects(getSelectedSubjects(login.getStrSubjects()));
//		return "login/result";
//	}
	
	 private List<Code> getSelectedSubjects(List<String> strSubjects) {
	        List<Code> subjects = getCodes();
	        List<Code> selected = new ArrayList<>();
	        for(String c : strSubjects) {
	            Code code = new Code(c, null);
	            if (subjects.contains(code)) {
	                selected.add(subjects.get(subjects.indexOf(code)));
	            }
	        }
	        return selected;
	    }

}
