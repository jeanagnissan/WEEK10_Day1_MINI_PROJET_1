package com.adaci.userproject.repository;

import com.adaci.userproject.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUser extends CrudRepository<Users, Long> {
}
