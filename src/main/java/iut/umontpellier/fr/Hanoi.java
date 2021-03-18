package iut.umontpellier.fr;
import java.util.ArrayList;

@SuppressWarnings("Duplicates")

public class Hanoi implements JeuPuzzle {
    private int taille;
    private ArrayList<Integer> tourr1 = new ArrayList<>();
    private ArrayList<Integer> tourr2 = new ArrayList<>();
    private ArrayList<Integer> tourr3 = new ArrayList<>();
    public Hanoi(int taille) {
        this.taille = taille;
        this.tourr1 = new ArrayList<>();
        this.tourr2 = new ArrayList<>();
        this.tourr3 = new ArrayList<>();
        for (int i = 0 ; i < this.taille ; i++) {
            tourr1.add(i+1);
        }

    }
    public Hanoi(ArrayList<Integer> tour1, ArrayList<Integer> tour2, ArrayList<Integer> tour3, int taille) {
        for (int i = 0 ; i < tour1.size() ; i++)
            this.tourr1.add(tour1.get(i));
        for (int i = 0 ; i < tour2.size() ; i++)
            this.tourr2.add(tour2.get(i));
        for (int i = 0 ; i < tour3.size() ; i++)
            this.tourr3.add(tour3.get(i));
        this.taille = taille;
    }
    public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> result = new ArrayList<>();
        int t1 = this.tourr1.get(0);
        int t2;
        int t3;
        if (!tourr2.isEmpty()) {
            t2 = this.tourr2.get(0);
        }
        else {
            t2= 0;
        }
        if (!tourr3.isEmpty()) {
            t3 = this.tourr3.get(0);
        }
        else {
            t3 =0;
        }
        if (t1 > t2) {
            ArrayList<Integer> t11 = this.tourr1;
            ArrayList<Integer> t21 = this.tourr2;
            ArrayList<Integer> t31 = this.tourr3;
            if (t11.size() > 0) {
                t11.remove(t11.size()-1);
            }
            t21.add(t1);
            Hanoi a = new Hanoi(t11,t21,t31,taille);
            result.add(a);
        }
        else {
            ArrayList<Integer> t11 = this.tourr1;
            ArrayList<Integer> t21 = this.tourr2;
            ArrayList<Integer> t31 = this.tourr3;
            if (t21.size() > 0) {
                t21.remove(t21.size()-1);
            }
            t11.add(t2);
            Hanoi a = new Hanoi(t11,t21,t31,taille);
            result.add(a);
        }
        if (t1 > t3) {
            ArrayList<Integer> t12 = this.tourr1;
            ArrayList<Integer> t22 = this.tourr2;
            ArrayList<Integer> t32 = this.tourr3;
            if (t12.size() > 0) {
                t12.remove(t12.size()-1);
            }
            t32.add(t1);
            Hanoi a = new Hanoi(t12,t22,t32,taille);
            result.add(a);
        }
        else {
            ArrayList<Integer> t12 = this.tourr1;
            ArrayList<Integer> t22 = this.tourr2;
            ArrayList<Integer> t32 = this.tourr3;
            if (t32.size() > 0) {
                t32.remove(t32.size()-1);
            }
            t12.add(t3);
            Hanoi a = new Hanoi(t12,t12,t12,taille);
            result.add(a);
    }
        if (t2 < t3) {
            ArrayList<Integer> t13 = this.tourr1;
            ArrayList<Integer> t23 = this.tourr2;
            ArrayList<Integer> t33 = this.tourr3;
            if (t33.size() > 0) {
                t33.remove(t33.size()-1);
            }
            t23.add(t3);
            Hanoi a = new Hanoi(t13,t23,t33,taille);
            result.add(a);
        }
        else {
            ArrayList<Integer> t13 = this.tourr1;
            ArrayList<Integer> t23 = this.tourr2;
            ArrayList<Integer> t33 = this.tourr3;
            if (t23.size() > 0) {
                t23.remove(t23.size()-1);
            }
            t33.add(t2);
            Hanoi a = new Hanoi(t13,t23,t33,taille);
            result.add(a);
        }
        return result;
    }
    public boolean estGagnant() {
        if ( tourr3.size() == taille ) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Hanoi{" +
                "taille=" + taille +
                ", tourr1=" + tourr1 +
                ", tourr2=" + tourr2 +
                ", tourr3=" + tourr3 +
                '}';
    }
}
