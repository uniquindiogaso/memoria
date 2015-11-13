/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import org.junit.Assert;
import org.junit.Test;


/**
 *
 * @author LAURA
 */
public class PrincipalTest {
    
    
     @Test
     public void testAgregarJugador() {
         
       Principal p = new Principal();
       boolean e = p.agregarJugador("a", 1);
         Assert.assertTrue(e);
     }
     
     
}
