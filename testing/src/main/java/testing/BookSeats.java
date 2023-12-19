package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BookSeats {
    public static void SeatSelection(ChromeDriver driver)throws InterruptedException {

        Thread.sleep(2000);

        List<WebElement> allSeats=driver.findElements(By.xpath("//button[@class='seat sleeper']/span"));
        List<WebElement> seats=driver.findElements(By.xpath("//button[@class='seat sleeper']//*[name()='svg']//*[name()='rect'][1]"));
        System.out.println("Available Seats");
        System.out.println("Upper Deck");

        WebElement selectedUpperDeckSeat = null;
        for (int i = 0; i < 5; i++) {
            WebElement seat = seats.get(i);

            if ("white".equals(seat.getAttribute("fill")) && i + 1 < seats.size() && "white".equals(seats.get(i + 1).getAttribute("fill"))) {
                selectedUpperDeckSeat = allSeats.get(i);
                System.out.println(selectedUpperDeckSeat.getText());
                break;
            }
        }

        System.out.println("Lower Deck");
        WebElement selectedLowerDeckSeat = null;

        for (int i = 16; i < 20; i++) {
            WebElement seat1 = seats.get(i);
            WebElement seat2 = seats.get(i + 1);

            if ("white".equals(seat1.getAttribute("fill")) && "white".equals(seat2.getAttribute("fill"))) {
                selectedLowerDeckSeat = allSeats.get(i);
                System.out.println(selectedLowerDeckSeat.getText());
                break;
            }
        }

    }
}
