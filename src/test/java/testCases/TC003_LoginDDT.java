package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{

    @Test(dataProvider="Logindata",dataProviderClass=DataProviders.class,groups = "DataDriven")
    public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
    {
        logger.info("***** starting TC_003_LoginDDT *******");

        try
        {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassWord(pwd);
            lp.clickLogin();

            MyAccountPage myac = new MyAccountPage(driver);
            boolean flgMyAcnt = myac.isMyAccountPageExists();

            if (exp.equalsIgnoreCase("Valid")) {
                if (flgMyAcnt == true) {
                    myac.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (flgMyAcnt == true) {
                    myac.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("***** Completed TC_003_LoginDDT *******");
        //Thread.sleep(5000);
    }
}
