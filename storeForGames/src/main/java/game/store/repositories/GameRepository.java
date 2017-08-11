package game.store.repositories;

import game.store.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

    Game findByTitle(String title);

    @Query("select u.boughtGames from User as u where u.id = :id")
    List<Game> findOwnedByUser(@Param("id") Long id);


}
