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
package org.monmo.java.libraries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.monmo.java.comparators.ComparadorBola;
import org.monmo.java.entities.Bola;
import org.monmo.java.entities.Bombo;
import org.monmo.java.entities.Carton;
import org.monmo.java.enumerations.Criterio;
import org.monmo.java.interfaces.IBingo;

/**
 *
 * @author Jonsui
 */
public class UtilesSorteo {

  public static final int LONG_CARTON = 12;

  public static final int MAX_NUM = 99;
  public static final int MIN_NUM = 0;

  //Inicio Random
  public static final Random RND = new Random();

  public static final //comparar bolas
          Comparator<Bola> CMP = new ComparadorBola(Criterio.NUM);

  public static final List<Bola> generarBomboBingo() {
//    System.out.println("GENERANDO TODAS LAS BOLAS PARA EL BOMBO: ");

    // Definir bombo
    int cont = 0;
    //utiles manejo bombo, lista de bolas y comparador..
    List<Bola> bombo = new ArrayList<>(IBingo.LONG_BOMBO_BINGO);

    do {
      //Crea bola y la añade a la colección, ordena y suma al contador
      Bola b = new Bola(cont);
//      b.muestraBola();
      bombo.add(b);
      Collections.sort(bombo, CMP);
      cont++;
    } while (cont < IBingo.LONG_BOMBO_BINGO);

    // Devolver Bombo
    return bombo;
  }

  //generador de bolas random.
  public static final Bola randomBola() {
    int r = RND.nextInt(MAX_NUM);
    return new Bola(r);
  }

  //generar carton
  public static final List<Bola> generarCarton() {
    int cont = 0;
    List<Bola> apuesta = new ArrayList<>();

    do {

      int num = UtilesSorteo.randomBola().getNum();

      Comparator<Bola> CMP = new ComparadorBola(Criterio.NUM);

      Collections.sort(apuesta, CMP);

      Bola clave = new Bola(num);

      int posicion = Collections.binarySearch(apuesta, clave, CMP);

      if (posicion < 0) {
        Bola b = new Bola(num);
        apuesta.add(b);
        Collections.sort(apuesta, CMP);
        cont++;
      }
    } while (cont < LONG_CARTON);
    return apuesta;
  }

  public static void muestraEstadoBombo(Bombo bom) {
    int cont = 0;
    //mostrador bombo con separadores cada 10 bolas.
    for (Bola bola : bom.getBombo()) {
      if (cont % 10 == 0) {
        System.out.println();
        System.out.printf(bola.toString() + " | ");
        cont++;
      } else {
        System.out.printf(bola.toString() + " | ");
        cont++;
      }
    }
  }

  public static synchronized final boolean checkWin(Bombo bom, List<Carton> cartones, int bola) {
    boolean bingoOk = false;
    
    for (Carton carton : cartones) {
      for (int i = 0; i < carton.getCarton().size(); i++) {
        if (carton.getCarton().get(i).getNum() == bola) {
          carton.setAciertos(carton.getAciertos() + 1);
          bingoOk = UtilesSorteo.tenemosGanador(bom, carton);
        }
      }
    }
    return bingoOk;

  }

  //comprueba que el num de aciertos del cartón son el total de nums.
  public static boolean tenemosGanador(Bombo bom, Carton c) {
    boolean bingoOk = false;
    if (c.getAciertos() == LONG_CARTON) {
      bingoOk = true;
      System.out.println("HAN CANTADO BINGOOOOOO!!");
      System.out.println();
      c.setRestantes(bom.getBombo().size());
      System.out.printf(String.format("%s%n", c.muestraCarton(c)));
    }
    return bingoOk;
  }

  //comprueba que el num de aciertos del cartón son el total de nums.
  public static synchronized Carton cogeCartonGanador(Bombo bom, List<Bola> jugada, Carton c) {
    Carton ganador = new Carton(LONG_CARTON, muestraRestantes(jugada));
    if (c.getAciertos() == LONG_CARTON) {

    }
    return c;
  }

  public static synchronized int muestraRestantes(List<Bola> jugada) {
    return IBingo.LONG_BOMBO_BINGO - jugada.size();
  }

  public static synchronized int sacaBola(Bombo bom, List<Bola> jugada) {

    //Hace shuffle al bombo y saca la primera bola
    Collections.shuffle(bom.getBombo(), RND);
    Bola nueva = bom.getBombo().get(0);

    //añade la bola a la jugada y la quita del bombo.
    jugada.add(nueva);
    bom.getBombo().remove(nueva);

    Collections.sort(bom.getBombo(), CMP);   //ordena de nuevo
    //movemos la bolsa
//      Collections.shuffle(bom.getBombo(), RND);

    System.out.println();
    System.out.println();
    System.out.println("ENTRADAS: " + (bom.getBombo().size() + 1));  //tests...

    //ordenamos los nums que ya han salido
    Collections.sort(jugada, CMP);
    //a modo test se muestran
    for (Bola bola : jugada) {
      bola.muestraBola();
    }

    //separador
    System.out.println();
    //devuelve la bola de después del shuffle del bombo.
    return nueva.getNum();
  }
}
