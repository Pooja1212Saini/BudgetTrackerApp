package in.pooja.budgettracker.model;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@NotBlank(message = "Expense name is required")
	private String name;
	
	
	@NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be at least 1")
	private Double amount;
	
	@NotNull(message = "Date is required")
    private LocalDate date;
	
	private String category;
}


















