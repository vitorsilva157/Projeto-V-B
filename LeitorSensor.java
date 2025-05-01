package ProjetoSensorJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorSensor {
    public static void main(String[] args) {
        String caminhoArquivo = "C:\\Users\\vitor.silva\\ProjetoJavaSensor\\ProjetoSensorJava\\dados_sensor.csv";
        String linha;

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            // Lê o cabeçalho
            linha = br.readLine(); // ignora "Temperatura,Umidade,Luminosidade,Ambiente"

            System.out.println("Leitura dos dados do sensor:\n");

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                // Pegando os valores do CSV
                double temperatura = Double.parseDouble(dados[0]);
                double umidade = Double.parseDouble(dados[1]);
                int luminosidade = Integer.parseInt(dados[2]);
                String ambiente = dados[3];

                // Exibindo no console
                System.out.println("Temperatura: " + temperatura + "°C");
                System.out.println("Umidade: " + umidade + "%");
                System.out.println("Luminosidade: " + luminosidade + " lux");
                System.out.println("Ambiente: " + ambiente);
                System.out.println("----------------------------");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}