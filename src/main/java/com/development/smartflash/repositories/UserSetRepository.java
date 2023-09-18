package com.development.smartflash.repositories;

import com.development.smartflash.entities.UserSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSetRepository extends JpaRepository<UserSet, Long> {
}
