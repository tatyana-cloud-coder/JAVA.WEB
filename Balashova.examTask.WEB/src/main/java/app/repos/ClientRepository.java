package app.repos;

import app.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public interface ClientRepository  extends JpaRepository<Client, Integer> {
    List<Client> findByFirstNameContaining(String firstName);
    @Query("select cl from Client cl where cl.firstName =:firstName and cl.lastName = :lastName")
    List <Client> findAllByFirstNameAndLastName(@Param("firstName") String firstName ,
                                                @Param("lastName") String lastName);
    @Query("select cl from Client cl inner join SportGroup gr on cl.group.idGroup = gr.idGroup where gr.number <=:number")
    List<Client> findAllByNumber(@Param("number") Integer number);
    @Query(value = "update Client cl Set cl.group.idGroup = Null where cl.group.idGroup =:idGroup", nativeQuery = true)
    void updateClientsGroup(@Param("idGroup") int idGroup);
}
