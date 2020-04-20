/* 
 * Copyright (C) 2020 Jonsui
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.monmo.java.comparators;

import java.time.LocalDate;
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
