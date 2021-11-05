package com.revature.repositories;

import com.revature.models.User;
import com.revature.models.UserAddress;
import org.springframework.data.repository.CrudRepository;


public interface UserAddressRepo extends CrudRepository<UserAddress, Integer> {
    UserAddress findByUser(User u);
}
