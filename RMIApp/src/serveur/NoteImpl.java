/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.rmi.Remote;
import java.util.Random;

/**
 *
 * lenovo soure
 */
public class NoteImpl implements NoteInterface {
   @Override
   public Double getNote(int etudiantCin , String codeMatiere){
   Random rand = new Random(); //instance of random class
      double random = 10+10*rand.nextDouble(); 
      return random ; }
}
