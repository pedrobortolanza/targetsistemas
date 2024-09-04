import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exer03 {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File("faturamento.json"));

            List<Double> faturamentos = new ArrayList<>();

            Iterator<JsonNode> elements = rootNode.elements();
            while (elements.hasNext()) {
                JsonNode node = elements.next();
                double valor = node.get("valor").asDouble();
                if (valor > 0) {
                    faturamentos.add(valor);
                }
            }

            double menorFaturamento = faturamentos.stream().min(Double::compare).orElse(0.0);
            double maiorFaturamento = faturamentos.stream().max(Double::compare).orElse(0.0);

            double somaFaturamento = faturamentos.stream().mapToDouble(Double::doubleValue).sum();
            double mediaMensal = somaFaturamento / faturamentos.size();

            long diasAcimaDaMedia = faturamentos.stream().filter(valor -> valor > mediaMensal).count();

            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}