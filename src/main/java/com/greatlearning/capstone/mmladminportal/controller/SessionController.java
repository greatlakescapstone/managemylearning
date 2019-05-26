/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.greatlearning.capstone.mmladminportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.capstone.mmladminportal.exceptions.ResourceNotFoundException;
import com.greatlearning.capstone.mmladminportal.model.Admin;
import com.greatlearning.capstone.mmladminportal.repository.AdminRepository;

/**
 * The type Admin controller.
 *
 * @author Givantha Kalansuriya
 */
@RestController
@RequestMapping("/api/v1")
public class SessionController {

  @Autowired
  private AdminRepository adminRepository;
  
  /**
   * Get all admins list.
   *
   * @return the list
   */
  @PostMapping(path="/session", consumes = "application/json", produces = "application/json")
  
  public ResponseEntity<Admin> validateSessoin(@RequestBody Admin admin) {
	  System.out.println("Session data received " + admin);
	  if(admin.getAdmin().equals("admin") && admin.getPassword().equals("admin")) {
		  return ResponseEntity.ok().body(admin);
	  }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  
  /**
   * Get all admins list.
   *
   * @return the list
   */
  @GetMapping(path="/admins", produces = "application/json")
  public List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  /**
   * Gets admins by id.
   *
   * @param adminId the admin id
   * @return the admins by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping(path="/admins/{id}",  produces = "application/json")
  public ResponseEntity<Admin> getAdminsById(@PathVariable(value = "id") Long adminId)
      throws ResourceNotFoundException {
    Admin admin =
        adminRepository
            .findById(adminId)
            .orElseThrow(() -> new ResourceNotFoundException("Admin not found on :: " + adminId));
    return ResponseEntity.ok().body(admin);
  }

  /**
   * Create admin admin.
   *
   * @param admin the admin
   * @return the admin
   */
  @PostMapping(path="/admins", consumes = "application/json", produces = "application/json")
  public Admin createAdmin( @RequestBody Admin admin) {
    return adminRepository.save(admin);
  }

  /**
   * Update admin response entity.
   *
   * @param adminId the admin id
   * @param adminDetails the admin details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping(path="/admins/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Admin> updateAdmin(
      @PathVariable(value = "id") Long adminId, @Valid @RequestBody Admin adminDetails)
      throws ResourceNotFoundException {

    Admin admin =
        adminRepository
            .findById(adminId)
            .orElseThrow(() -> new ResourceNotFoundException("Admin not found on :: " + adminId));

    admin.setEmail(adminDetails.getEmail());
    admin.setAdmin(adminDetails.getAdmin());
    admin.setPassword(adminDetails.getPassword());
    admin.setStatus("active");
   
    final Admin updatedAdmin = adminRepository.save(admin);
    return ResponseEntity.ok(updatedAdmin);
  }

  /**
   * Delete admin map.
   *
   * @param adminId the admin id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping(path="/admins/{id}", consumes = "application/json", produces = "application/json")
  public Map<String, Boolean> deleteAdmin(@PathVariable(value = "id") Long adminId) throws Exception {
    Admin admin =
        adminRepository
            .findById(adminId)
            .orElseThrow(() -> new ResourceNotFoundException("Admin not found on :: " + adminId));

    adminRepository.delete(admin);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}