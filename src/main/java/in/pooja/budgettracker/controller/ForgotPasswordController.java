package in.pooja.budgettracker.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.pooja.budgettracker.model.Account;
import in.pooja.budgettracker.repository.AccountRepository;
import in.pooja.budgettracker.service.EmailServices;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private AccountRepository accountRepository;
	

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailServices emailService;
    
    //Show Form submit Forgot-page
    
    @GetMapping("/forgot-password")
    public String showForgotForm() {
    return "forgot-password";
   
}
    
    //Handle form submit
    @PostMapping("forgot-password")
    public String processForgot(@RequestParam String email, Model model) {
    	Optional<Account> optional = accountRepository.findByEmail(email);
    	
    	if(optional.isPresent()) {
    		Account account = optional.get();
    		String token = UUID.randomUUID().toString();
            account.setResetToken(token);
            accountRepository.save(account);

            emailService.sendResetEmail(account.getEmail(), token);
            model.addAttribute("message", "A reset link has been sent to your email.");
        } else {
            model.addAttribute("error", "No account found with that email.");
        }
        return "forgot-password";
    }
    
    
    
    //Show reset-password form page
    @GetMapping("/reset-password")
    public String showResetForm(@RequestParam String token, Model model) {
    	Optional<Account> optional = accountRepository.findByResetToken(token);
    	if(optional.isPresent()) {
        model.addAttribute("token", token);
        return "reset-password"; // reset-password.html-form
    	}
    	else {
    		model.addAttribute("error", "Invalid or expired token");
    		return"forgot-password";
    	}
}
    
    
 // Handle reset form
    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token,
                                @RequestParam String password,
                                @RequestParam String confirmPassword,
                                Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            model.addAttribute("token", token);
            return "reset-password";
        }

        Optional<Account> optional = accountRepository.findByResetToken(token);
        if (optional.isPresent()) {
            Account account = optional.get();
            account.setPassword(passwordEncoder.encode(password));
            account.setResetToken(null); // clear token
            accountRepository.save(account);

            return "redirect:/login?resetSuccess=true";
        } else {
            model.addAttribute("error", "Invalid or expired token.");
            return "reset-password";
        }
    }
    

}





















































