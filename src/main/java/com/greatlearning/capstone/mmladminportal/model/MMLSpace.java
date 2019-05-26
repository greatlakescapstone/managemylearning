package com.greatlearning.capstone.mmladminportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
* The type User.
*
* @author Givantha Kalansuriya
*/
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class MMLSpace {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(name = "spaceName", nullable = false, unique = true)
   @NotNull
   private String spaceName;
   
   @Column(name = "email", nullable = false)
   @NotNull
   private String email;
   
   
   @ManyToOne
   private MMLSpaceOrgAccount  orgAccount;
   
   @CreationTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "created_at", nullable = false)
   private Date createdAt;

   @UpdateTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "updated_at", nullable = false)
   private Date updatedAt;

   @Column(name = "updated_by")
   @LastModifiedBy
   private String updatedBy;

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
  * @param id the id
  */
 public void setId(long id) {
       this.id = id;
   }

public String getSpaceName() {
	return spaceName;
}

public void setSpaceName(String spaceName) {
	this.spaceName = spaceName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public String getUpdatedBy() {
	return updatedBy;
}

public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}

@Override
public String toString() {
	return "MMLSpace [id=" + id + ", spaceName=" + spaceName + ", email=" + email + ", createdAt=" + createdAt
			+ ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + "]";
}



}