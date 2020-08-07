package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts before = app.contact().all();
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
            .withNotes("notes");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()+1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }


}
