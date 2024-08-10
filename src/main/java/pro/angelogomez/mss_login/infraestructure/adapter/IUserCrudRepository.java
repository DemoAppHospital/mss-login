package pro.angelogomez.mss_login.infraestructure.adapter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pro.angelogomez.mss_login.infraestructure.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository<UserEntity, Integer>{
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT users.email FROM UserEntity users")
    List<String> findAllEmails();
}
