package FFSSM;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.time.LocalDate;
import FFSSM.*;

public class Tests_Club {
    
        Club oceane;
	Moniteur mathilde, defne;
        Plongeur maelle, paul;
        Site atlantide;
        LocalDate date1 = LocalDate.of(2021,12,01);
        LocalDate date2 = LocalDate.of(2021,12,22);
        LocalDate date3 = LocalDate.of(2000,12,22);
        LocalDate datenaiss = LocalDate.of(2001,01,01);
        Set<Plongee> historiquePlongees = new HashSet<Plongee>();
        Set<Plongee> nonConformes = new HashSet<Plongee>();
        Plongee p1;
    
    @BeforeEach
    public void setUp() {
        oceane = new Club(mathilde, "Oceane", "0682202862", "9 rue du sable blanc");
        Set<Plongee> historiquePlongees = new HashSet<Plongee>();
        atlantide = new Site("atlantide", "récif coralien");
        mathilde = new Moniteur("0021", "Lanyar", "Mathilde", "3 rue des coquillages", "0682928232", datenaiss, 5, 0231);
        paul = new Plongeur("0143", "Tebuahc", "Paul", "8 boulevard des fleurs", "0601012001", datenaiss, 2);
        maelle = new Plongeur("2222", "Xuonpmar", "Maelle", "7 via des papillons", "0645678921", datenaiss, 2);
        Plongee p1 = new Plongee(atlantide, mathilde, date1, 10, 2);
    }
    
    @Test
    public void testPlongeesNonConformes(){
        paul.ajouteLicence("2001", date1, oceane);
        p1.ajouteParticipant(paul);
        maelle.ajouteLicence("0669", date3, oceane);
        p1.ajouteParticipant(maelle);
        assertFalse(p1.estConforme(), 
            "La plongée est conforme.");
        assertEquals(oceane.plongee, oceane.plongeesNonConformes(),
                "La liste est bonne.");
    }
    
    @Test
    public void testOrganisePlongee(){
        oceane.organisePlongee(p1);
        assertTrue(oceane.plongee.contains(p1),
                "La plongée n'est pas organisée.");
    }
    
    @Test
    public void testgetNom(){
        assertEquals(oceane.getNom(), "Oceane", 
                "Le club doit s'appeler Océane.");
    }
    
    @Test
    public void testgetAdresse(){
        assertEquals(oceane.getAdresse(), "9 rue du sable blanc", 
                "L'adresse n'est pas la bonne.");
    }
    
    @Test
    public void testgetTelephone(){
        assertEquals(oceane.getTelephone(), "0682202862", 
                "Ce n'est pas le bon numéro.");
    }
    
    @Test
    public void testsetPresident(){
        oceane.setPresident(defne);
        assertEquals(oceane.getPresident(), defne, 
                "La présidente doit désormais être Defne.");
    }
    
    @Test
    public void testsetNom(){
        oceane.setNom("SousLOcean");
        assertEquals(oceane.getNom(), "SousLOcean", 
                "Le club doit désormais s'appeler SousLOcean.");
    }
    
    @Test
    public void testsetAdresse(){
        oceane.setAdresse("12 avenue des petits lapins");
        assertEquals(oceane.getAdresse(), "12 avenue des petits lapins", 
                "L'adresse doit désormais être '12 avenue des petits lapins'.");
    }
    
    @Test
    public void testsetTelephone(){
        oceane.setTelephone("0706050403");
        assertEquals(oceane.getTelephone(), "0706050403", 
                "Le numéro doit désormais être '0706050403'.");
    }
}
