package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.File;

@XStreamAlias("contact")
public class ContactData {

  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private  String firstName;
  @Expose
  private  String middleName;
  @Expose
  private  String lastName;
  @Expose
  private  String nickname;
  @Expose
  private  String title;
  @Expose
  private  String company;
  @Expose
  private  String homeTelephone;
  @Expose
  private  String mobileTelephone;
  @Expose
  private  String workTelephone;
  @Expose
  private  String faxTelephone;
  @Expose
  private  String email;
  @Expose
  private  String email2;
  @Expose
  private  String email3;
  @Expose
  private  String homepage;
  @Expose
  private  String dayOfBirth;
  @Expose
  private  String monthOfBirth;
  @Expose
  private  String yearOfBirth;
  @Expose
  private  String dayOfAnniversary;
  @Expose
  private  String monthOfAnniversary;
  @Expose
  private  String yearOfAnniversary;
  @Expose
  private  String groupName;
  @Expose
  private  String address2;
  @Expose
  private  String phone2;
  @Expose
  private  String notes;
  @Expose
  private  String address;
  @Expose
  private String allPhones;
  @Expose
  private String allEmails;
  @Expose
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withHomeTelephone(String homeTelephone) {
    this.homeTelephone = homeTelephone;
    return this;
  }

  public ContactData withMobileTelephone(String mobileTelephone) {
    this.mobileTelephone = mobileTelephone;
    return this;
  }

  public ContactData withWorkTelephone(String workTelephone) {
    this.workTelephone = workTelephone;
    return this;
  }

  public ContactData withFaxTelephone(String faxTelephone) {
    this.faxTelephone = faxTelephone;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withDayOfBirth(String dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
    return this;
  }

  public ContactData withMonthOfBirth(String monthOfBirth) {
    this.monthOfBirth = monthOfBirth;
    return this;
  }

  public ContactData withYearOfBirth(String yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
    return this;
  }

  public ContactData withDayOfAnniversary(String dayOfAnniversary) {
    this.dayOfAnniversary = dayOfAnniversary;
    return this;
  }

  public ContactData withMonthOfAnniversary(String monthOfAnniversary) {
    this.monthOfAnniversary = monthOfAnniversary;
    return this;
  }

  public ContactData withYearOfAnniversary(String yearOfAnniversary) {
    this.yearOfAnniversary = yearOfAnniversary;
    return this;
  }

  public ContactData withGroupName(String groupName) {
    this.groupName = groupName;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getHomeTelephone() {
    return homeTelephone;
  }

  public String getMobileTelephone() {
    return mobileTelephone;
  }

  public String getWorkTelephone() {
    return workTelephone;
  }

  public String getFaxTelephone() {
    return faxTelephone;
  }

  public String getEmail() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getDayOfBirth() {
    return dayOfBirth;
  }

  public String getMonthOfBirth() {
    return monthOfBirth;
  }

  public String getYearOfBirth() {
    return yearOfBirth;
  }

  public String getDayOfAnniversary() {
    return dayOfAnniversary;
  }

  public String getMonthOfAnniversary() {
    return monthOfAnniversary;
  }

  public String getYearOfAnniversary() {
    return yearOfAnniversary;
  }

  public String getGroupName() {
    return groupName;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }

  public String getAddress() {
    return address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }


}
