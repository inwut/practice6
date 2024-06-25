package com.naukma;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SeleniumTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testElementPresence() {
        driver.get("https://www.baeldung.com/");
        WebElement element = driver.findElement(By.id("menu-item-40489"));
        Assertions.assertNotNull(element);
    }

    @Test
    public void testElementClick() throws InterruptedException {
        driver.get("https://www.baeldung.com/");
        WebElement element = driver.findElement(By.id("menu-item-40489"));
        element.click();
        Thread.sleep(300);
        WebElement search = driver.findElement(By.id("search"));
        Assertions.assertNotNull(search);
    }

    @Test
    public void testWriteToElementAndSearch() throws InterruptedException {
        driver.get("https://www.baeldung.com/");
        WebElement element = driver.findElement(By.id("menu-item-40489"));
        element.click();
        Thread.sleep(1000);
        WebElement search = driver.findElement(By.id("search"));
        search.click();
        Thread.sleep(300);
        search.sendKeys("cucumber");
        WebElement button = driver.findElement(By.className("btn-search"));
        button.click();
        Thread.sleep(300);
        List<WebElement> elements = driver.findElements(By.tagName("article"));
        assertFalse(elements.isEmpty());
    }
}