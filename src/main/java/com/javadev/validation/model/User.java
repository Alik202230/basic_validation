package com.javadev.validation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_user")
@Setter
@Getter
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String email;
  private String mobile;
  private String gender;
  private int age;
  private String nationality;

  public User(String name, String email, String mobile, String gender, int age, String nationality) {
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.gender = gender;
    this.age = age;
    this.nationality = nationality;
  }

}
