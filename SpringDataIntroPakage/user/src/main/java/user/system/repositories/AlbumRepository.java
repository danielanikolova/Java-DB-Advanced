package user.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user.system.entities.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{
}
