package skynet.stepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import skynet.beans.BeanContainer;

public class LoginStep {
    @Autowired
    private BeanContainer container;


    @Given("^user is on skynet health care page$")
    public void user_is_on_skynet_health_care_page(){

        container.login.sendURLToBasePage("http://10.80.0.51:81/");
    }

    @When("^user enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_username_password(String username, String password){
        container.login.setUsername(username);
        container.login.setPassword(password);
    }

    @And("^user clicks on login button$")
    public void user_clicks_on_login_button() {
        try {
            container.login.clickLogin();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^the following error message \"(.*)\" should display$")
    public void the_following_error_message_should_display(String message){
        container.login.validateErrorMessage(message);
    }
}
