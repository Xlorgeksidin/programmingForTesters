package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size() == 0){
      app.group().create(new GroupData().withName("test1").withHeader("headerTest1").withFooter("Footer1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData editGroup = new GroupData().withId(modifiedGroup.getId())
            .withName("EEEtest1")
            .withHeader("headerTest1")
            .withFooter("Footer1");
    app.group().modify(editGroup);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(editGroup)));
  }


}
