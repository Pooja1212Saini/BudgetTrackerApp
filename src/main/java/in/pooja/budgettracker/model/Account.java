package in.pooja.budgettracker.model;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	 @Column(unique=true)
	 @NotBlank(message="Username is required")
	 private String username;
	 
	 
	 @Column(nullable = false)
	 private String name;
	 
	 @NotBlank(message="Password is required")
	 private String password;
	 
	 @NotBlank(message="Email is required")
	 @Email(message="Enter a  valid email")
	 private String email;
	 
	 
	 private LocalDate createdAt;
	 private LocalDate updatedAt;
	 
	 @PrePersist
	 protected void onCreate() {
		  this.createdAt = LocalDate.now();
		  this.updatedAt = LocalDate.now();
	 }
	 @PreUpdate
	 protected void onUpdate() {
		this.updatedAt= LocalDate.now();
	 }
	 
	 @Column(name = "reset_token")
	 private String resetToken;

	 
}












