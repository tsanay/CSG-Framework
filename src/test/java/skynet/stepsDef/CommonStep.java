package skynet.stepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import skynet.beans.BeanContainer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonStep {
    @Autowired
    private BeanContainer container;

    ResultSet result;

    @And("^user clicks on \"(.*)\" option$")
    public void user_clicks_on_option(String option){
        container.common.setButtonOption(option);
        container.common.clickOption();
    }

    @And("^user clicks on \"(.*)\" sub-option of \"(.*)\"$")
    public void user_clicks_on_sub_option(String subOption, String option){
        container.common.setButtonSubOption(option, subOption);
        container.common.clickSubOption();
    }

    @Then("^user is taken to \"(.*)\" page$")
    public void user_is_taken_to_page(String title){
        try {
            //Test
            Assert.assertTrue(container.conn.validateInsertResident("John","Doe"));

            container.common.setTitle(title);
            container.common.validatePage(title.toUpperCase());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Then("^user is taken to \"(.*)\" profile$")
    public void user_is_taken_to_profile(String txt){
        //result = container.conn.getLastResident();
        String name = container.common.firstName+"  "+container.common.lastName;

        container.common.setProfile(name);
        container.common.validateProfile(name);

    }

    @And("^user clicks on Edit Profile button$")
    public void user_clicks_on_edit_profile_button(){
        container.common.clickEditProfile();
    }

    @Then("^user writes the following name \"(.*)\" in the search box$")
    public void user_writes_the_following_name_in_the_search_box(String txt){

        //result = container.conn.getLastResident();
        String name = container.common.firstName+"  "+container.common.lastName;

        container.common.searchPeople(name);

    }

    @And("^user clicks on the pencil icon next to \"(.*)\" label$")
    public void user_clicks_on_the_pencil_icon(String txt){
        //result = container.conn.getLastResident();
        String name = container.common.firstName+"  "+container.common.lastName;

        container.common.setPencilIcon(name);
        container.common.clickOnPencil();

    }
}
