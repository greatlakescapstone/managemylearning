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
 

package com.greatlearning.capstone.mmladminportal.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.greatlearning.capstone.mmladminportal.model.MMLCourses;
import com.greatlearning.capstone.mmladminportal.repository.MMLCoursesRepository;
import com.greatlearning.capstone.mmladminportal.repository.UserRepository;

*//**
 * The type User controller.
 *
 * @author Givantha Kalansuriya
 *//*
@RestController
@RequestMapping("/api/v1")
public class ContentController {

  @Autowired
  private MMLCoursesRepository courseRepository;

  
  @PostMapping("/content") // //new annotation since 4.3
  public ResponseEntity<MMLCourses>  singleFileUpload(@RequestParam("file") MultipartFile file,
		  @RequestParam String newcategory,
		  @RequestParam String newauthor,@RequestParam String price,
		  @RequestParam String preview,@RequestParam String tags,
		  @RequestParam String title) {

      if (file.isEmpty()) {
          System.out.println("Please select a file to upload");
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
      

      try {

          // Get the file and save it somewhere
          byte[] bytes = file.getBytes();
          Path path = Paths.get("c:\\temp\\" + file.getOriginalFilename());
          Files.write(path, bytes);

          System.out.println(
                  "You successfully uploaded '" + file.getOriginalFilename() + "'");

      } catch (Exception e) {
          e.printStackTrace();
      }
      
      MMLCourses c= new MMLCourses(title,newcategory, newauthor, price, tags);
      
      return ResponseEntity.ok().body(c);
  

  }
}*/