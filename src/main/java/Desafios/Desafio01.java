package Desafios;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PaginaWeb;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Desafio01 extends PaginaWeb
{
    public void adicionarCliente(String versao, String[] parametrosCliente)
    {
        WebDriverWait wait = new WebDriverWait(driver,10);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement dropdownSelecionaVersao = driver.findElement(By.id("switch-version-select"));
        dropdownSelecionaVersao.click();
        Select selecionaOpcaoVersao = new Select(dropdownSelecionaVersao);
        List<WebElement> listaOpcoesVersao = selecionaOpcaoVersao.getOptions();
        for (int i = 0; i < listaOpcoesVersao.size(); i++)
        {
            if (listaOpcoesVersao.get(i).getText().contentEquals(versao))
            {
                wait.until(ExpectedConditions.elementToBeClickable(listaOpcoesVersao.get(i)));
                listaOpcoesVersao.get(i).click();
                break;
            }
        }

        WebElement botaoAdicionarCliente = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a"))));
        botaoAdicionarCliente.click();

        List<WebElement> espera = driver.findElements(By.id("nao_existe"));
        if (espera.size() == 0)
        {
            wait.until(ExpectedConditions.urlToBe("https://www.grocerycrud.com/demo/bootstrap_theme_v4/add"));
        }

        WebElement campoNome = driver.findElement((By.id("field-customerName")));
        campoNome.sendKeys(parametrosCliente[0]);
        wait.until(ExpectedConditions.attributeToBe(campoNome, "value", parametrosCliente[0]));

        WebElement campoUltimoNome = driver.findElement(By.id("field-contactLastName"));
        campoUltimoNome.sendKeys(parametrosCliente[1]);
        wait.until(ExpectedConditions.attributeToBe(campoUltimoNome, "value", parametrosCliente[1]));

        WebElement campoPrimeiroNome = driver.findElement(By.id("field-contactFirstName"));
        campoPrimeiroNome.sendKeys(parametrosCliente[2]);
        wait.until(ExpectedConditions.attributeToBe(campoPrimeiroNome, "value", parametrosCliente[2]));

        WebElement campoTelefone = driver.findElement(By.id("field-phone"));
        campoTelefone.sendKeys(parametrosCliente[3]);
        wait.until(ExpectedConditions.attributeToBe(campoTelefone, "value", parametrosCliente[3]));

        WebElement campoEnderecoLinha1 = driver.findElement(By.id("field-addressLine1"));
        campoEnderecoLinha1.sendKeys(parametrosCliente[4]);
        wait.until(ExpectedConditions.attributeToBe(campoEnderecoLinha1, "value",parametrosCliente[4]));

        WebElement campoEnderecoLinha2 = driver.findElement(By.id("field-addressLine2"));
        campoEnderecoLinha2.sendKeys(parametrosCliente[5]);
        wait.until(ExpectedConditions.attributeToBe(campoEnderecoLinha2, "value", parametrosCliente[5]));

        WebElement campoCidade = driver.findElement(By.id("field-city"));
        campoCidade.sendKeys(parametrosCliente[6]);
        wait.until(ExpectedConditions.attributeToBe(campoCidade, "value", parametrosCliente[6]));

        WebElement campoEstado = driver.findElement(By.id("field-state"));
        campoEstado.sendKeys(parametrosCliente[7]);
        wait.until(ExpectedConditions.attributeToBe(campoEstado, "value", parametrosCliente[7]));

        WebElement campoCodigoPostal = driver.findElement(By.id("field-postalCode"));
        campoCodigoPostal.sendKeys(parametrosCliente[8]);
        wait.until(ExpectedConditions.attributeToBe(campoCodigoPostal, "value", parametrosCliente[8]));

        WebElement campoPais = driver.findElement(By.id("field-country"));
        campoPais.sendKeys(parametrosCliente[9]);
        wait.until(ExpectedConditions.attributeToBe(campoPais, "value", parametrosCliente[9]));

        WebElement dropdownSelecionaEmpregador = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]"));
        dropdownSelecionaEmpregador.click();
        WebElement pesquisaEmpregador = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input"));
        pesquisaEmpregador.sendKeys(parametrosCliente[10]);
        pesquisaEmpregador.sendKeys(Keys.ENTER);

        WebElement campoLimiteCredito = driver.findElement(By.id("field-creditLimit"));
        campoLimiteCredito.sendKeys(parametrosCliente[11]);

        WebElement botaoSalvar = driver.findElement(By.id("form-button-save"));
        botaoSalvar.click();


        WebElement mensagemSucesso = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"report-success\"]/p"))));
        Assert.assertTrue(mensagemSucesso.getText().contains("Your data has been successfully stored into the database."));
    }
}
