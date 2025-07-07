package in.pooja.budgettracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.pooja.budgettracker.model.Account;
import in.pooja.budgettracker.repository.AccountRepository;
import jakarta.validation.Valid;

@Controller
public class AccountController {
	
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Show Registration page
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("account", new Account());
		return "register"; //register.html
		
		
	}
	//Handle form Submit
	@PostMapping("/register")
	 public String processAccount(@Valid @ModelAttribute Account account,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "register"; // Stay on the form if validation fails
		}
		
		// Encrypt password before saving
	    account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountRepository.save(account);
		model.addAttribute("successMessage", "Account registerd successfully!");
		model.addAttribute("account", new Account()); // Reset the form
		return "redirect:/dashboard"; //redirect to dashboard after successful registration
	}
	

}
