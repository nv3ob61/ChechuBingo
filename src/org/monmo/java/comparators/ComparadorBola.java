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
package org.monmo.java.comparators;

import java.util.Comparator;
import org.monmo.java.entities.Bola;
import org.monmo.java.enumerations.Criterio;

/**
 *
 * @author mon_mo | 2020
 */
public final class ComparadorBola implements Comparator<Bola> {

  private Criterio orden;

  public ComparadorBola(Criterio orden) {
    if (orden != null) {
      this.orden = orden;
    } else {
      this.orden = Criterio.NUM;
    }
  }

  @Override
  public int compare(Bola o1, Bola o2) {
    // Valor de Comparación
    int comparacion;

    // Criterio Ordenacion > Comparacion
    switch (orden) {
      case NUM:
        comparacion = o1.getNum() - (o2.getNum());
        break;
      default:
        comparacion = o1.getNum() - (o2.getNum());
        break;
    }

    // Devuelve Comparacion
    return comparacion;
  }

  public Criterio getOrden() {
    return orden;
  }

  public void setOrden(Criterio orden) {
    if (orden != null) {
      this.orden = orden;
    }
  }

}
