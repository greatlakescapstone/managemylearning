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
import org.springframework.data.annotation.CreatedBy;
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
public class MMLSpaceUserAccount {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(name = "userid", nullable = false)
   private String userid;

   @Column(name = "password", nullable = false)
   private String password;

   @Column(name = "firstname", nullable = false)
   private String firstname;
   

   @Column(name = "lasname", nullable = false)
   private String lasname;

   @Column(name = "email", nullable = false)
   private String email;
   
   @Column(name = "gender", nullable = false)
   private String gender;
   
   @Temporal(TemporalType.DATE)
   @Column(name = "dob", nullable = false)
   private Date dob;
   
   @Column(name = "address_line1", nullable = false)
   private String address_line1;
   
   @Column(name = "address_line2", nullable = false)
   private String address_line2;
   
   @Column(name = "city", nullable = false)
   private String city;
   
   @Column(name = "state", nullable = false)
   private String state;
   
   @Column(name = "country", nullable = false)
   private String country;
   
   @Column(name = "pinorzip", nullable = false)
   private String pinorzip;
   
   
   
   @CreationTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "created_at", nullable = false)
   private Date createdAt;

   @Column(name = "created_by", nullable = false)
   @CreatedBy
   private String createdBy;

   @UpdateTimestamp
   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "updated_at", nullable = false)
   private Date updatedAt;

   @Column(name = "updated_by", nullable = false)
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

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLasname() {
	return lasname;
}

public void setLasname(String lasname) {
	this.lasname = lasname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getAddress_line1() {
	return address_line1;
}

public void setAddress_line1(String address_line1) {
	this.address_line1 = address_line1;
}

public String getAddress_line2() {
	return address_line2;
}

public void setAddress_line2(String address_line2) {
	this.address_line2 = address_line2;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getPinorzip() {
	return pinorzip;
}

public void setPinorzip(String pinorzip) {
	this.pinorzip = pinorzip;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
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
	return "MMLSpaceUserAccount [id=" + id + ", userid=" + userid + ", password=" + password + ", firstname="
			+ firstname + ", lasname=" + lasname + ", email=" + email + ", gender=" + gender + ", dob=" + dob
			+ ", address_line1=" + address_line1 + ", address_line2=" + address_line2 + ", city=" + city + ", state="
			+ state + ", country=" + country + ", pinorzip=" + pinorzip + ", createdAt=" + createdAt + ", createdBy="
			+ createdBy + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy + "]";
}

 

}