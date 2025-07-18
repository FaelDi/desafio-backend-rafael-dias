package com.wordpress.faeldi.desafio.backend.repository;

import com.wordpress.faeldi.desafio.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
