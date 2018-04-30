
package projetsemestriel;

import java.io.FileNotFoundException;

public class ProjetSemestriel {

  
    public static void mainz(String[] args) {
        CalculModel calc = new CalculModel();
        
        try {
            calc.Lecture("C:\\Users\\AlaaEddine\\Desktop\\new.txt");
        } catch (FileNotFoundException e) {}
        System.out.println(calc.ChiffreTotal());
        System.out.println(calc.topclients());
    }
    
}
