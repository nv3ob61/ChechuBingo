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
package org.monmo.java.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.monmo.java.entities.Bombo;
import org.monmo.java.entities.Winner;

/**
 *
 * @author Jonsui
 */
public class ChechuBingoMain {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws InterruptedException {
    Bombo b = new Bombo();

    ExecutorService e = Executors.newFixedThreadPool(1);
    Winner win = new Winner();

    e.execute(b);
    e.shutdown();
    e.awaitTermination(100, TimeUnit.SECONDS);

    //muestra datos carrera.
    win.printResultados();
  }

}
