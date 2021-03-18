package iut.umontpellier.fr;

import java.util.ArrayList;

public class AppJeuxPuzzle {
    public static void main(String[] args) {
        ArrayList<Integer> t1 = new ArrayList<>();
        for (int i = 1 ; i < 4; i++) {
            t1.add(i);
        }
        ArrayList<Integer> t2 = new ArrayList<>();
        ArrayList<Integer> t3 = new ArrayList<>();
        Hanoi testh = new Hanoi(t1,t2,t3,3);
        Contexte testc = new Contexte(testh);
        System.out.println(testc.getSolution());

    }
}
