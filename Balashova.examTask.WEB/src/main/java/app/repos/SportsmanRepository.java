package app.repos;

import app.Entities.Sportsman;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportsmanRepository extends CrudRepository <Sportsman,Integer> {

}
