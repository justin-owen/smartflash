package com.development.smartflash.repositories;

import com.development.smartflash.entities.User;
import com.development.smartflash.entities.UserSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSetRepository extends JpaRepository<UserSet, Long> {

    List<UserSet> findAllByUserEquals(User user);

    @Query(value = "SELECT s FROM sets s WHERE s.subject= :subject")
    List<UserSet> findAllBySubject(@Param("subject") String subject);

    @Query(value = "SELECT s FROM sets s WHERE s.id= :setId")
    Optional<UserSet> findById(@Param("setId") Long setId);
}
