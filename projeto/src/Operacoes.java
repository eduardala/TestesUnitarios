
import DTO.Numeros;
import DTO.Numeros;
import JSON.ManipulandoJSON;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eduardadelima
 */
public class Operacoes {
    
    public double media(List<Numeros> numeros) {
        double media = 0;
        for(int i = 0; i < numeros.size(); i++) {
            media += numeros.get(i).getN1();
        }
        media = media/numeros.size();
        return media;
    }
    
    public double moda(List<Numeros> numeros) {
        int vezes = 0;
        double moda = 0;
        int compara = 0;
        for(int i = 0; i < numeros.size(); i++) {
            vezes = 0;
            for(int j = i + 1; j < numeros.size(); j++) {
                if(numeros.get(i).getN1() == numeros.get(j).getN1()) {
                    vezes++;
                }
            }
            if(vezes > compara) {
                moda = numeros.get(i).getN1();
                compara = vezes;
            }
        }
        return moda;
    }
  
    public double mediana (List<Numeros> numeros) {
        numeros.sort(Comparator.comparingDouble(Numeros::getN1));
        int resultado = numeros.size();
        int meio;
        double mediana;

        meio = resultado/2; 

        if(resultado % 2 != 0){
            mediana = numeros.get(meio).getN1();
        }else {
            mediana = (numeros.get(meio-1).getN1() + numeros.get(meio).getN1())/2;
        }

        return mediana;
    }
    
    public double variancia(List<Numeros> listaNumeros) {

        double mediaAritmetica = media(listaNumeros);
        int resultado = listaNumeros.size();
        double variancia = 0;

        for (int i = 0; i < resultado; i++) {
            double result = listaNumeros.get(i).getN1() - mediaAritmetica;
            variancia += Math.pow(result, 2);
        }
        int n = resultado - 1;

        return variancia/n;
    }
    
    public double desvioPadrao(List<Numeros> numeros) {
        NumberFormat nf = new DecimalFormat("0.##");
        String formatado = nf.format(Math.sqrt(variancia(numeros)));
        formatado = formatado.replaceAll(",",".");
        double desvio = Double.parseDouble(formatado);
        return desvio;
    }
}