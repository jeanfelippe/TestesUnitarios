package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Jean\\drivers\\chromedriver_win32 (2)\\chromedriver.exe");
        navegador= new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //navegador.manage().window().maximize();

        //Navegando para a pagina do julio
        navegador.get("http://www.juliodelima.com.br/taskit");
    }



    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {


        //Clicar no link que possui o texto Sign in
        navegador.findElement(By.linkText("Sign in")).click();


        //Identificando o formulario de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name login que esta dentro do formulari ode id signinbox o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");


        //Digitar no campo com name passowrd que esta dentro do form de id chamado signinbox o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com o texto SIGN IN
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a classe me
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui texto more data about you
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        //clicar no botao atraves do seu xpath //button[@data-target="addmoredate"]
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //identificar popup onde está o form id addmoredata
        WebElement popupAddMoreData= navegador.findElement(By.id("addmoredata"));

        //Na combo de opçao type escolher opc phone
        WebElement campoType=popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        //no campo de nome contact digitar "+5555"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5555");

        //Clicar no link de text SAVE que está no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //na mensagem de id toast container, validar que a mensagem do texto é "Your contact has been added"
        WebElement mensagemPop=navegador.findElement(By.id("toast-container"));
        String mensagem=mensagemPop.getText();
        assertEquals("Your contact has been added!",mensagem);




        /*
        //Validar que dentro do elemento com class "me" está o texto "Hi,Julio"
        WebElement me = navegador.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);
        */


    }


        //validacao
        //assertEquals(1,1);

        @After
        public void tearDown(){
            //fechar o navegador
            navegador.close();
        }









}
