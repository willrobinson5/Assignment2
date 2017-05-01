package com.artistbase2.service;

import com.artistbase2.domain.LoginForm;
import com.artistbase2.domain.User;
import com.artistbase2.domain.UserRepository;
import com.artistbase2.domain.UserSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by web on 21/04/17.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User u) {return userRepository.save(u); }

    public List<User> findAll() { return userRepository.findAll(); }

    public void delete(User user) { userRepository.delete(user);}

    public boolean validateLogin(LoginForm user)
    {
        List<User> users = userRepository.checkUserInput(user.getAccountname(), user.getPassword());
//        List<User> users = userRepository.findByFirstnameAndPassword(user.getAccountname(), user.getPassword());

        return users !=null && users.size()>0;
    }

    public List<User> searchUsers(UserSearchForm user)
    {
//        if(user.getFirstname().isEmpty() && user.getSurname().isEmpty())
//        {
//            return userRepository.findAll();
//        }
        return userRepository.searchUsers(user.getFirstname(), user.getSurname());
    }
}
