package Util;

import Entities.Produto;

import java.io.*;
import java.util.List;

public class ArquivoUtils {
    public static void salvarDados(List<Produto> produtos, String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(produtos);
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static List<Produto> carregarDados(String nomeArquivo) {
        List<Produto> produtos = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            produtos = (List<Produto>) inputStream.readObject();
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }
        return produtos;
    }
}

