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
package org.monmo.java.app.maintests;

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
import org.monmo.java.libraries.UtilesSorteo;

/**
 *
 * @author Jonsui
 */
public class ChechuBingoMainTestClass {
//
//  public static final //comparar bolas
//          Comparator<Bola> CMP = new ComparadorBola(Criterio.NUM);
//
//  //Inicio Random
//  public static final Random RND = new Random();
//
//  //donde se irán acumulando las bolas de la jugada del cartón
//  public static final List<Bola> JUGADA = new ArrayList<>(100);
//
//  // Colección Cartones
//  public static final List<Carton> CARTONES = new ArrayList<Carton>();
//
//  private final Criterio criOrd = Criterio.NUM;   //todavía no se gasta...
//
//  public static void main(String[] args) throws InterruptedException {
//    int cont = 0;
//    int ganadores = 0;
//    
//    //generamos objeto bombo
//    Bombo bom = new Bombo();
//    
//    boolean bingo = false;
//    
//
//    System.out.println("SORTEO BINGO A LO CUTRE");
//    System.out.println("=======================");
//
//    //separador
//    System.out.println();
//    System.out.println("Mostramos primero todas las bolas que contiene el bombo");
//    System.out.println();
//    //mostrador bombo
//    for (Bola bola : bom.getBombo()) {
//      if (cont % 10 == 0) {
//        System.out.println();
//        System.out.printf(bola.toString() + " | ");
//        cont++;
//      } else {
//        System.out.printf(bola.toString() + " | ");
//        cont++;
//      }
//    }
//    System.out.println();
//    System.out.println();
//    System.out.printf("Pausa de 3 segundos para generar 20 cartones aleatorios.");
//    for (int i = 0; i < 3; i++) {
//      System.out.printf(".");
//      Thread.sleep(1000);
//    }
//    System.out.println();
//    System.out.println("--------------------------------------------------------");
//    //separador
//    System.out.println();
//
//    //generador de 20 cartones aleatorios ordenados
//    for (int i = 0; i < 20; i++) {
//      Carton carton = new Carton();
//      System.out.println("GENERADOR DE CARTONES Nº " + (i + 1));
//      carton.setCarton(UtilesSorteo.generarCarton());
//      System.out.printf(String.format("%s%n", carton.stringCarton()));
//
//      CARTONES.add(carton);
//    }
//
//    System.out.println();
//    System.out.println();
//    System.out.println("Pausa de 3 segundos Y EMPIEZA EL BINGO.");
//    System.out.printf(" ---------> Si parpadeas te lo pierdes.");
//    for (int i = 0; i < 3; i++) {
//      System.out.printf(".");
//      Thread.sleep(1000);
//    }
//
//    //separador
//    System.out.println();
//
//    //movemos la bolsa
//    Collections.sort(bom.getBombo(), CMP);
//
//    //mostrador bombo
//    UtilesSorteo.muestraEstadoBombo(bom);

//    //juega la partida...
//    while (!bingo) {
//      //sacamos bola
//      int bola = sacaBola(bom);
//      //muestra bola
//      System.out.println("Sale la BOLA núm: " + bola);
//      System.out.println();
////      Collections.sort(bom.getBombo(), CMP);
//      bingo = compruebaCartones(bom, bola);
//
//      UtilesSorteo.muestraEstadoBombo(bom);
//      Thread.sleep(400);
//    }

    //separador y fin del sorteo
//    System.out.println();
//    System.out.println();
//    System.out.println("*******************************************************");
//    System.out.println("                  FIN DEL SORTEO");
//    System.out.println("*******************************************************");
//
//    //busca el cartón ganador. o ganadores
//    for (Carton carton : CARTONES) {
//      if (carton.getAciertos() == UtilesSorteo.LONG_CARTON) {
//        System.out.println();
//        System.out.println("MOSTRANDO EL CARTÓN GANADOR");
//        System.out.println("---------------------------");
//        System.out.printf(String.format("%s%n", carton.muestraCarton(carton)));
//        System.out.println("TOTAL DE ACIERTOS ..........: " + carton.getAciertos());
//        ganadores++;
//      }
//    }
//
//    //separador
//    System.out.println();
//
//    System.out.printf("Han salido un total de %d ganadore%n%n", ganadores);
//
//    //notadev
//    System.out.println();
//    System.out.println();
//    System.out.println();
//    System.out.println("-------------------------------------------------------");
//    System.out.println("NOTA PARA DESARROLLO: Si salen varios ganadores hay que "
//            + "comprobar para cada cartón los NÚMS RESTANTES en el BINGO.\n\n"
//            + "No acaba de ir bien. Thanks.");
//  }

////  private static boolean compruebaCartones(Bombo bom, int bola) {
//    boolean bingoOk = false;
//    for (Carton carton : CARTONES) {
//      for (int i = 0; i < carton.getCarton().size(); i++) {
//        if (carton.getCarton().get(i).getNum() == bola) {
//          carton.setAciertos(carton.getAciertos() + 1);
//          bingoOk = UtilesSorteo.tenemosGanador(bom, carton);
//        }
//      }
//    }
//    return bingoOk;
//  }

//
//  private static int sacaBola(Bombo bom) {
//
//    //Hace shuffle al bombo y saca la primera bola
//    Collections.shuffle(bom.getBombo(), RND);
//    Bola nueva = bom.getBombo().get(0);
//
//    //añade la bola a la jugada y la quita del bombo.
//    JUGADA.add(nueva);
//    bom.getBombo().remove(nueva);
//
//    Collections.sort(bom.getBombo(), CMP);   //ordena de nuevo
//    //movemos la bolsa
////      Collections.shuffle(bom.getBombo(), RND);
//
//    System.out.println();
//    System.out.println();
//    System.out.println("ENTRADAS: " + (bom.getBombo().size() + 1));  //tests...
//
//    //ordenamos los nums que ya han salido
//    Collections.sort(JUGADA, CMP);
//    //a modo test se muestran
//    for (Bola bola : JUGADA) {
//      bola.muestraBola();
//    }
//
//    //separador
//    System.out.println();
//    //devuelve la bola de después del shuffle del bombo.
//    return nueva.getNum();
//  }


}
