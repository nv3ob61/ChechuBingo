/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.monmo.java.libraries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import org.monmo.java.comparators.ComparadorBola;
import org.monmo.java.entities.Bola;
import org.monmo.java.enumerations.Criterio;

/**
 *
 * @author Jonsui
 */
public class UtilesSorteo {

  public static final int LONG_BOMBO_BINGO = 100;
  
  public static final int LONG_CARTON = 12;
  
  public static final int MAX_NUM = 99;
  public static final int MIN_NUM = 0;

  //Inicio Random
  public static final Random RND = new Random();

  public static final List<Bola> generarBomboBingo() {
//    System.out.println("GENERANDO TODAS LAS BOLAS PARA EL BOMBO: ");

    // Definir bombo
    int cont = 0;
    //utiles manejo bombo, lista de bolas y comparador..
    List<Bola> bombo = new ArrayList<>(LONG_BOMBO_BINGO);
    Comparator<Bola> cmp = new ComparadorBola(Criterio.NUM);

    do {
      //Crea bola y la añade a la colección, ordena y suma al contador
      Bola b = new Bola(cont);
//      b.muestraBola();
      bombo.add(b);
      Collections.sort(bombo, cmp);
      cont++;
    } while (cont < LONG_BOMBO_BINGO);

    // Devolver Bombo
    return bombo;
  }

  //generador de bolas random.
  public static final Bola randomBola() {
    int r = RND.nextInt(MAX_NUM);  
    return new Bola(r);
  }

  //generar carton
  public static final List<Bola> generarCarton() {
    int cont = 0;
    List<Bola> apuesta = new ArrayList<>();

    do {

      int num = UtilesSorteo.randomBola().getNum();

      Comparator<Bola> cmp = new ComparadorBola(Criterio.NUM);

      Collections.sort(apuesta, cmp);

      Bola clave = new Bola(num);

      int posicion = Collections.binarySearch(apuesta, clave, cmp);

      if (posicion < 0) {
        Bola b = new Bola(num);
        apuesta.add(b);
        Collections.sort(apuesta, cmp);
        cont++;
      }
    } while (cont < LONG_CARTON);
    return apuesta;
  }
}
