package iut.umontpellier.fr;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class Contexte {

    private JeuPuzzle jeuInitial;
    private ArrayList<JeuPuzzle> solution;

    public Contexte(JeuPuzzle jeuInitial) {
        this.jeuInitial = jeuInitial;
        solution = new ArrayList<>();
    }
    public void resoudre() {
        ArrayList<Couple> frontiere = new ArrayList<>();
        ArrayList<JeuPuzzle> dejavu = new ArrayList<>();
        Couple actu = new Couple(jeuInitial,null);
        if (jeuInitial.estGagnant()) {
            solution.add(jeuInitial);
        }
        if (solution.isEmpty()) {
            dejavu.add(jeuInitial);
            actu.mettreAJour(frontiere,dejavu);
            while (!frontiere.isEmpty() && solution.isEmpty()) {
                actu = frontiere.remove(0);
                if (actu.getJeu().estGagnant()) {
                    solution = actu.getListeDeMouvements();
                }
                else {
                    actu.mettreAJour(frontiere,dejavu);
                }
            }
        }
    }

    public ArrayList<JeuPuzzle> getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        return "Les coups à faire pour obtenir la solution sont " + solution;
    }
}
