package jp.com.run.model.request;

import jp.co.run.validation.annotation.Email;
import jp.co.run.validation.annotation.Kanji;
import jp.co.run.validation.annotation.Length;
import jp.co.run.validation.annotation.MaxLength;
import jp.co.run.validation.annotation.NotNull;
import jp.co.run.validation.annotation.Password;

public class RegisterRequestModel {

    @NotNull(itemName = "Email", message = "Not null")
    @Email(itemName = "Email", message = "Invalid email")
    @MaxLength(itemName = "Email", message = "Max length 60", maxLength = 60)
    private String email;

    @NotNull(itemName = "Password", message = "Not null")
    @Password(itemName = "Password", message = "Invalid password")
    @Length(itemName = "Password", message = "Min length 6 - Max length 10", minLength = 6, maxLength = 10)
    private String password;
    
    @NotNull(itemName = "Name", message = "Not null")
    @Kanji(itemName = "Name", message = "Name have to input kanji character")
    @MaxLength(itemName = "Name", message = "Max length 15", maxLength = 15)
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
