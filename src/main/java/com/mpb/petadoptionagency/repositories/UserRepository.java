package com.mpb.petadoptionagency.repositories;

import com.mpb.petadoptionagency.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT s FROM User s WHERE s.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
