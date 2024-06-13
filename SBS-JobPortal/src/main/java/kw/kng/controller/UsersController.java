package kw.kng.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import kw.kng.entities.Users;
import kw.kng.entities.UsersType;
import kw.kng.service.UsersService;
import kw.kng.service.UsersTypeService;

@Controller
public class UsersController 
{
	private final UsersTypeService uts;
	private final UsersService us;

	public UsersController(UsersTypeService uts, UsersService us) 
	{
		this.uts = uts;
		this.us=us;
	}
	
	@GetMapping("/register")
	public String register(Model model)
	{
		List<UsersType> usersTypes= uts.getAll();
		model.addAttribute("getAllTypes", usersTypes);
		model.addAttribute("user", new Users());
		return "register";
	}

	@PostMapping("/register/new")
	public String userRegistration(@Valid Users users)
	{
		System.out.println("User:: "+users);
		us.addNew(users);
		return "dashboard";
	}
	
}
