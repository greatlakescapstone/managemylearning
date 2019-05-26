package com.greatlearning.capstone.mmladminportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.capstone.mmladminportal.model.User;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@Repository
public interface MMLSpaceOrgAccountRepository extends JpaRepository<User, Long> {}