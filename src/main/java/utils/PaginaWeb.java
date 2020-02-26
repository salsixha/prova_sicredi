package utils;

import org.openqa.selenium.WebDriver;

public class PaginaWeb
{
    public WebDriver driver = DriverSelection.driver;

    public void acessarPagina(String enderecoWeb)
    {
        String url = driver.getCurrentUrl();

        if (url.contentEquals("data:,"))
        {
            driver.get(enderecoWeb);
        }

        else
        {
            //futuros tratamentos para testes conjuntos
        }
    }
}
