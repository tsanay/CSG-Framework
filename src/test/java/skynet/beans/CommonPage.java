package skynet.beans;

import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import skynet.config.BasePage;

@Component
public class CommonPage extends BasePage {
    By btn_option_menu;
    By btn_suboption_menu;
    By lbl_title;
    By lbl_profile;
    By btn_pencil_icon;
    By btn_editProfile = By.xpath("//*[@id=\"main-content\"]/descendant::a[contains(text(),\"Edit Profile\")]");
    By txt_search_resident = By.xpath("//*[@id=\"main-content\"]/descendant::input[contains(@placeholder, \"Search\")][1]");

    public String firstName;
    public String lastName;
    public Person.Sex gender;
    public String wearableId;

    public void setButtonOption(String option){
        btn_option_menu = By.xpath("//*[@id=\"main-menu-wrapper\"]/descendant::span[@class=\"title\"][contains(text(),\""+option+"\")]/ancestor::a");
    }

    public void setPencilIcon(String name){
        btn_pencil_icon = By.xpath("//*[@id=\"main-content\"]/descendant::h4[contains(text(),\""+name+"\")]/descendant::i[contains(@class,\"fa-pencil\")]");
    }

    public void setButtonSubOption(String option, String subOption){
        btn_suboption_menu = By.xpath("//*[@id=\"main-menu-wrapper\"]/descendant::span[@class=\"title\"][contains(text(),\""+option+"\")]/ancestor::a/following-sibling::*/descendant::*[contains(text(),"+subOption+")]");
    }

    public void setTitle(String title){
        lbl_title = By.xpath("//*[@id=\"main-content\"]/descendant::h3[contains(text(),\""+title+"\")]");
    }

    public void setProfile(String name){
        lbl_profile = By.xpath("//*[@id=\"main-content\"]/descendant::h4[contains(text(),\""+name+"\")]");
    }

    public void clickOption(){
        driver.findElement(btn_option_menu).click();
    }

    public void clickSubOption(){
        driver.findElement(btn_suboption_menu).click();
    }

    public void validatePage(String title){
        Assert.assertEquals(title,driver.findElement(lbl_title).getText());
    }

    public void validateProfile(String name){
        Assert.assertEquals(name,driver.findElement(lbl_profile).getText());
    }

    public void clickEditProfile(){
        driver.findElement(btn_editProfile).click();
    }

    public void searchPeople(String name){
        driver.findElement(txt_search_resident).sendKeys(name);
    }

    public void clickOnPencil(){
        driver.findElement(btn_pencil_icon).click();
    }

}
