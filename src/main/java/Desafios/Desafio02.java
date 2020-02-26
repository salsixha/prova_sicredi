package Desafios;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PaginaWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Desafio02 extends PaginaWeb
{
    Desafio01 desafio01 = new Desafio01();

    public void deletarRegistro(String versao, String[] parametrosCliente)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);

        desafio01.adicionarCliente(versao, parametrosCliente);

        WebElement linkVoltarLista = driver.findElement(By.xpath("//*[@id=\"report-success\"]/p/a[2]"));
        linkVoltarLista.click();

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement botaoLupa = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("search-button"))));

        List<WebElement> espera = driver.findElements(By.id("nao_existe"));
        if (espera.size() > 0);

        botaoLupa.click();

        WebElement campoPesquisa = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("search-input-big"))));
        campoPesquisa.sendKeys(parametrosCliente[0]);

        WebElement titulo = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/div[1]"))));
        Actions actions = new Actions(driver);
        actions.moveToElement(titulo).click().build().perform();

        WebElement checkboxAcaoGeral = driver.findElement(By.className("select-all-none"));
        checkboxAcaoGeral.click();

        List<WebElement> espera2 = driver.findElements(By.id("nao_existe2"));
        if (espera2.size() > 0);

        WebElement botaoDeletar = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a"));
        botaoDeletar.click();

        WebElement mensagemAlerta = driver.findElement(By.className("alert-delete-multiple-one"));
        Assert.assertTrue(mensagemAlerta.getText().trim().contains("Are you sure that you want to delete this 1 item?"));

        WebElement botaoDeletarAlert = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]"));
        botaoDeletarAlert.click();

        WebElement mensagemConfirmacaoDelete = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[3]/span[3]/p"))));
        Assert.assertTrue(mensagemConfirmacaoDelete.isDisplayed());
    }
}
