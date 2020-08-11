package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/15 logo Neoflex eng.png");
    ContactData contact = new ContactData().withFirstName("firstName").withMiddleName("MiddleName")
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
            .withNotes("notes")
            .withPhoto(photo);
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }
}
