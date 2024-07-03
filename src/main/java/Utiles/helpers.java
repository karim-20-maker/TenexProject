package Utiles;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class helpers {
    AndroidDriver driver;
    public helpers(AndroidDriver driver){
        this.driver = driver;
    }

    public void waitForVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void enterData(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    public void search(By by,String text){

        driver.findElement(by).click();
        driver.findElement(by).sendKeys(text);
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public void waitAndClick(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        driver.findElement(by).click();
    }

    public void androidScrollToElement(By by, String direction) {
        int count = 0;
        boolean isDisplayed = false;

        while (!isDisplayed && count++ < 100) {
            try {
                isDisplayed = driver.findElement(by).isDisplayed();
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScroll(direction);
            }
        }
    }

    public void androidScrollToElementFromBottom(By by, String direction) {
        int count = 0;
        boolean isDisplayed = false;

        while (!isDisplayed && count++ < 100) {
            try {
                isDisplayed = driver.findElement(by).isDisplayed();
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScrollFromBottom(direction);
            }
        }
    }

    private void touchScroll(String scrollDirection) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("size = " + dimension);
        Point midPoint = new Point((int) (dimension.width * 0.4), (int) (dimension.height * 0.4));
        System.out.println("midPoint = "+ midPoint);
        int bottom = midPoint.y + (int) (midPoint.y * .5);
        int top = midPoint.y - (int) (midPoint.y * .2);


        switch (scrollDirection.toUpperCase()) {
            case "UP":
                swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
                break;
            case "DOWN":
                swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
                break;
            default:
                throw new IllegalArgumentException(
                        "Incorrect scroll direction given: Direction must be [up], or [down]");
        }
    }

    private void touchScrollFromBottom(String scrollDirection) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("size = " + dimension);
        Point midPoint = new Point((int) (dimension.width * 0.5), (int) (dimension.height * 0.75));
        System.out.println("midPoint = "+ midPoint);
        int bottom = midPoint.y + (int) (midPoint.y * .2);
        int top = midPoint.y;
        System.out.println(scrollDirection);


        switch (scrollDirection.toUpperCase()) {
            case "UP":
                swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
                break;
            case "DOWN":
                swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
                break;
            default:
                throw new IllegalArgumentException(
                        "Incorrect scroll direction given: Direction must be [up], or [down]");
        }
    }

    public void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(swipe));
    }
}
