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
import java.time.Month;

public class Tests_Plongee {
        Club oceane;
	Moniteur mathilde;
        Plongeur maelle, paul;
        Site atlantide;
        LocalDate date1 = LocalDate.of(2021,12,01);
        LocalDate date2 = LocalDate.of(2021,12,22);
        LocalDate date3 = LocalDate.of(1998, 05, 10);
        LocalDate datenaiss = LocalDate.of(2001,01,01);
        Set<Plongeur> participantsPlongee = new HashSet<Plongeur>();
        Embauche job1;
        Licence l1;
        Plongee p1;
    
    @BeforeEach
    public void setUp() {
        oceane = new Club(mathilde, "Oceane", "0682202862", "9 rue du sable blanc");
        atlantide = new Site("atlantide", "récif coralien");
        mathilde = new Moniteur("0021", "Lanyar", "Mathilde", "3 rue des coquillages", "0682928232", datenaiss, 5, 0231);
        paul = new Plongeur("0143", "Tebuahc", "Paul", "8 boulevard des fleurs", "0601012001", datenaiss, 2);
        maelle = new Plongeur("2222", "Xuonpmar", "Maelle", "7 via des papillons", "0645678921", datenaiss, 2);
        p1 = new Plongee(atlantide, mathilde, date2, 10, 2);
        l1 = new Licence(mathilde, "0103", date1, oceane);
    }
    
    @Test
    public void testAjouteParticipant() {
        participantsPlongee.add(paul);
        assertTrue(participantsPlongee.contains(paul), 
                "Il n'y a pas les bons participants.");
    }
    
    @Test
    public void testGetDate() {
        assertEquals(p1.getDate(), date2, 
                "La date n'est pas la bonne.");
    }
    
    @Test
    public void testGetLieu() {
        assertEquals(p1.getLieu(), atlantide, 
                "Le lieu n'est pas le bon.");
    }
    
    @Test
    public void testGetChefDePalanquee() {
        assertEquals(p1.getChefDePalanquee(), mathilde, 
                "Le chef de palanquee doit être Mathilde.");
    }
    
    @Test
    public void testGetProfondeur() {
        assertEquals(p1.getProfondeur(), 10, 
                "La profondeur n'est pas la bonne.");
    }
    
    @Test
    public void testGetDuree() {
        assertEquals(p1.getDuree(), 2, 
                "La durée n'est pas la bonne.");
    }
    
   @Test
    public void testPlongeeValide() {
        paul.ajouteLicence("2001", date1, oceane);
        p1.ajouteParticipant(paul);
        assertTrue(p1.estConforme(), 
                "La plongée doit être conforme.");
    }
    
    @Test
    public void testPlongeeNonValide(){
        paul.ajouteLicence("2001", date1, oceane);
        maelle.ajouteLicence("0669", date3, oceane);
        p1.ajouteParticipant(paul);
        p1.ajouteParticipant(maelle);
        assertFalse(p1.estConforme(), 
                "La plongée doit être non-conforme.");
    }
    
}
