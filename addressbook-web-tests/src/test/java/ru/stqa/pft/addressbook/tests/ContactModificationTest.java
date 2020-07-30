package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{

  @Test
  public void testContactModification(){

    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactModificationForm(new ContactData("efirstName", "eMiddleName", "eLastName", "nickname", "title", "company", "address","home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "1", "January", "2001", "6", "August", "1993", "edit1", "address2", "phone2", "notes"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }

}
