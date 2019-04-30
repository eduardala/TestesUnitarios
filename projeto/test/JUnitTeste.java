/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import JSON.ManipulandoJSON;
import junit.framework.TestCase;

/**
 *
 * @author eduardadelima
 */
public class JUnitTeste extends TestCase {
    
    Operacoes op = new Operacoes();
    ManipulandoJSON json = new ManipulandoJSON();
    
    public void testeMedia() {
        assertEquals(24.2, op.media(json.importa())); 
    }
    
    public void testeModa() {
        assertEquals(15.0, op.moda(json.importa()));
    }
    
    public void testeMediana() {
        assertEquals(21.0, op.mediana(json.importa()));
    }
    
    public void testeVariancia() {
        assertEquals(12.38, op.desvioPadrao(json.importa()));
    }

}
