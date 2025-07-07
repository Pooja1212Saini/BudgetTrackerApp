package in.pooja.budgettracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.pooja.budgettracker.model.Budget;
import in.pooja.budgettracker.repository.BudgetRepository;
import jakarta.validation.Valid;

@Controller
public class BudgetController {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	
	@GetMapping("/budget")
	public String showBudgetForm(Model model) {
		model.addAttribute("budget", new Budget());
		model.addAttribute("success", false); // initially no success
		return "budget";
	}
	

	@PostMapping("/budget")
	public String saveBudget(@Valid @ModelAttribute Budget budget, BindingResult
			result, Model model) {
		if(result.hasErrors()) {
			return "budget";
		}
		budgetRepository.save(budget);
		model.addAttribute("budget", new Budget());
		model.addAttribute("success", true); // Show Success
		return "budget";
			}
	
	
	// to  view budget page
	@GetMapping("/budgets")
	public String viewAllBudget(Model model) {
		model.addAttribute("budgets", budgetRepository.findAll());
		return "budget-list";
	}
	
	
}









