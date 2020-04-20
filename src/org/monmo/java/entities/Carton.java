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

/**
 *
 * @author Jonsui
 */
public class Carton {

  public static final int DEF_NUMS = 12;

  private List<Bola> carton = new ArrayList<>(DEF_NUMS);

  public Carton() {
    this.carton =new ArrayList<>(DEF_NUMS);
  }

  public List<Bola> getCarton() {
    return carton;
  }

  public void setCarton(List<Bola> carton) {
    this.carton = carton;
  }

  @Override
  public String toString() {
    return String.format("%s", stringCarton());
  }

  public final String muestraCarton(Carton c) {
    return String.format("%s", c.stringCarton());
  }

  public final String stringCarton() {
    StringBuilder sb = new StringBuilder();
    int cont = 0;

    for (Bola bola : getCarton()) {
      if(cont == 0){
        sb.append("| ");
      }
      sb.append(bola.toString()).append(String.format(" | "));
      sb.toString().trim();
      cont++;
      if(cont > 3){
        sb.append("%n");
        cont = 0;
      }
    }
    //quitamos la útlima
    if(Character.valueOf(sb.charAt(sb.length()-2)).equals('|')){
      sb.replace(sb.length()-2, sb.length()-1, "");
    }

    return sb.toString().trim();
  }
}
