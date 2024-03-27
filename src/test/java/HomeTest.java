import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest extends BaseClass {
Homeclass homepage;

     @BeforeMethod
     void starting(){
         openBrowser("https://ebay.com");
         homepage= PageFactory.initElements(driver, Homeclass.class);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     }

    @AfterMethod
    void finishtest(){
        closeBrowser();
     }

    @Test
    void testmotors(){
        //System.out.println(driver.getCurrentUrl());
        String expectedUrl ="https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334";
        homepage.clickmotors();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

       // String expectedTitle ="Java is";
       // homepage.clickmotors();
        //String actualTitle =driver.getTitle();
       // Assert.assertEquals(actualTitle,expectedTitle);


     }
     @Test
    void testClassics(){
         homepage.moveToMotors();
         homepage.clickmotors();
         String expectedUrl="https://www.ebay.com/b/Classics/bn_7005623268";
         String actualUrl =driver.getCurrentUrl();
         Assert.assertEquals(actualUrl,expectedUrl);
     }

     @Test
    void testSearch(){
         homepage.search();
         String currentUrl= driver.getCurrentUrl();
         System.out.println(driver.getCurrentUrl() );
         Assert.assertTrue(currentUrl.contains("laptop"));
     }

     @Test
    void testAbout(){
         String expectedText = "About Ebay";
         String actualText = homepage.textAbout();
         Assert.assertEquals(actualText,expectedText);
     }

     @Test
    void testLinks(){
       //  Assert.assertEquals(homepage.allLinks() ,453);
         Assert.assertTrue(homepage.allLinks() > 400);

     }


}
