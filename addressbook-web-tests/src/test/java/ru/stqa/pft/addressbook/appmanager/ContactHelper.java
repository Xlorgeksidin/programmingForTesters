package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd){
    super(wd);
  }

  public void fillContactForm(boolean creation, ContactData contactData) {
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

    if(creation){
      selectElementFromList(By.name("new_group"), contactData.getGroupName());
    } else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

    type(By.name("address2"), contactData.getAddress2());
    type(By.name("phone2"), contactData.getPhone2());
    type(By.name("notes"), contactData.getNotes());
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void initContactModification() {
    click(By.xpath("(//*[@id=\"maintable\"]/tbody//*[@alt='Edit'])[1]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//*[@name='selected[]']")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void confirmDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public void gotoCreateNewContact(){

    click(By.linkText("add new"));
  }

  public void createContact(ContactData contactData) {
    gotoCreateNewContact();
    fillContactForm(true, contactData);
    submitContactCreation();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//*[@name='selected[]'])[1]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for(WebElement element: elements){
      List<WebElement> row = element.findElements(By.tagName("td"));
      String lastName = row.get(1).getText();
      String firstName = row.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, firstName, null, lastName, null, null, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
      contacts.add(contact);
    }
    return contacts;
  }
}
