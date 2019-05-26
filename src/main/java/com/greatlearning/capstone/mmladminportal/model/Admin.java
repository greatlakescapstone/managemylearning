package com.greatlearning.capstone.mmladminportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The type User.
 *
 * @author Givantha Kalansuriya
 */
@Entity
@Table(name = "admin")
@EntityListeners(AuditingEntityListener.class)
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Column(name = "admin", nullable = false, unique = true)
	@NotNull
	private String admin;

	@Column(name = "password", nullable = false)
	@NotNull
	private String password;
	
	@Column(name = "email", nullable = false)
	@NotNull
	private String email;


	@Column(name = "status", nullable = false)
	@NotNull
	private String status;
	
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date createdAt;

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id
	 *            the id
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", admin=" + admin + ", password=" + password + ", email=" + email + ", status="
				+ status + ", lastLogin=" + lastLogin + ", createdAt=" + createdAt + "]";
	}


}