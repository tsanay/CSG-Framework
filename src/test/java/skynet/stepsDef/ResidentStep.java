package skynet.stepsDef;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import skynet.beans.BeanContainer;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ResidentStep {
    @Autowired
    public BeanContainer container;

    PreparedStatement pst;

    @When("^user clicks on \"(.*)\" button located above the table$")
    public void user_clicks_on_button_located_above_the_table(String button){
        container.resident.setResidentsButtons(button);
        container.resident.clickButton();
    }

    @And("^user enters the following data$")
    public void user_enters_the_following_data(DataTable table){
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        container.common.firstName = person.getFirstName();
        container.common.lastName = person.getLastName();
        container.common.gender = person.getSex();
        container.common.wearableId = fairy.textProducer().randomString(12);

        //List<List<String>> data = table.cells();
        container.resident.setGender(container.common.gender);
        container.resident.fillForm(container.common.firstName,container.common.lastName,container.common.wearableId);
    }

    @And("^user clicks on add resident button$")
    public void user_clicks_on_add_resident_button(){
        try {
            container.resident.clickAddResident();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^the following modal window should display \"(.*)\"$")
    public void successful_modal(String title){
        container.resident.validateModal(title);
    }

    @And("^user clicks on \"Ok\" modal button$")
    public void user_clicks_on_modal_button(){
        container.resident.clickOkModal();
    }

    @Then("^the following error toast notification \"(.*)\" should display$")
    public void error_toast_notification(String txt){
        container.resident.validateToastNotificationError(txt);
    }

    @And("^user clicks on edit resident button$")
    public void user_clicks_on_edit_resident_button(){
        container.resident.clickEditResident();
    }
}
