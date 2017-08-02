package user.system.repositories;

import com.sun.tracing.dtrace.ProviderAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import user.system.entities.User;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("select u.username, u.email from User as u where u.email like concat('%', :provider)")
    List<Object[]> getUsersByEmailProvider(@Param("provider") String provider);


    @Query("select u from User as u where u.lastTimeLoggedIn< :date")
    List<User> getNotActiveUsers(@Param("date") Date date);

}
