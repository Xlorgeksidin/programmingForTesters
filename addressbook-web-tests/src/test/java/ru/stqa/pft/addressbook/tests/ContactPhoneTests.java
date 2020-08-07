package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase{

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
  public void testContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomeTelephone(), equalTo(cleaned(contactInfoFromEditForm.getHomeTelephone())));
    assertThat(contact.getMobileTelephone(), equalTo(cleaned(contactInfoFromEditForm.getMobileTelephone())));
    assertThat(contact.getWorkTelephone(), equalTo(cleaned(contactInfoFromEditForm.getWorkTelephone())));
  }

  public String cleaned(String phone){
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
