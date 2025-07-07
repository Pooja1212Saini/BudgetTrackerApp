package in.pooja.budgettracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.pooja.budgettracker.model.Expense;
import in.pooja.budgettracker.repository.ExpenseRepository;
import jakarta.validation.Valid;

@Controller
public class ExpenseController {
	
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	//Show Add Expense Form 
	@GetMapping("/expense/add")
	public String showAddExpense(Model model) {
		model.addAttribute("expense", new Expense());
		return "add-expense";
	}
	

	
	//Handle Expense Submission
	@PostMapping("/expense/add")
	 public String saveExpense(@Valid @ModelAttribute Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-expense";
			
			
		}
		expenseRepository.save(expense);
		model.addAttribute("successMessage", "Expense added successfully !");
		model.addAttribute("expense", new Expense());
		return "add-expense";
	}
	
	// View All Expense
	
	@GetMapping("/expenses")
	public String viewAllExpense(Model model) {
		model.addAttribute("expenses", expenseRepository.findAll());
		return "expense-list";
	}
}





















