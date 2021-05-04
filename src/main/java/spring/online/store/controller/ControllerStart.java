package spring.online.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.online.store.mongo.model.FileModel;

@Controller
@RequestMapping(value="/start")
public class ControllerStart {
	
	@CrossOrigin(value="http://localhost:3000")
	@GetMapping(value="/json")
	@ResponseBody
	public List<FileModel> jsonList(){
		List<FileModel> f = new ArrayList<>();
		f.add(new FileModel(1, "Gigel", "Dorel", "Zambilelor", false));
		f.add(new FileModel(2, "Popel", "Popa", "Cimintirului", true));
		return f;
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login() {
		System.out.println("Login");
		return "Hi";
	}
	
	@GetMapping("/welcome")
	public void welcome() {
		System.out.println("Login");
	}
	

}
