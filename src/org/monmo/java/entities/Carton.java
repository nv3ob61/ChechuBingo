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
import java.util.List;
import org.monmo.java.interfaces.IWinner;
import org.monmo.java.libraries.UtilesSorteo;

/**
 *
 * @author Jonsui
 */
public class Carton implements IWinner {

  public static final int DEF_ID = 0;
  public static final int DEF_NUMS = 12;
  public static final int DEF_ACIERTOS = 0;
  public static final int DEF_RESTANTES = 100;

  private int id;
  private List<Bola> carton = new ArrayList<>(DEF_NUMS);
  private int aciertos;
  private int restantes;
  private static int autoI = 1;

  public Carton() {
    this.id = autoI;
    this.carton = new ArrayList<>(DEF_NUMS);
    this.aciertos = DEF_ACIERTOS;
    this.restantes = DEF_RESTANTES;
    autoI++;
  }

  public Carton(int aciertos, int restantes) {
    this.id = autoI;
    this.aciertos = aciertos;
    this.restantes = restantes;
    autoI++;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Bola> getCarton() {
    return carton;
  }

  public void setCarton(List<Bola> carton) {
    this.carton = carton;
  }

  public int getAciertos() {
    return aciertos;
  }

  public void setAciertos(int aciertos) {
    this.aciertos = aciertos;
  }

  public int getRestantes() {
    return restantes;
  }

  public void setRestantes(int restantes) {
    this.restantes = restantes;
  }

  @Override
  public String toString() {
    return String.format("%s, %d", stringCarton());
  }

  public final String muestraCarton(Carton c) {
    return String.format("%s%nNÚMS RESTANTES en este BINGO: %d%n",
            c.stringCarton(), getRestantes());
  }

  public final String stringCarton() {
    StringBuilder sb = new StringBuilder();
    int cont = 0;

    for (Bola bola : getCarton()) {
      if (cont == 0) {
        sb.append("| ");
      }
      sb.append(bola.toString()).append(String.format(" | "));
      sb.toString().trim();
      cont++;
      if (cont > 3) {
        sb.append("%n");
        cont = 0;
      }
    }
    //quitamos la útlima
    if (Character.valueOf(sb.charAt(sb.length() - 2)).equals('|')) {
      sb.replace(sb.length() - 2, sb.length() - 1, "");
    }

    return sb.toString().trim();
  }

  @Override
  public void win(Carton c) {
    //copiar el trozo de tenemos ganador!
    System.out.println("TEST GANA CARTON.. NO HACE NADA");
    //comprobar primero el carton y de alguna forma si gana añadirlo a
    //rank, si no que a la próx bola vuelva a hacer la comprobación.
    RANK.add(String.valueOf(c.getId()));
  }
}
