package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FacebookTestingApp {

    public static final String FACEBOOK_CREATE_ACCOUNT = "//div/a[contains(@class,\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\")]";
    public static final String FACEBOOK_SELECT_DAY = "//div[contains(@class, \"_58mq _5dbb\")]/div[2]/span/span/select[1]";
    public static final String FACEBOOK_SELECT_MONTH = "//div[contains(@class, \"_58mq _5dbb\")]/div[2]/span/span/select[2]";
    public static final String FACEBOOK_SELECT_YEAR = "//div[contains(@class, \"_58mq _5dbb\")]/div[2]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//div/button[contains(@class,\"_42ft _4jy0 _9xo6 _4jy3 _4jy1 selected _51sy\")]")).click();

        driver.findElement(By.xpath(FACEBOOK_CREATE_ACCOUNT)).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement selectDay = driver.findElement(By.xpath(FACEBOOK_SELECT_DAY));
        Select selectDaySelector = new Select(selectDay);
        selectDaySelector.selectByIndex(0);
        WebElement selectMonth = driver.findElement(By.xpath(FACEBOOK_SELECT_MONTH));
        Select selectMonthSelector = new Select(selectMonth);
        selectMonthSelector.selectByIndex(0);
        WebElement selectYear = driver.findElement(By.xpath(FACEBOOK_SELECT_YEAR));
        Select selectYearSelector = new Select(selectYear);
        selectYearSelector.selectByIndex(0);


    }
}
