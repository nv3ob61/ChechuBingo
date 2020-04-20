/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
