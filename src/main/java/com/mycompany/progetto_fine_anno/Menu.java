/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_fine_anno;

import java.util.Scanner;

/**
 *
 * @author Danilo
 */
public class Menu 
{
    
    private String [] elencoVoci;
    private int numeroVoci;
    
    
    public Menu(String [] elencoVoci)
      {
          numeroVoci=elencoVoci.length;
          this.elencoVoci=new String[numeroVoci];
            for (int i=0;i<numeroVoci;i++)
                this.elencoVoci[i]=elencoVoci[i];
      
       }
    public void visualizzaMenu ()
    {
        System.out.println("MENU' : ");
        for (int i=0;i<numeroVoci;i++)
            System.out.println(i+" : "+elencoVoci[i]);
        
    }
    
    public int sceltaMenu()
    {
        Scanner tastiera=new Scanner(System.in);
        String inputUtente;
        boolean inputUtenteOKO=true;
        int sceltaUtente=0;
        do{
          inputUtenteOKO=true;
        visualizzaMenu();
        System.out.println("Scelta : ");
        inputUtente=tastiera.nextLine();
        ///contrllo per imput numerico
        for (int i=0;i<inputUtente.length();i++)
        {
            if(inputUtente.charAt(i)>='0' && inputUtente.charAt(i)<='9')
                i++;
            else 
            { 
                inputUtenteOKO=false;
                break;             
            }
               //controllo se l'input è valido
        }
        if(inputUtenteOKO) // inputUtente=true?
        {
           sceltaUtente=Integer.parseInt(inputUtente);
           if (sceltaUtente<0 || sceltaUtente>numeroVoci-1)
               inputUtenteOKO=false;
        }
        if(!inputUtenteOKO) //inpout utente=false..
        {
            System.out.println("Valore inserito non valido, la prego di rifare.");
            tastiera.nextLine();
            
        }
        
        }while(!inputUtenteOKO);
        return sceltaUtente;
    }
}
