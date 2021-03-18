package iut.umontpellier.fr;
import java.util.ArrayList;

public interface JeuPuzzle {
    boolean estGagnant();
    ArrayList<JeuPuzzle> genererFils();
}


