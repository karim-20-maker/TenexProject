import Utiles.helpers;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.Random;

import static Utiles.PropertiesLoader.readPropertyFile;
public class SearchOnService extends BaseTest{
    helpers help;
    Properties envProp = readPropertyFile("Config/env.properties");

    @Test
    public void AddComments() throws InterruptedException {
        Random rand = new Random();
        help = new helpers(driver);
        String comment = "Automation test"+rand.nextInt(1000);
        help.waitAndClick(filterIcon);
        help.waitAndClick(activeTap);
        help.waitAndClick(acceptedStatus);
        help.androidScrollToElement(homeApplicancesServiceType,"DOWN");
        help.click(homeApplicancesServiceType);
        help.click(applyFiltersCTA);
        help.waitForVisibility(searchBar);
        help.search(searchBar,envProp.getProperty("ServiceName"));
        help.waitAndClick(By.xpath("(//*[@text='"+envProp.getProperty("ServiceName")+"'])[2]"));
        help.androidScrollToElementFromBottom(replyTextArea,"DOWN");
        help.enterData(replyTextArea,comment);
        help.androidScrollToElementFromBottom(sendIcon,"DOWN");
        help.click(sendIcon);
        help.waitAndClick(sendToClient);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@text,'"+comment+"')]")).isDisplayed());
        help.androidScrollToElementFromBottom(addStandardRes,"DOWN");
        help.click(addStandardRes);
        help.waitAndClick(firstResponse);
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        Thread.sleep(3000);
        help.androidScrollToElementFromBottom(firstResponse,"UP");
        help.click(sendIcon);
        help.waitAndClick(sendToClient);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(firstResponse).isDisplayed());
        help.androidScrollToElementFromBottom(internalTeam,"UP");
        help.click(internalTeam);
        help.androidScrollToElementFromBottom(replyTextArea,"DOWN");
        help.enterData(replyTextArea,comment);
        help.androidScrollToElementFromBottom(sendIcon,"DOWN");
        help.click(sendIcon);
        help.waitAndClick(sendToInternalTeam);
        Thread.sleep(2000);
        help.androidScrollToElementFromBottom(By.xpath("//*[contains(@text,'"+comment+"')]"),"DOWN");
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@text,'"+comment+"')]")).isDisplayed());
        help.click(acceptedStatusBadge);
        help.androidScrollToElement(approvedStatus,"DOWN");
        help.click(approvedStatus);
        help.click(saveCTA);
        Thread.sleep(5000);
        help.waitForVisibility(approvedStatusBadge);
        Assert.assertTrue(driver.findElement(approvedStatusBadge).isDisplayed());




    }

}
