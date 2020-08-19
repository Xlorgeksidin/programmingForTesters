package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase{

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
  public void testContactModification(){


    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstName("EEEfirstName")
            .withMiddleName("MiddleName")
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
            .withNotes("notes");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }



}
