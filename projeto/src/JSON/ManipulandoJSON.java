package JSON;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DTO.Numeros;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import DTO.Numeros;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author eduardadelima
 */
public class ManipulandoJSON {

    public List<Numeros> exporta(List<Numeros> numeros) throws IOException {
        List<Numeros> lista = new ArrayList<Numeros>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("/src/Numeross.json");
        writer.write(gson.toJson(numeros));
        writer.close();
        return null;
    }

    public List<Numeros> importa() {

        List<Numeros> lista = new ArrayList<Numeros>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Doc/Numeros.json"));
            Type listType = new TypeToken<ArrayList<Numeros>>() {
            }.getType();
            lista = new Gson().fromJson(bufferedReader, listType);
            return lista;

        } catch (java.io.FileNotFoundException e) {
            return lista;
        }
    }
}