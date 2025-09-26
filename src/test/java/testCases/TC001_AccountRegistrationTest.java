package testCases;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.time.Duration;

public class TC001_AccountRegistrationTest extends BaseClass
{

    @Test(groups = {"Regression","Master"})
    public void verify_account_registration() throws InterruptedException
    {

        logger.info("*** TC001_AccountRegistrationTest ***");
        try
        {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account link");
            hp.clickRegister();
            logger.info("Clicked on Register link");
            AccountRegistrationPage ar = new AccountRegistrationPage(driver);
            logger.info("Providing customer details..");
            ar.setFirstname(randomString().toUpperCase());
            ar.setLastname(randomString().toUpperCase());
            ar.setEmil(randomString() + "@gmail.com");
            ar.setTelephone(randomNumber());
            String pwd = randomAlphaNumeric();
            ar.setPassword(pwd);
            ar.setConfirmPassword(pwd);
            //Thread.sleep(3000);
            ar.setPrivacyPolicy();
            ar.clickContinue();
            Thread.sleep(3000);
            logger.info("Validated expecting message..");
            String confmsg=ar.getConfirmationMsg();
            if (confmsg.equals("Your Account Has Been Created!"))
            {
                Assert.assertTrue(true);
            }
            else
            {
                logger.error("Test failed...");
                logger.debug("Debug logs...");
                Assert.assertTrue(false);
            }
            // Hard assertion, remaining lines of code after Asert do not execute...

            //Assert.assertEquals(ar.getConfirmationMsg(), "Your Account Has Been Created");
        }
        catch (Exception e)
        {
            Assert.fail();
        }

        // **** The Below line of code isn't executed after the above code of catch block executed
        logger.info("*** TC001_AccountRegistrationTest finished ***");

    }


}
