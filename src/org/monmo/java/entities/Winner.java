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

import org.monmo.java.interfaces.IWinner;

/**
 *
 * @author Jonsui
 */
public class Winner implements IWinner {

  @Override
  public void win(Carton c) {
    //copiar el trozo de tenemos ganador!
    System.out.println("TEST GANA CARTON.. NO HACE NADA");
    //comprobar primero el carton y de alguna forma si gana añadirlo a
    //rank, si no que a la próx bola vuelva a hacer la comprobación.
    RANK.add(String.valueOf(c.getId()));
  }

  public void printResultados() {
    System.out.println("========================");
    System.out.println("RESULTADOS FINALES ....:");
    System.out.println("========================");

    for (int i = 0; i < RANK.size(); i++) {
      System.out.println("Posición " + (i + 1) + " cartón nº: " + RANK.get(i));
    }
  }
}
