package in.pooja.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pooja.budgettracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	

}
