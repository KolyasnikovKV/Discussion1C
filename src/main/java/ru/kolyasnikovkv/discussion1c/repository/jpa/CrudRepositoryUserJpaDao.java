package ru.kolyasnikovkv.discussion1c.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kolyasnikovkv.discussion1c.model.User;

import java.util.List;

public interface CrudRepositoryUserJpaDao extends JpaRepository<User, Integer> {
    List<User> findByUsername(String name);

    /*@Query("DELETE FROM Country m WHERE m.id=:id")
    int delete(@Param("id") Long id);
    */
}