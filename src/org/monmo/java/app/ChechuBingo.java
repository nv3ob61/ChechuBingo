/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.java.app;

import java.util.ArrayList;
import java.util.List;
import org.monmo.java.entities.Bola;
import org.monmo.java.entities.Carton;
import org.monmo.java.enumerations.Criterio;
import org.monmo.java.libraries.UtilesSorteo;

/**
 *
 * @author Jonsui
 */
public class ChechuBingo {
  
  //generador del bombo, punchin punchin!
  public static final List<Bola> BOMBO = UtilesSorteo.generarBomboBingo();

  // Colección Cartones
  public static final List<Carton> CARTONES = new ArrayList<Carton>();

  private final Criterio criOrd = Criterio.NUM;   //todavía no se gasta...

  public static void main(String[] args) {
    int cont = 0;
    
    //mostrador bombo
    for (Bola bola : BOMBO) {
      if (cont % 10 == 0) {
        System.out.println();
        System.out.printf(bola.toString() + " | ");
        cont++;
      } else {
        System.out.printf(bola.toString() + " | ");
        cont++;    
      }
    }

    //separador
    System.out.println();

    //generador de 20 cartones aleatorios ordenados
    for (int i = 0; i < 20; i++) {
      Carton carton = new Carton();
      System.out.println("GENERADOR DE CARTONES Nº " + (i + 1));
      carton.setCarton(UtilesSorteo.generarCarton());
      System.out.printf(String.format("%s%n", carton.stringCarton()));

      CARTONES.add(carton);
    }

  }

}
