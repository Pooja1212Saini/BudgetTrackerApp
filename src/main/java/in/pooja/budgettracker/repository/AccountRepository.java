package in.pooja.budgettracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import in.pooja.budgettracker.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long>{
	Optional<Account>findByEmail(String email);
	Optional<Account> findByResetToken(String token);

}
