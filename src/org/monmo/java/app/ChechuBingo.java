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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.monmo.java.comparators.ComparadorBola;
import org.monmo.java.entities.Bola;
import org.monmo.java.entities.Carton;
import org.monmo.java.enumerations.Criterio;
import org.monmo.java.libraries.UtilesSorteo;

/**
 *
 * @author Jonsui
 */
public class ChechuBingo {

  //Inicio Random
  public static final Random RND = new Random();

  //generador del bombo, punchin punchin!
  public static final List<Bola> BOMBO = UtilesSorteo.generarBomboBingo();
  //donde se irán acumulando las bolas de la jugada del cartón
  public static final List<Bola> JUGADA = new ArrayList<>(100);

  // Colección Cartones
  public static final List<Carton> CARTONES = new ArrayList<Carton>();

  private final Criterio criOrd = Criterio.NUM;   //todavía no se gasta...

  public static void main(String[] args) throws InterruptedException {
    int cont = 0;
    boolean bingo = false;

    System.out.println("SORTEO BINGO A LO CUTRE");
    System.out.println("=======================");

    //separador
    System.out.println();
    System.out.println("Mostramos primero todas las bolas que contiene el bombo");
    System.out.println();
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
    System.out.println();
    System.out.println();
    System.out.printf("Pausa de 3 segundos para que las contemples.");
    for (int i = 0; i < 3; i++) {
      System.out.printf(".");
      Thread.sleep(1000);
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

    System.out.println();
    System.out.println();
    System.out.printf("Pausa de 3 segundos para que las contemples.");
    for (int i = 0; i < 3; i++) {
      System.out.printf(".");
      Thread.sleep(1000);
    }

    //movemos la bolsa
    Collections.shuffle(BOMBO, RND);
    //mostrador bombo
    muestraEstadoBombo();

    //juega la partida...
    do {
      int bola = sacaBola();
//      Collections.sort(BOMBO, cmp);
      bingo = compruebaCartones(bola);
      muestraEstadoBombo();
//      Thread.sleep(100);
    } while (!bingo);

    int ganadores = 0;   //mover
    for (Carton carton : CARTONES) {
      if (carton.getAciertos() == 12) {
        System.out.println();
        System.out.println();
        System.out.println("MOSTRANDO EL CARTÓN GANADOR");
        System.out.println("---------------------------");
        System.out.printf(String.format("%s%n", carton.muestraCarton(carton)));
        System.out.println("TOTAL DE ACIERTOS: " + carton.getAciertos());
        ganadores++;
      }
    }

    //separador
    System.out.println();

    System.out.printf("Han salido un total de %d ganadores%n%n", ganadores);
  }

  private static boolean compruebaCartones(int bola) {
    boolean bingoOk = false;
    for (Carton carton : CARTONES) {
      for (int i = 0; i < carton.getCarton().size(); i++) {
        if (carton.getCarton().get(i).getNum() == bola) {
          carton.setAciertos(carton.getAciertos() + 1);
          bingoOk = tenemosGanador(carton);
        }
      }
    }
    return bingoOk;
  }

  private static boolean tenemosGanador(Carton c) {
    boolean bingoOk = false;
    if (c.getAciertos() == 12) {
      c.setRestantes(BOMBO.size());
      bingoOk = true;
      System.out.println("HAN CANTADO BINGOOOOOO!!");
      System.out.printf(String.format("%s%n", c.muestraCarton(c)));
    }
    return bingoOk;
  }

  private static int sacaBola() {
    Comparator<Bola> cmp = new ComparadorBola(Criterio.NUM);
//    Collections.sort(BOMBO, cmp);

    //Haz la jugada otra vezzzz....
    Collections.shuffle(BOMBO, RND);
    Bola nueva = BOMBO.get(0);

    JUGADA.add(nueva);
    BOMBO.remove(nueva);
    Collections.sort(BOMBO, cmp);
    //movemos la bolsa
//      Collections.shuffle(BOMBO, RND);

    System.out.println();
    System.out.println();
    System.out.println("ENTRADAS: " + (BOMBO.size() + 1));

    Collections.sort(JUGADA, cmp);

    for (Bola bola : JUGADA) {
      bola.muestraBola();
    }

    //separador
    System.out.println();

    return nueva.getNum();
  }

  private static void muestraEstadoBombo() {
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
  }
}
