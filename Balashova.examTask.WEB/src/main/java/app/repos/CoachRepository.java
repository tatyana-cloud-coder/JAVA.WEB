package app.repos;

import app.Entities.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends CrudRepository<Coach, Integer> {
}
