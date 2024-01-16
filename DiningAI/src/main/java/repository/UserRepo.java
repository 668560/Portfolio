package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import model.User;

/**Conditions
 * 1.Creating a username thats unique
 * 2.Update an already registerd user, but not change displayname
 * 3.Fetch the user profile beloning to a user name
 * 4.Validates a user_submitteed dining review (if the user exists)
 */

public interface UserRepo extends JpaRepository<User, Long>{
	Optional<User> findUserByDisplayName(String displayName);
	

}
