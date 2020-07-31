package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase{

  @Test
  public void testDeletionContact(){
    app.getNavigationHelper().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("firstName", "MiddleName", "LastName", "nickname", "title", "company", "address","home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "1", "January", "2001", "6", "August", "1993", "edit1", "address2", "phone2", "notes"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().confirmDeletionContact();
  }
}
