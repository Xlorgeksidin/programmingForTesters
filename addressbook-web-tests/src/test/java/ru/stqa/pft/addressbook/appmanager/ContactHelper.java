package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

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
    attach(By.name("photo"), contactData.getPhoto());
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

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void create(ContactData contactData) {
    gotoCreateNewContact();
    fillContactForm(true, contactData);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(int indexContact, ContactData contact) {
    selectContact(indexContact);
    initContactModification();
    fillContactForm(false, contact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(false, contact);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContacts();
    contactCache = null;
    confirmDeletionContact();
    click(By.linkText("home"));
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
    confirmDeletionContact();
    click(By.linkText("home"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("(//*[@name='selected[]'])[1]"));
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for(WebElement element: elements){
      List<WebElement> row = element.findElements(By.tagName("td"));
      String lastName = row.get(1).getText();
      String firstName = row.get(2).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if(contactCache != null){
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for(WebElement element: elements){
      List<WebElement> row = element.findElements(By.tagName("td"));
      String lastName = row.get(1).getText();
      String firstName = row.get(2).getText();
      String allPhones = row.get(5).getText();
      String allEmails = row.get(4).getText();
      String address = row.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }


  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String phone2 = wd.findElement(By.name("phone2")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname)
            .withLastName(lastname)
            .withHomeTelephone(home)
            .withMobileTelephone(mobile)
            .withWorkTelephone(work)
            .withPhone2(phone2)
            .withEmail(email)
            .withEmail2(email2)
            .withEmail3(email3)
            .withAddress(address);

  }

  private void initContactModificationById(int id) {
    click(By.xpath("//a[@href=\"edit.php?id=" + id + "\"]"));
  }

}
