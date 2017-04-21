package com.artistbase2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by web on 21/04/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
