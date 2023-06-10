package Util;
import Entities.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class ArquivoUtils {

    public static void salvarDados(List<Produto> produtos, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Produto produto : produtos) {
                String linha = produto.getDescricao() + ";" + produto.getPreco() + ";" + produto.getCategoria();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso no arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
    public static List<Produto> carregarDados(String nomeArquivo) {
        List<Produto> produtos = new ArrayList<>();



        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] atributos = linha.split(";");
                if (atributos.length == 4) {
                    String categoria = atributos[0].trim();
                    String nome = atributos[1].trim();
                    double preco = Double.parseDouble(atributos[2].trim());
                    String descricao = atributos[3].trim();
                    Produto produto = new Produto(categoria, nome, preco, descricao);
                    produtos.add(produto);
                } else {
                    System.err.println("Formato inválido para os dados: " + linha);
                }
            }
            System.out.println("Dados carregados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }

        return produtos;
    }



}

