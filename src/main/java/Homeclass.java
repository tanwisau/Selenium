import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Homepage extends BaseClass {

    @FindBy(xpath = "//li[@data-hover-track=\"p4375194.m1379.l6435\"]")
    WebElement motors;

    @FindBy(css = "[data-hover-track=\"p4375194.m1379.l6435\"]")
    WebElement classics;

    @FindBy(css = "[placeholder=\"Search for anything\"]")
    WebElement searchbox;

    @FindBy(css ="[_sp=\"m571.l3601\"]" )
    WebElement aboutEbay;

    @FindBy(xpath = "//a"  )
    List<WebElement>links;

    void clickmotors(){
        motors.click();
    }

    void moveToMotors(){
        Actions actions=new Actions(driver);
        actions.moveToElement(motors);
    }

    void clickClassics(){
        classics.click();
    }

    void search(){
        searchbox.sendKeys("laptop" , Keys.ENTER);
    }

    String textAbout(){
       return  aboutEbay.getText();
    }

    int allLinks(){
        return links.size();
    }






}
