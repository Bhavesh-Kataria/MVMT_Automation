package com.mvmt.tests;

import com.mvmt.base.Base;
import com.mvmt.pages.CreateAccountPage;
import com.mvmt.pages.LogInPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateAccountPageTests extends Base {
    public CreateAccountPage createAccountPage;

    public CreateAccountPageTests(){
        super();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        initialization(browser);
        createAccountPage = new CreateAccountPage();
    }

    @Test
    @Parameters("browser")
    public void fillFormTest(String browser) throws InterruptedException {
        log.info("Create Account Page Tests Method running....");
        Thread.sleep(5000);
        String firstName;
        String lastName;
        String phone;
        String email;
        String password;
        if(browser.equals("chrome")){
            firstName = prop.getProperty("fName");
            lastName = prop.getProperty("lName");
            phone = prop.getProperty("phone");
            email = prop.getProperty("email");
            password = prop.getProperty("password");
        }else{
            firstName = prop.getProperty("firefName");
            lastName = prop.getProperty("firelName");
            phone = prop.getProperty("firephone");
            email = prop.getProperty("fireemail");
            password = prop.getProperty("firepassword");
        }
        createAccountPage.fillForm(firstName,lastName,phone,email,password);
    }
}
