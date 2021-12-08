package FFSSM;

import java.time.LocalDate;
import java.util.*;

public class Plongeur extends Personne{
	
    public int niveau;
    private List<Licence> licences = new ArrayList<Licence>();
    private Licence l1;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance, Club c){
        Plongeur plongeur = this;
        Licence l = new Licence(plongeur, numero, delivrance, c);
        licences.add(l);
    }
    
    public Licence derniereLicence(){
        Licence licence = licences.get(licences.size()-1);
        return licence;
    }
    
    public Licence getLicence(){
        return l1;
    }
}
