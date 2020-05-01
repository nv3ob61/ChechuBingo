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
package org.monmo.java.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.monmo.java.interfaces.IBingo;
import org.monmo.java.libraries.UtilesSorteo;

/**
 *
 * @author Jonsui
 */
public final class Bombo implements Runnable, IBingo {

  //generador del bombo, punchin punchin!
  public static final Winner DEF_WINNER = new Winner();
  public static final List<Bola> DEF_BOMBO = UtilesSorteo.generarBomboBingo();

  private List<Bola> bombo;
  private Winner winner;

  public Bombo() {
    bombo = DEF_BOMBO;
    winner = DEF_WINNER;
  }

  public Bombo(List<Bola> bombo, Winner w) {
    this.bombo = bombo;
    this.winner = w;
  }

  public List<Bola> getBombo() {
    return bombo;
  }

  public void setBombo(List<Bola> bombo) {
    this.bombo = bombo;
  }

  public void interrupt() {
    running = false;
  }

  private volatile boolean running = true;

  @Override
  public synchronized void run() {
    //donde se irán acumulando las bolas de la jugada del cartón
    List<Bola> jugada = new ArrayList<>(100);

    // Colección Cartones
    List<Carton> cartones = Collections.synchronizedList(new ArrayList<>());

    //generador de 20 cartones aleatorios ordenados
    for (int i = 0; i < 20; i++) {
      Carton carton = new Carton();
      System.out.println("GENERADOR DE CARTONES Nº " + (i + 1));
      carton.setCarton(UtilesSorteo.generarCarton());
      System.out.printf(String.format("%s%n", carton.stringCarton()));

      cartones.add(carton);
    }

    System.out.println();
    System.out.println();
    System.out.println("Pausa de 3 segundos Y EMPIEZA EL BINGO.");
    System.out.printf(" ---------> Si parpadeas te lo pierdes.");
    for (int i = 0; i < 3; i++) {
      try {
        System.out.printf(".");
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        Logger.getLogger(Bombo.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    boolean bingo = false;

    //generamos objeto bombo
    Bombo bom = new Bombo();
    Carton ganador = new Carton();
    //juega la partida...
    try {
      while (!bingo || running) {
        //sacamos bola
        int bola = UtilesSorteo.sacaBola(bom, jugada);
        //muestra bola
        System.out.println("Sale la BOLA núm: " + bola);
        System.out.println();
        synchronized(this){
          
//      Collections.sort(bom.getBombo(), CMP);
        bingo = UtilesSorteo.checkWin(bom, cartones, bola);
        if (bingo) {
//          UtilesSorteo.muestraEstadoBombo(bom);
          ganador = UtilesSorteo.cogeCartonGanador(bom, jugada, ganador);
          bom.getBombo().clear();
          interrupt();
        } else {
          UtilesSorteo.muestraEstadoBombo(bom);
        }
        
        }
        Thread.sleep(50);
      }
    } catch (InterruptedException ex) {
      Logger.getLogger(Bombo.class.getName()).log(Level.SEVERE, null, ex);
    }
    winner.win(ganador);
  }
}
