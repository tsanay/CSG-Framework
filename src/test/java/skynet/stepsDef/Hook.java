package skynet.stepsDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import skynet.config.BasePage;

public class Hook extends BasePage {

    @Before("@Test")
    public void setUp(){

        initialization();
    }

    @After("@Test")
    public void tearDown(){
        driver.quit();
    }
}
