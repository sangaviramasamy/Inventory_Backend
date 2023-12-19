package testing;

import org.openqa.selenium.chrome.ChromeDriver;
public class Main
{
    public static void main(String args[]) throws InterruptedException{
        ChromeDriver driver = new ChromeDriver();
        String url = "https://www.ixigo.com/";

        Navigation.NavigationFlow(driver,url);
        Thread.sleep(2000);

        BookSeats.SeatSelection(driver);
        driver.quit();

    }
}
