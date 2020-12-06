package app.repos;

import app.Entities.Referee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeRepository extends CrudRepository <Referee, Integer> {
}
