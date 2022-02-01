/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import serveur.NoteInterface;

/**
 *
 * lenovo soure
 */
public class Client {
      public static void main (String args[]) throws RemoteException, MalformedURLException, NotBoundException{
         String url= "rmi://127.0.0.1";
          if (System.getSecurityManager() == null) {
              System.out.println("client lancé");
              System.setSecurityManager(new RMISecurityManager());
              //retrouver l'objet remote a partir de l'URL -- un casting est necessaire
              NoteInterface received = (NoteInterface) Naming.lookup(url+"/RemoteObject");
              //appel de la methode remote acquise apres le lookup
              double randomNumber = received.getNote(93,"MOY215");
              System.out.println("LA note envoyé est "+randomNumber);
          }
   
      }
      }

