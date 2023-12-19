package testing;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class SeleniumTest {
    public static void main(String args[]) throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://makemytrip.com/");
    Thread.sleep(2000);

        try {
            WebElement element = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
            driver.switchTo().frame(element);
            WebElement element1 = driver.findElement((By.xpath("//a[@class = 'close']")));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element1);
            driver.switchTo().defaultContent();
        }catch (Exception exc){
            System.out.println("Not Found");

        }
        Thread.sleep(3000);
        WebElement anchorElement = driver.findElement((By.xpath("//li[@class='menu_Holidays removeItemMargin']//span//a[@class='headerIcons makeFlex hrtlCenter column']")));
        anchorElement.click();
        Thread.sleep(2000);

        //From location
        WebElement inputElement = driver.findElement(By.xpath("//input[@id = 'fromCity']"));
        inputElement.click();

        WebElement liElement = driver.findElement(By.xpath("//li[@data-testid='Coimbatore']"));
        liElement.click();

        //to location
        WebElement inputElement3 = driver.findElement(By.xpath("//input[@id='toCity']"));
        inputElement3.click();

        WebElement inputElement4 = driver.findElement(By.xpath("//div[@class='dest-search-container']/input"));
        inputElement4.sendKeys("Andaman");
        Thread.sleep(2000);
        WebElement inputElement5 = driver.findElement(By.xpath("//div[@class='dest-city-container']"));
        inputElement5.click();


        //date picker

        while (!driver.findElement(By.xpath("//div[@role ='heading']/div")).getText().equals("February 2024")){
            Thread.sleep(2000);

            driver.findElement(By.xpath("//span[@class ='DayPicker-NavButton DayPicker-NavButton--next']")).click();
        }

        List<WebElement> inputElement6= driver.findElements(By.xpath("\n" +
                "//div[@class='DayPicker-Body']/div[@class='DayPicker-Week']/div[@class='DayPicker-Day']"));


        for(WebElement e:inputElement6){
//            System.out.println("e" + e.getText());
            if(e.getText().equals("20")){
                e.click();
                break;
            }

        }

        //apply button


        WebElement inputElement8 = driver.findElement(By.xpath("//div[@data-testid = 'adult-decrement-counter']"));
        inputElement8.click();
        Thread.sleep(2000);
        WebElement inputElement9 = driver.findElement(By.xpath("//div[@data-testid = 'child-increment-counter']"));
        inputElement9.click();
        Thread.sleep(2000);

        WebElement inputElement10 = driver.findElement(By.xpath("//ul[@class='font12 darkText childAge-selector-scale']/li[text()='2']"));
        inputElement10.click();
        Thread.sleep(2000);

        WebElement inputElement7 = driver.findElement(By.xpath("//button[@class = 'applyBtn']"));

        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", inputElement7);


        WebElement inputElement11 = driver.findElement(By.xpath("//button[@class='action']"));
        executor1.executeScript("arguments[0].click();", inputElement11);

        Thread.sleep(2000);

        WebElement inputElement12 = driver.findElement(By.xpath("//button[@id='search_button']"));
        executor1.executeScript("arguments[0].click();", inputElement12);

        driver.close();


    }
}
