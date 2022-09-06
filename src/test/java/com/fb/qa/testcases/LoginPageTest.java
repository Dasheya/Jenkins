package com.fb.qa.testcases;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginPageTest extends TestBase {
    LoginPage loginpage;
    HomePage homepage;

    // call super class constuctor means TestBase constructor
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp() throws FileNotFoundException {
        initialization();
        loginpage = new LoginPage();
        homepage=new HomePage();
    }



    @Test(priority = 1)
    public void FB_logoTest()
    {
        boolean flag = loginpage.ValidateFB_Image();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void loginTest() {
        homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
