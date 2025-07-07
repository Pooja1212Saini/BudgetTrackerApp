package in.pooja.budgettracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pooja.budgettracker.model.Budget;

public interface BudgetRepository extends JpaRepository <Budget, Long> {

}
