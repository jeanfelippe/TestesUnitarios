package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TesteCampoTreinamento {
    private WebDriver driver;



    @Test
    public void testeTextField(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Jean\\drivers\\chromedriver_win32 (2)\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //navegador.manage().window().maximize();

        driver.get("file:///"+ System.getProperty("user.dir")+"C:\\Users\\Jean\\Downloads\\campo_treinamento\\componentes.html");



    }

}
