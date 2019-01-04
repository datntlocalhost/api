package jp.com.run.model.request;

import jp.co.run.validation.annotation.Email;
import jp.co.run.validation.annotation.Hiragana;
import jp.co.run.validation.annotation.Katakana;
import jp.co.run.validation.annotation.MaxLength;
import jp.co.run.validation.annotation.NotNull;

/**
 * The Class InquiryRequestModel.
 */
public class InquiryRequestModel {

    /** The title. */
    private String title;

    /** The content. */
    @NotNull(itemName = "Content", message = "Content not null")
    @MaxLength(itemName = "Content", message = "Max length 1000 character", maxLength = 1000)
    private String content;

    /** The last name hira. */
    @NotNull(itemName = "lastNameHiragana", message = "Last name not null")
    @Hiragana(itemName = "lastNameHiragana", message = "Last name have to input hiragana character")
    private String lastNameHira;

    /** The first name hira. */
    @NotNull(itemName = "firstNameHiragana", message = "First name not null")
    @Hiragana(itemName = "firstNameHiragana", message = "First name have to input hiragana character")
    private String firstNameHira;

    /** The last name kata. */
    @NotNull(itemName = "lastNameKatakana", message = "Last name not null")
    @Katakana(itemName = "lastNameKatakana", message = "Last name have to input katakana character")
    private String lastNameKata;

    /** The first name kata. */
    @NotNull(itemName = "firstNameKatakana", message = "First name not null")
    @Katakana(itemName = "firstNameKatakana", message = "First name have to input katakana character")
    private String firstNameKata;

    /** The email. */
    @NotNull(itemName = "Email", message = "Email not null")
    @Email(itemName = "Email", message = "Invalid email")
    @MaxLength(itemName = "Email", message = "Max length 60", maxLength = 60)
    private String email;

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the last name hira.
     *
     * @return the last name hira
     */
    public String getLastNameHira() {
        return lastNameHira;
    }

    /**
     * Sets the last name hira.
     *
     * @param lastNameHira the new last name hira
     */
    public void setLastNameHira(String lastNameHira) {
        this.lastNameHira = lastNameHira;
    }

    /**
     * Gets the first name hira.
     *
     * @return the first name hira
     */
    public String getFirstNameHira() {
        return firstNameHira;
    }

    /**
     * Sets the first name hira.
     *
     * @param firstNameHira the new first name hira
     */
    public void setFirstNameHira(String firstNameHira) {
        this.firstNameHira = firstNameHira;
    }

    /**
     * Gets the last name kata.
     *
     * @return the last name kata
     */
    public String getLastNameKata() {
        return lastNameKata;
    }

    /**
     * Sets the last name kata.
     *
     * @param lastNameKata the new last name kata
     */
    public void setLastNameKata(String lastNameKata) {
        this.lastNameKata = lastNameKata;
    }

    /**
     * Gets the first name kata.
     *
     * @return the first name kata
     */
    public String getFirstNameKata() {
        return firstNameKata;
    }

    /**
     * Sets the first name kata.
     *
     * @param firstNameKata the new first name kata
     */
    public void setFirstNameKata(String firstNameKata) {
        this.firstNameKata = firstNameKata;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
