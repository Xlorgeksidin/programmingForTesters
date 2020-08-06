package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase{


  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();
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
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()+1);

    contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
