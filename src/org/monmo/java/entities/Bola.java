/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.java.entities;

/**
 *
 * @author Jonsui
 */
public class Bola {
  
  private int num;

  public Bola() {
  }

  public Bola(int num) {
    this.num = num;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  @Override
  public String toString() {
    return String.format("BOLA: %-2d", getNum());
  }
  
  public final void muestraBola(){
    System.out.println(toString());
  }
}
