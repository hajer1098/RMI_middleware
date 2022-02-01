/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//lance et enregistre un objet de type NoteImpl comme etant objet distant 
// creation d'un registre RMI -- acces au registre via le port 1099
package serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * lenovo soure
 */
public class Serveur {
    public static void main (String args[]) throws RemoteException, MalformedURLException{
        int port = 1099;
        String url = "rmi://127.0.0.1";
        //creation d'ine instance de l'objet remote 
        NoteImpl note = new NoteImpl();
        LocateRegistry.createRegistry(port);
        if(System.getSecurityManager() == null){
            System.out.println("manager avec succès ");
            System.setSecurityManager(new RMISecurityManager());}
        //une instance de la classe qui implemente l'interface Remote
        System.out.println("serveur chargé");
        Remote remoteObject = UnicastRemoteObject.exportObject(note,port);
        Naming.rebind(url+"/RemoteObject",remoteObject);
  
    }

}
