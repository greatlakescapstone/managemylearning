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

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.capstone.mmladminportal.exceptions.ResourceNotFoundException;
import com.greatlearning.capstone.mmladminportal.model.Configurations;
import com.greatlearning.capstone.mmladminportal.repository.ConfigurationRepository;

/**
 * The type Admin controller.
 *
 * @author Givantha Kalansuriya
 */
@RestController
@RequestMapping("/api/v1")
public class ConfigurationController {

  @Autowired
  private ConfigurationRepository configurationRepository;
  

  
  /**
   * Get all admins list.
   *
   * @return the list
   */
  @GetMapping(path="/config", produces = "application/json")
  public List<Configurations> getAllAdmins() {
    return configurationRepository.findAll();
  }

  /**
   * Gets admins by id.
   *
   * @param adminId the admin id
   * @return the admins by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping(path="/config/{id}",  produces = "application/json")
  public ResponseEntity<Configurations> getAdminsById(@PathVariable(value = "id") String configurationsId)
      throws ResourceNotFoundException {
	  Configurations configurations =
        configurationRepository
            .findById(configurationsId)
            .orElseThrow(() -> new ResourceNotFoundException("Configurations not found on :: " + configurationsId));
    return ResponseEntity.ok().body(configurations);
  }

  /**
   * Create admin admin.
   *
   * @param admin the admin
   * @return the admin
   */
  @PostMapping(path="/config", consumes = "application/json", produces = "application/json")
  public Configurations createAdmin( @RequestBody Configurations configurations) {
    return configurationRepository.save(configurations);
  }

  /**
   * Update admin response entity.
   *
   * @param adminId the admin id
   * @param adminDetails the admin details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping(path="/config/{id}", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Configurations> updateAdmin(
      @PathVariable(value = "id") String configurationsId, @Valid @RequestBody Configurations configurationsDetails)
      throws ResourceNotFoundException {

	  Configurations configurations =
        configurationRepository
            .findById(configurationsId)
            .orElseThrow(() -> new ResourceNotFoundException("Configurations not found on :: " + configurationsId));


   
	  configurationsDetails = configurationRepository.save(configurationsDetails);
    return ResponseEntity.ok(configurations);
  }


}