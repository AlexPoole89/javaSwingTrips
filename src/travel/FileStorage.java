/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author 1795647
 */
public class FileStorage {
     //Saves a list of people to a file 
    static void savePeopleToFile(ArrayList<Trip> list, File file) throws IOException {
        //FIXME: use try-with-resources here 
        PrintWriter out;
        out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        
        for (Trip t : list) {
            out.print(t.getName());
            out.print(t.getPassNo());
            out.print(t.getDestination());
            out.print(t.getDeparture());
            out.print(t.getReturnDate());
        }      
        out.close();
        }
      
}
