package testing;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Navigation {
    public static void NavigationFlow(ChromeDriver driver,String url)throws InterruptedException{

        driver.get(url);
        Thread.sleep(2000);

        WebElement Buses = driver.findElement(By.xpath("//nav[@class = 'nav-list']//span//a[@data='2']"));
        Buses.click();

        WebElement frominput = driver.findElement(By.xpath("//div[@id='search-from']//input[@placeholder='From Station']"));
        frominput.sendKeys("Coimbatore");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[@class='collection-item auto-complete-list-item ']//div[@class='station-body col']//div//div")).click();

        WebElement toinput = driver.findElement(By.xpath("//div[@id='search-to']//input[@placeholder='To Station']"));
        toinput.sendKeys("Bangalore");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='container auto-complete-drop-down ']//ul//li[@data-id='Bangalore']")).click();

        WebElement dateinput = driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']"));
        dateinput.click();
        Thread.sleep(2000);

        WebElement monthChangeElement = driver.findElement(By.xpath("//span[@class='calender-month-change']"));
        monthChangeElement.click();

        WebElement month = driver.findElement(By.xpath("//div[@class='container calendar  ']//div//div[@class=' col']//span"));
        String text = month.getText();


        while (!driver.findElement(By.xpath("//div[@class='container calendar  ']//div//div[@class=' col']//span")).getText().equals("February")){
            Thread.sleep(2000);
            monthChangeElement.click();
        }

        Thread.sleep(2000);
        WebElement dates = driver.findElement(By.xpath("//div[@class='container date ']//span[@data-date='1']"));
        dates.click();

        WebElement searchbtn = driver.findElement(By.xpath("//a[@class='btn btn-search filled primary lg inactive button']"));
        searchbtn.click();

        //a[@class='btn  outlined tertiary sm inactive button']
        Thread.sleep(2000);
        WebElement ACbtn = driver.findElement(By.xpath("//a[@class='btn  outlined tertiary sm inactive button']"));
        ACbtn.click();

        //div[@class='container filter-list ']//a//span[text()='Sleeper']
        WebElement Sleeperbtn = driver.findElement(By.xpath("//div[@class='container filter-list ']//a//span[text()='Sleeper']"));
        Sleeperbtn.click();

        //div[@class='container departureFilterList ']//a//span[text()='After 11 PM']
        Thread.sleep(2000);
        WebElement depaturebtn = driver.findElement(By.xpath("//div[@class='container departureFilterList ']//a//span[text()='After 11 PM']"));
        depaturebtn.click();

        //button[@class='btn bus-info-btn filled primary sm inactive button']
        WebElement setseatss = driver.findElement(By.xpath(" //button[@class='btn bus-info-btn filled primary sm inactive button']"));
        setseatss.click();

    }


}
