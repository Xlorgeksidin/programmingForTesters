package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String homeTelephone;
  private final String mobileTelephone;
  private final String workTelephone;
  private final String faxTelephone;
  private final String email;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String dayOfBirth;
  private final String monthOfBirth;
  private final String yearOfBirth;
  private final String dayOfAnniversary;
  private final String monthOfAnniversary;
  private final String yearOfAnniversary;
  private final String groupName;
  private final String address2;
  private final String phone2;
  private final String notes;
  private final String address;

  public ContactData(String firstName, String middleName, String lastName, String nickname, String title, String company, String address, String homeTelephone, String mobileTelephone, String workTelephone, String faxTelephone, String email, String email2, String email3, String homepage, String dayOfBirth, String monthOfBirth, String yearOfBirth, String dayOfAnniversary, String monthOfAnniversary, String yearOfAnniversary, String groupName, String address2, String phone2, String notes) {
    this.address = address;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.homeTelephone = homeTelephone;
    this.mobileTelephone = mobileTelephone;
    this.workTelephone = workTelephone;
    this.faxTelephone = faxTelephone;
    this.email = email;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.dayOfBirth = dayOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.yearOfBirth = yearOfBirth;
    this.dayOfAnniversary = dayOfAnniversary;
    this.monthOfAnniversary = monthOfAnniversary;
    this.yearOfAnniversary = yearOfAnniversary;
    this.groupName = groupName;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
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
}
