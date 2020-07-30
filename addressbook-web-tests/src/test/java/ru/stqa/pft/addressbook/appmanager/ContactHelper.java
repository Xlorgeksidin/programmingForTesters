package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd){
    super(wd);
  }

  public void fillContactForm(ContactData contactData) throws InterruptedException {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomeTelephone());
    type(By.name("mobile"), contactData.getMobileTelephone());
    type(By.name("work"), contactData.getWorkTelephone());
    type(By.name("fax"), contactData.getFaxTelephone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());

    selectElementFromList(By.name("bday"), contactData.getDayOfBirth());
    selectElementFromList(By.name("bmonth"), contactData.getMonthOfBirth());
    type(By.name("byear"), contactData.getYearOfBirth());
    selectElementFromList(By.name("aday"), contactData.getDayOfAnniversary());
    selectElementFromList(By.name("amonth"), contactData.getMonthOfAnniversary());
    type(By.name("ayear"), contactData.getYearOfAnniversary());
    selectElementFromList(By.name("new_group"), contactData.getGroupName());
    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());
    click(By.xpath("(//input[@name='submit'])[2]"));

  }
  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

}
