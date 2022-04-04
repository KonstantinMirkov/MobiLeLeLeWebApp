package MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.repository;

import MobiLeLeLeWebApp_Exercise.MobiLeLeLeWebApp_Exercise.model.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
