
package projetsemestriel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CalculModel {
    public ArrayList<String> nomsClients;
    private ArrayList<Integer> transactions;
    private ArrayList<Integer> mois;
    private ArrayList<Integer> cins;
    
    public CalculModel () {
    nomsClients = new ArrayList<>();
    cins = new ArrayList<>();
    mois = new ArrayList<>();
    transactions = new ArrayList<>();
    }
    
    public void Lecture(String cheminFichier) throws FileNotFoundException,InputMismatchException {
     
            Scanner sc = new Scanner(new File(cheminFichier));
            while(sc.hasNextLine() ) {
                String L = sc.nextLine();
                Scanner sc2 = new Scanner(L);
                while(sc2.hasNext()) {
                    nomsClients.add(sc2.next());
                    cins.add(sc2.nextInt());
                    mois.add(sc2.nextInt());
                    transactions.add(sc2.nextInt());
                }
            }
       
    }
    
    public int ChiffreTotal() {
        int chiffre = 0;
        for (int transaction : transactions) chiffre+=transaction;
        return chiffre;
    }
    
    public Map<Integer,Integer> topclients () {
        ArrayList<Integer> c = new ArrayList<>();
        ArrayList<Integer> toptrans = new ArrayList<>();
        Map<Integer,Integer> topc = new HashMap<>();
       
        int trans;
        int index;
        for (int cin : cins) {
            if (!c.contains(cin)) c.add(cin);
        }
        for (int cin : c ) {
            trans = 0;
            index = 0;
            for (int cin2 : cins) {
                if (cin2 == cin) trans += transactions.get(index);
                index++;
            }
            
            toptrans.add(trans);
        }
        for (int cin : c) {
            topc.put(cin, toptrans.get(c.indexOf(cin)));
        }
        topc = MapUtil.sortByValue(topc);
        
        return topc;
    }
    
    public ArrayList<String> nomTopClients() {
        ArrayList<String> noms = new ArrayList<>();
        Map<Integer,Integer> top = this.topclients();
        for (int cin : top.keySet()) {
            noms.add(nomsClients.get(cins.indexOf(cin)));
        }
        return noms;
    }
}
