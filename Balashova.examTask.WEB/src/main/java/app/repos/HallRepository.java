package app.repos;

import app.Entities.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends CrudRepository <Hall,Integer> {
}
