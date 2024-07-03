import Utiles.helpers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;
import java.util.Random;

import static Utiles.PropertiesLoader.readPropertyFile;

public class CreateNewService extends BaseTest{
    helpers help;
    Properties envProp = readPropertyFile("Config/env.properties");


    @Test
    public void CreateService() throws InterruptedException {
        Random rand = new Random();
        help = new helpers(driver);
        String serviceName = envProp.getProperty("FullName")+rand.nextInt(100);
        login(envProp.getProperty("Email"),envProp.getProperty("Password"));
        help.waitAndClick(plus);
        help.waitAndClick(createServReq);
        help.waitAndClick(selectComm);
        help.waitAndClick(TT_Residential);
        help.waitAndClick(selectUnit);
        help.waitAndClick(unit);
        help.waitAndClick(selectTenant);
        help.waitAndClick(anotherTenant);
        help.waitForVisibility(fullNameField);
        help.enterData(fullNameField,serviceName);
        help.enterData(emailField,envProp.getProperty("SignupMail")+rand.nextInt(1000)+"@test.com");
        help.androidScrollToElement(countryCodeField,"DOWN");
        help.enterData(countryCodeField,envProp.getProperty("CountryCode"));
        help.androidScrollToElement(phoneField,"DOWN");
        help.enterData(phoneField,envProp.getProperty("Phone"));
        help.click(nextCTA);
        Thread.sleep(3000);
        help.androidScrollToElement(homeApplicances,"DOWN");
        help.click(homeApplicances);
        help.waitAndClick(provider);
        help.waitAndClick(item);
        help.click(nextCTA);
        Thread.sleep(3000);
        help.waitAndClick(cameraIcon);
        help.waitAndClick(imageFromCamera);
        help.waitAndClick(capturePhoto);
        help.waitAndClick(okCTA);
        Thread.sleep(5000);
        help.waitForVisibility(capturedImage);
        Assert.assertTrue(driver.findElement(capturedImage).isDisplayed());
        help.click(nextCTA);
        Thread.sleep(5000);
        help.waitAndClick(micIcon);
        help.enterData(textField,"Hello world");
        help.click(nextCTA);
        help.waitAndClick(createServReqCTA);
        Thread.sleep(7000);
        help.waitForVisibility(By.xpath("//*[contains(@text,'"+serviceName+"')]"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@text,'"+serviceName+"')]")).isDisplayed());
    }
}

