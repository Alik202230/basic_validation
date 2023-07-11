package com.javadev.validation.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRequest {

  @NotNull(message = "username should not be null")
  private String name;

  @Email(message = "Invalid email address")
  private String email;

  @NotNull
  @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number")
  private String mobile;
  private String gender;

  @Min(value = 18)
  @Max(value = 60)
  private int age;

  @NotBlank
  private String nationality;

}
