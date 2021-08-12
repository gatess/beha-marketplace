package com.gates.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gates.dao.model.Role;
import com.gates.dao.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(RoleName roleName);
}
