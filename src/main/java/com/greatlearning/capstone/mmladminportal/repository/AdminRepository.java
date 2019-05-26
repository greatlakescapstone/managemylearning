package com.greatlearning.capstone.mmladminportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.capstone.mmladminportal.model.Admin;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	
	public Admin findOneByAdmin(String name);
    public Admin findOneByAdminOrId(String name, Long id);
    public List<Admin> findAll();
    
}