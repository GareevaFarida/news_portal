package ru.geek.news_portal.ui_news_portal.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geek.news_portal.ui_news_portal.utils.validation.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
public class SystemUser {
    @NotNull(message = "is required")
    @Size(min = 4, message = "is required (min 4 chars")
    private String username;

    @NotNull(message = "is required")
    @Size(min = 4, message = "password is too short")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 4, message = "password is too short")
    private String matchingPassword;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 4, message = "is required")
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public CharSequence getPassword() {
        return password;
    }

  public String getFirstName() {
      return firstName;
  }

  public String getLastName() {
      return lastName;
  }

  public String getEmail() {
      return email;
  }
}
