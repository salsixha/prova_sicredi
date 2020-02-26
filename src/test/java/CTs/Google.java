package CTs;

import Desafios.Desafio01;
import Desafios.Desafio02;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import utils.Arquivo;
import utils.DriverSelection;
import utils.Retry;

import java.io.FileNotFoundException;
import java.util.List;

public class Google
{
    @BeforeClass
    public static void iniciarTeste()
    {
        DriverSelection.setUpChrome();
        System.out.println("Iniciando novo teste");
    }

    @Rule
    public Retry retryRule = new Retry(1);

    @Test
    public void RodarDesafio01() throws FileNotFoundException
    {
        Desafio01 paginaWeb = new Desafio01();
        List<String[]> registrosClientes = Arquivo.LerArquivo("registrosClientes.csv");
        for(int i = 0; i < registrosClientes.size(); i++)
        {
            paginaWeb.acessarPagina("https://www.grocerycrud.com/demo/bootstrap_theme");
            paginaWeb.adicionarCliente("Bootstrap V4 Theme", registrosClientes.get(i));
        }
    }

    @Test
    public void RodarDesafio02() throws FileNotFoundException
    {
        Desafio02 paginaWeb = new Desafio02();
        List<String[]> registrosClientes = Arquivo.LerArquivo("registrosClientes.csv");
        for(int i = 0; i < registrosClientes.size(); i++)
        {
            paginaWeb.acessarPagina("https://www.grocerycrud.com/demo/bootstrap_theme");
            paginaWeb.deletarRegistro("Bootstrap V4 Theme", registrosClientes.get(i));
        }
    }

    @After
    public void encerrar()
    {
        DriverSelection.driver.close();
        DriverSelection.driver = null;
    }
}
