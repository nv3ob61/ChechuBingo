/* 
 * Copyright (C) 2020 mon_mode   0mon.mode@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
