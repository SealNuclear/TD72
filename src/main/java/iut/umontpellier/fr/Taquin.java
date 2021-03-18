package iut.umontpellier.fr;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Taquin implements JeuPuzzle {
    private int[][] tableau;

    public Taquin(int[][] tableau) {
        this.tableau = tableau;
    }

    public Taquin(Taquin t) {
        int[][] tab = new int[t.tableau.length][t.tableau[t.tableau.length - 1].length];
        for (int i = 0; i < t.tableau.length; i++) {
            for (int j = 0; j < t.tableau[i].length; j++) {
                tab[i][j] = t.tableau[i][j];
            }
        }
        this.tableau = tab;
    }

    public boolean estGagnant() {
        int prec;
        int actu;
        prec = 0;
        actu = tableau[0][0];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                prec = actu;
                actu = tableau[i][j];
                if ((actu == 0) && (i != tableau.length - 1 | j != tableau[i].length - 1)) {
                    return false;
                } else if ((actu < prec) && (actu != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<JeuPuzzle> genererFils() {
        int trouy = trouverTrou()[0];
        int troux = trouverTrou()[1];
        ArrayList taquin = new ArrayList<Taquin>();
        int y = tableau.length;
        int x = tableau[tableau.length - 1].length;

        if (troux > 0) {
            Taquin taquin1 = new Taquin(this);
            taquin1.tableau[trouy][troux] = this.tableau[trouy][troux - 1];
            taquin1.tableau[trouy][troux - 1] = 0;
            taquin.add(taquin1);
        }
        if (troux < x - 1) {
            Taquin taquin2 = new Taquin(this);
            taquin2.tableau[trouy][troux] = this.tableau[trouy][troux + 1];
            taquin2.tableau[trouy][troux + 1] = 0;
            taquin.add(taquin2);
        }
        if (trouy > 0) {
            Taquin taquin3 = new Taquin(this);
            taquin3.tableau[trouy][troux] = this.tableau[trouy - 1][troux];
            taquin3.tableau[trouy - 1][troux] = 0;
            taquin.add(taquin3);
        }
        if (trouy < y - 1) {
            Taquin taquin4 = new Taquin(this);
            taquin4.tableau[trouy][troux] = this.tableau[trouy + 1][troux];
            taquin4.tableau[trouy + 1][troux] = 0;
            taquin.add(taquin4);
        }
        return taquin;
    }

    public int[] trouverTrou() {
        int val;
        int[] tab = new int[2];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                val = tableau[i][j];
                if (val == 0) {
                    tab[0] = i;
                    tab[1] = j;
                }
            }
        }
        return tab;
    }

    @Override
    public String toString() {
        String retour;
        retour = "";
        for (int a = 0; a < tableau[tableau.length - 1].length + 2; a++) {
            retour = retour + "-";
        }
        retour = retour + "\n";
        for (int i = 0; i < tableau.length; i++) {
            retour = retour + "|";
            for (int j = 0; j < tableau[i].length; j++) {
                retour = retour + (tableau[i][j]);
            }
            retour = retour + "|" + "\n";
        }
        for (int a = 0; a < tableau[tableau.length - 1].length + 2; a++) {
            retour = retour + "-";
        }
        retour = retour + "\n";
        return "Taquin : " + "\n" + retour;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taquin)) return false;
        Taquin taquin = (Taquin) o;
        if ((tableau.length != taquin.tableau.length) | tableau[tableau.length - 1].length != taquin.tableau[taquin.tableau.length - 1].length) {
            return false;
        }
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] != taquin.tableau[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tableau);
    }
}
