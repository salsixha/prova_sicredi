package utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivo
{
    public static List<String[]> LerArquivo(String nomeArquivo) throws FileNotFoundException
    {
        List<String[]> resultado = new ArrayList<>();
        File arquivo = new File("src\\main\\resources\\Arquivos\\" + nomeArquivo);
        Scanner leitor = new Scanner(arquivo);
        while (leitor.hasNextLine()){
            resultado.add(leitor.nextLine().split(";"));
        }
        return resultado;
    }
}
