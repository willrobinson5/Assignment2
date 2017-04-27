package com.artistbase2.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by web on 21/04/17.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstnameAndPassword(String accountname, String password);

    @Query("SELECT u FROM User u WHERE u.firstname=?1 AND u.password=?2")
    List<User> checkUserInput(String accountname, String password);

    @Query("SELECT u FROM User u WHERE u.firstname like %?1% AND u.surname like %?2%")
    List<User> searchUsers(String firstname, String surname);
}

