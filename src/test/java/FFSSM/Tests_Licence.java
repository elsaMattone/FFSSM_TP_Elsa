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

public class Tests_Licence {
        Club oceane;
	Moniteur mathilde;
        LocalDate date1 = LocalDate.of(2021,12,01);
        LocalDate date2 = LocalDate.of(2021,12,22);
        LocalDate date3 = LocalDate.of(2023,02,21);
        LocalDate datenaiss = LocalDate.of(2001,01,01);
        Licence l1;
    
    @BeforeEach
    public void setUp() {
        oceane = new Club(mathilde, "Oceane", "0682202862", "9 rue du sable blanc");
        mathilde = new Moniteur("0021", "Lanyar", "Mathilde", "3 rue des coquillages", "0682928232", datenaiss, 5, 0231);
        l1 = new Licence(mathilde, "0103", date1, oceane);
    }
    
    @Test
    public void testGetPossesseur(){
        assertEquals(l1.getPossesseur(), mathilde, 
                "Le possesseur doit-être Mathilde.");
    }
    
    @Test
    public void testGetNumero(){
        assertEquals(l1.getNumero(), "0103", 
                "La licence n'est pas la bonne.");    
    }
    
    @Test
    public void testGetDelivrance(){
        assertEquals(l1.getDelivrance(), date1, 
                "Cette licence n'est pas délivrée à cette date.");
    }
    
    @Test
    public void testGetClub(){
        assertEquals(l1.getClub(), oceane, 
                "Cette licence n'est pas délivrée par ce club.");
    }
    
    @Test
    public void testEstValide(){
        assertFalse(l1.estValide(date3),
                "La licence doit être non valide.");
        assertTrue(l1.estValide(date1), 
                "La licence doit être valide.");
    }
}
