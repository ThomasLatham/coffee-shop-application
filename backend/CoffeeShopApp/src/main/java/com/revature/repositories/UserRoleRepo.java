package com.revature.repositories;

import com.revature.models.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepo extends CrudRepository<UserRole, Integer> {
}
