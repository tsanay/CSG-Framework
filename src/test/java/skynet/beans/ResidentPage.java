package skynet.beans;

import io.codearte.jfairy.producer.person.Person;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import skynet.config.BasePage;

@Component
public class ResidentPage extends BasePage {
    By btn_resident_buttons;
    By radio_gender_resident;
    By txt_firstName_resident = By.id("firstName");
    By txt_lastName_resident = By.id("lastName");
    By txt_wearableId_resident = By.name("bracelet");
    By btn_addResident = By.xpath("//*[@value=\"Add Resident\"]");
    By successful_modal = By.xpath("//h3[contains(text(),\"New resident has been successfully added!\")]");
    By btn_ok_modal = By.xpath("//button[contains(text(),\"Ok\")]");
    By toast_notification_error = By.xpath("//*[@id=\"toast-container\"]/descendant::div[contains(text(),\"The wearable id is not valid. Please enter a unique 12 character wearable id.\")]");
    By btn_editResident = By.id("EditResidentSubmit");

    public void setGender(Person.Sex gender){
        if (Person.Sex.MALE.equals(gender)){
            radio_gender_resident = By.name("7");
        }
        else{
            radio_gender_resident = By.name("8");
        }
    }

    public void setResidentsButtons(String btn){
        btn_resident_buttons = By.xpath("//*[@id=\"main-content\"]/descendant::*[contains(text(),\""+btn+"\")]");
    }

    public void fillForm(String firsName, String lastName, String wearableId){
        driver.findElement(txt_firstName_resident).sendKeys(firsName);
        driver.findElement(txt_lastName_resident).sendKeys(lastName);
        driver.findElement(radio_gender_resident).click();
        driver.findElement(txt_wearableId_resident).sendKeys(wearableId);
    }

    public void clickButton(){
        driver.findElement(btn_resident_buttons).click();
    }

    public void clickAddResident(){
        driver.findElement(btn_addResident).click();
    }

    public void validateModal(String title){
        Assert.assertEquals(title,driver.findElement(successful_modal).getText());
    }

    public void clickOkModal(){
        driver.findElement(btn_ok_modal).click();
    }

    public void validateToastNotificationError(String txt){
        Assert.assertEquals(txt,driver.findElement(toast_notification_error).getText());
    }

    public void clickEditResident(){
        driver.findElement(btn_editResident);
    }


}
