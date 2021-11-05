package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
