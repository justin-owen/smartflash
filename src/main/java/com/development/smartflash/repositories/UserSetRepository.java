package com.development.smartflash.repositories;

import com.development.smartflash.entities.User;
import com.development.smartflash.entities.UserSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSetRepository extends JpaRepository<UserSet, Long> {
    List<UserSet> findAllByUserEquals(User user);

    @Query("SELECT s from sets s where s.subject=?1")
    Optional<UserSet> findAllBySubject(String subject);
}
