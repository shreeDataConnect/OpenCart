package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
    @Test(groups = {"Sanity","Master"})
    public void verify_login()
    {
        logger.info("***** Starting TC002_LoginTest *******");

        try
        {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassWord(p.getProperty("password"));
            lp.clickLogin();

            MyAccountPage myac = new MyAccountPage(driver);
            boolean flgMyAcnt = myac.isMyAccountPageExists();

            Assert.assertTrue(flgMyAcnt); //Assert.assertEquals(flgMyAcnt,true,"Login failed");
        }
        /*if (flgMyAcnt)
        {
            Assert.assertTrue(true);
            logger.info("My account page exists");
        }
        else
        {
            Assert.assertTrue(false);
            logger.error("My page not exists");
        }*/
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("********* Finished TC002_LoginTest *******");
    }
}
