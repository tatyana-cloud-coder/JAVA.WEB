package app.repos;

import app.Entities.KindSport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindSportRepository extends CrudRepository <KindSport, Integer> {
}
