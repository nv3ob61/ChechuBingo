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
package org.monmo.java.enumerations;

/**
 *
 * @author mon_mo 2020
 */
public enum Criterio {
    NUM("num");

    // Camposc
    private final String nombre;

    // Constructor Privado
    private Criterio(String nombre) {
        // Validar Nombre
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
