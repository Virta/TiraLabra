/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IgnoreThisMoFo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.concurrent.FutureTask;

/**
 *
 * @author frojala
 */
public class huh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        HashMap<Integer, Byte> mappi = new HashMap<>();
        HashMap<Byte, Integer> freq = new HashMap<>();
        
        Path path = Paths.get("joku");
        byte[] data = Files.readAllBytes(path);
        int numero = 0;
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            
            if (!mappi.containsValue(b)){
                mappi.put(numero, b);
                freq.put(b, 1);
                numero++;
            } else {
                int freqnum = freq.remove(b);
                freqnum++;
                freq.put(b, freqnum);
            }
            
        }
        
        for (int i : mappi.keySet()) {
            System.out.println(i+": "+mappi.get(i).toString()+": "+freq.get(mappi.get(i)));
        }
        
        
        Files.createFile(Paths.get("uusi"));
        Path uusipath = Paths.get("uusi");
        Files.write(uusipath, data, StandardOpenOption.CREATE);
        
    }
}