package testing;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
public class TicketBooking {
    public static void main(String args[]) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ixigo.com/");
        Thread.sleep(2000);

        WebElement Buses = driver.findElement(By.xpath("//nav[@class = 'nav-list']//span//a[@data='2']"));
        Buses.click();

        WebElement frominput = driver.findElement(By.xpath("//div[@id='search-from']//input[@placeholder='From Station']"));
        frominput.sendKeys("Chennai");
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
        WebElement setseat = driver.findElement(By.xpath(" //button[@class='btn bus-info-btn filled primary sm inactive button']"));
        setseat.click();

        //table[@id='seat-layout-details']//td//div//button//span[text()='U8']
        Thread.sleep(2000);

        int[][] seatArray = {
                {8, 10, 12, 14, 16},
                {7, 9, 11, 13, 15},
                {1, 2, 3, 4, 5}
        };

        System.out.println("Selected Seats : ");
        for (int row = 0; row < seatArray.length; row++) {
            for (int col = 0; col < seatArray[row].length; col ++) {

                if(col%2==0) {
                    int seatNumber = seatArray[row][col];

                    String seat = "//table[@id='seat-layout-details']//td//div//button//span[text()='U" + seatNumber + "']";
                    WebElement seatButton = driver.findElement(By.xpath(seat));
                    System.out.println(seatNumber);
                    seatButton.click();
                }

            }
        }

        //input[@placeholder='Search Boarding Point']
        WebElement bordings = driver.findElement(By.xpath("//div[@id='place-container']//div//label//div"));
        bordings.click();
        Thread.sleep(1000);


    }


}
