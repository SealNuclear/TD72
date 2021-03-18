package iut.umontpellier.fr;



import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class Couple {

    private JeuPuzzle jeu;
    private Couple predecesseur;

    public Couple(JeuPuzzle jeu, Couple predecesseur) {
        this.jeu = jeu;
        this.predecesseur = predecesseur;
    }

    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<JeuPuzzle> dejaVus) {
                ArrayList<JeuPuzzle> fils = this.jeu.genererFils();
                for (int i = 0 ; i < fils.size();i++) {
                    if (dejaVus.contains(fils.get(i)) == false){
                            dejaVus.add(fils.get(i));
                            Couple fil = new Couple(fils.get(i),this);
                            frontiere.add(fil);

                    }
                }
            }
    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList listemouv = new ArrayList();
        if (predecesseur != null ) {
            ArrayList ancienneliste = predecesseur.getListeDeMouvements();
            for(int i = 0 ; i < predecesseur.getListeDeMouvements().size(); i++) {
                listemouv.add(ancienneliste.get(i));
            }
        }
        listemouv.add(jeu);
        return listemouv;
    }

    public JeuPuzzle getJeu() {
        return jeu;
    }
}
