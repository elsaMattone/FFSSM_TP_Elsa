package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import FFSSM.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tests_Moniteur {
        Club oceane;
	Moniteur mathilde;
        LocalDate date1 = LocalDate.of(2021,12,01);
        LocalDate date2 = LocalDate.of(2021,12,22);
        LocalDate date3 = LocalDate.of(2000,12,22);
        LocalDate datenaiss = LocalDate.of(2001,01,01);
        Embauche job1;
        List<Embauche> listeEmplois = new ArrayList<Embauche>();
        List<Embauche> listeEmbauche = new ArrayList<Embauche>();
    
    @BeforeEach
    public void setUp() {
        oceane = new Club(mathilde, "Oceane", "0682202862", "9 rue du sable blanc");
        Set<Plongee> palanquee1 = new HashSet<Plongee>();
        List<Embauche> listeEmplois = new ArrayList<Embauche>();
        job1 = new Embauche(date1, mathilde, oceane);mathilde = new Moniteur("0021", "Lanyar", "Mathilde", "3 rue des coquillages", "0682928232", datenaiss, 5, 0231);
    }
    
    @Test
    public void testEmployeurActuel(){
        assertEquals(mathilde.employeurActuel(), Optional.empty(),
                "Le moniteur ne doit pas avoir d'employeur.");
        mathilde.nouvelleEmbauche(oceane, date1);
        assertEquals(mathilde.employeurActuel(), Optional.ofNullable(oceane),
                "Mathilde est employée par Océane.");
    }
    
    @Test
    public void testEmplois(){
        List<Embauche> listeEmplois = new ArrayList<Embauche>();
        Embauche embChef = new Embauche(date1, mathilde, oceane);
        listeEmplois.add(embChef);
        mathilde.nouvelleEmbauche(oceane, date1);
        assertEquals(mathilde.listeEmplois, mathilde.emplois(),
                "L'emploi aurait dû être ajouté.");
    }
    
    @Test
    public void testTerminerEmbauche(){
        mathilde.nouvelleEmbauche(oceane, date3);
        mathilde.terminerEmbauche(date1);
        assertEquals(date1, mathilde.listeEmplois.get(mathilde.listeEmplois.size()-1).getFin(),
                "La liste n'est pas complète.");
    }
}
