package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.getNavigationHelper().gotoHomePage();
    if(!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("firstName", "MiddleName", "LastName", "nickname", "title", "company", "address","home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "1", "January", "2001", "6", "August", "1993", "edit1", "address2", "phone2", "notes"));
    }
  }

  @Test
  public void testContactModification(){


    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(index).getId(),"firstName", "MiddleName", "LastName", "nickname", "title", "company", "address","home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "1", "January", "2001", "6", "August", "1993", "edit1", "address2", "phone2", "notes");
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }



}
