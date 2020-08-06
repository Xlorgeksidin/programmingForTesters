package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().list().size() == 0){
      app.contact().create(new ContactData("firstName", "MiddleName", "LastName", "nickname", "title", "company", "address","home", "mobile", "work", "fax", "email", "email2", "email3", "homepage", "1", "January", "2001", "6", "August", "1993", "edit1", "address2", "phone2", "notes"));
    }
  }

  @Test
  public void testDeletionContact(){
    List<ContactData> before = app.contact().list();
    int index = before.size()-1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(after, before);

  }


}
