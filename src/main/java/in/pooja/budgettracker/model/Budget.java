package in.pooja.budgettracker.model;

import java.time.LocalDate;

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
public class Budget {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message ="Budget name is required")
	private String name;
	
	@NotNull(message="Amount is required")
	@Min(value=1, message= "Amount should be at least 1")
	private Double amount;
	
	@NotNull(message="Start date is required")
	private LocalDate startDate;
	
	@NotNull(message = "End date is required")
	private LocalDate endDate;
	
}
