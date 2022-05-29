package Sistemas;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class criandoTestes {
    private WebDriver webDriver;

    @BeforeAll
    public void setupAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_win32/chromedriver.exe");
    }

    @BeforeEach

    public void setup() {
        this.webDriver = new ChromeDriver();
        this.webDriver.manage().window().maximize();
    }

    @AfterEach
    public void fechar() {
        webDriver.close();
    }

    @Test
    public void abrirPaginaGETest() {
        webDriver.get("https://www.spotify.com/br/");
        Assertions.assertEquals("https://www.spotify.com/br/", webDriver.getCurrentUrl());

    }

    @Test
    public void realizarLoginNoSpotifycomDadosInvalidos() {
        webDriver.get("https://accounts.spotify.com/pt-PT/login/?continue=https%3A//open.spotify.com/__noul__%3Fl2l%3D1%26nd%3D1&_locale=pt-BR");
        WebElement emailGE = webDriver.findElement(By.id("login-username"));
        emailGE.sendKeys("joao.silva@gmail.com");
        WebElement senhaGE = webDriver.findElement(By.id("login-password"));
        senhaGE.sendKeys("12345");
        WebElement enviar = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[3]/div[2]/button/div[1]/p"));
        enviar.click();
        Assertions.assertNotEquals("https://open.spotify.com/", webDriver.getCurrentUrl());

    }

    @Test
    public void tentativaLoginViaFacebookNoSpotifyTest() {
        webDriver.get("https://accounts.spotify.com/pt-PT/login/?continue=https%3A//open.spotify.com/__noul__%3Fl2l%3D1%26nd%3D1&_locale=pt-BR");
        WebElement botaoCadastre_se = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/button[3]/p"));
        botaoCadastre_se.click();
        Assertions.assertNotEquals("https://accounts.google.com/o/oauth2/v2/auth/oauthchooseaccount?response_type=code&access_type=offline&client_id=1046568431490-" +
                "ij1gi5shcp2gtorls09frkc56d4mjbe2.apps.googleusercontent.com&state=AQAblZ%2FQbTUw9iHYDWSmMe34SLkEUoGpcJAmMJZew0kxUSnu17XkpeMIdt52bOAJLGB3%2FznghVcM8GvFpjbl2lx" +
                "FnF9oF1QZXgIkl0Dkoso1bFI99pvcCR7RA2AZ2DH5MPXh6qseNg336EKDNMrFTBTExhB9FRw%2FBxzA6DDcYBa37AiBtJhPN3xaM%2BhPb2C27YyRNPmJOJcx6dfkA0Fanv7qs9JllJLHyBPquNTRpHHMCu" +
                "Fu&scope=profile%20email%20openid&redirect_" +
                "uri=https%3A%2F%2Faccounts.spotify.com%2Flogin%2Fgoogle%2Fredirect&flowName=GeneralOAuthFlow", webDriver.getCurrentUrl());

    }

    @Test
    public void clicarNoBotaoGEeRedirecionarParaOinicio() {
        webDriver.get("https://www.spotify.com/br/");
        WebElement botaoGE = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/div[1]/a/span/svg/g/path"));
        botaoGE.click();
        Assertions.assertEquals("https://www.spotify.com/br/", webDriver.getCurrentUrl());
        Assertions.assertFalse(false);


        ////*[@id="menu-1-volei"]/a/span[1]
    }
    @Test
    public void verificaBotaoHomeTest(){
        webDriver.get("https://www.spotify.com/br/");
        Actions actions = new Actions(webDriver);
        WebElement botaoHome = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div/nav/ul/li[1]/a"));
        actions.moveToElement(botaoHome).build().perform();

    }
}
