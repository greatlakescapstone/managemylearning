package com.greatlearning.capstone.mmladminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.capstone.mmladminportal.model.Configurations;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@Repository
public interface ConfigurationRepository extends JpaRepository<Configurations, String> {
	
}