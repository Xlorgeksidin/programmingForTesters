package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTest extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if(app.contact().list().size() == 0){
      app.contact().create(new ContactData().withFirstName("firstName").withMiddleName("MiddleName")
              .withLastName("LastName")
              .withNickname("nickname")
              .withTitle("title")
              .withCompany("company")
              .withAddress("address")
              .withHomeTelephone("home")
              .withMobileTelephone("mobile")
              .withWorkTelephone("work")
              .withFaxTelephone("fax")
              .withEmail("email")
              .withEmail2("email2")
              .withEmail3("email3")
              .withHomepage("homepage")
              .withDayOfBirth("1")
              .withMonthOfBirth("January")
              .withYearOfBirth("2001")
              .withDayOfAnniversary("6")
              .withMonthOfAnniversary("August")
              .withYearOfAnniversary("1993")
              .withGroupName("edit1")
              .withAddress2("address2")
              .withPhone2("phone2")
              .withNotes("notes"));
    }
  }

  @Test
  public void testDeletionContact(){
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size()-1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));

  }


}
