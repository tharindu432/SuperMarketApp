package com.youtube.SuperMarketApp.dao;

import com.youtube.SuperMarketApp.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
