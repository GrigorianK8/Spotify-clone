package com.grigoriank.spotifyBackend.usercontext.repository;

import com.grigoriank.spotifyBackend.usercontext.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);
}
