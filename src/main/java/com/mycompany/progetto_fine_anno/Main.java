/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_fine_anno;
import java.time.*;
import java.util.*;
/**
 *
 * @author Danilo
 */
public class Main 
{
        public static void main(String[] args) 
        {
           
            int sceltaUtente=-1;
            int abbonamenti = 0;
            Registro r=new Registro();
            Abbonamento b;
           
            Scanner tastiera = new Scanner (System.in);
             String [] vociMenu=new String [8];
            vociMenu[0]="Esci";
            vociMenu[1]="Aggiungi abbonamento";
            vociMenu[2]="Verifica la presenza di abbonamenti scaduti";
            vociMenu[3]="Rimuovi abbonamenti scaduti";
            vociMenu[4]="Ricerca abbonamenti a partire dal nome & congome";
            vociMenu[5]="Visualizza gli abbonamenti in ordina cronologico";
            vociMenu[6]="Salva gli abbonamnti in CSV";
            vociMenu[7]="Salva dati su un file binario";
             
             Menu menu=new Menu(vociMenu);
             do
             {
                 sceltaUtente=menu.sceltaMenu(); 
                 
                 switch(sceltaUtente)
                 {
                     case 1:
                     {
                        
                         b=new Abbonamento();
                         int giorno,mese,anno;
                         System.out.println("Codice : ");
                         b.setCodiceIdenntificativo(abbonamenti);
                         System.out.println(abbonamenti);
                         System.out.println("Inserisci nome : ");
                         b.setNome(tastiera.nextLine());
                        
                         System.out.println("Inserisci cognome : ");
                         b.setCognome(tastiera.nextLine());
                          System.out.println("Inserisci scadenza :  Settimanale/Mensile/Annua");
                         b.setTipologia(tastiera.nextLine());
                         System.out.println("Inserisci giorno dell'acquisto : ");
                         giorno=tastiera.nextInt();
                         System.out.println("Inserisci mese dell'acquisto : ");
                         mese=tastiera.nextInt();
                         System.out.println("Inserisci anno dell'acquisto : ");
                         anno=tastiera.nextInt();
                         abbonamenti++;
                         b.setVendita(LocalDate.of(anno, mese, giorno));
                         r.aggiungiAccesso(b);
                         
                         /*
                         System.out.println(b.getCodiceIdenntificativo()+" "+b.getCognome()+" "+b.getNome()+" "+b.getTipologia()+" "+b.getVendita());
                         System.out.println(b.toString());
                         System.out.println(r.getnAbbonamentiPresenti());*/
                                 
                    
                         //b.contorollaTipologia(b.getTipologia());
                         
                          b.setNome(tastiera.nextLine());
                         

                         
                         break;
                     }
                     case 2:
                     {
                         int giorno,mese,anno;
                         int controllo;
                         
                       System.out.println("Inserisci giorno : ");
                         giorno=tastiera.nextInt();
                         System.out.println("Inserisci mese  : ");
                         mese=tastiera.nextInt();
                         System.out.println("Inserisci anno : ");
                         anno=tastiera.nextInt();
                          LocalDate g=LocalDate.of(anno, mese, giorno);
                         // System.out.println(r.getnAbbonamentiPresenti());
                          controllo=r.presenzaScadenza(g);
                          if(controllo==0)
                              System.out.println("E' presente un abbonamento scaduto");
                          else if(controllo==1)
                               System.out.println("Non è presente un abbonamento scaduto");
                           tastiera.nextLine();
                              
                          
                          
                         break;
                     }
                     case 3:
                     {
                         int giorno,mese,anno;
                         int appoggio;
                         System.out.println("Elimina abbonamenti scaduti il  ");
                         System.out.println("Inserisci giorno : ");
                          giorno=tastiera.nextInt();
                         System.out.println("Inserisci mese  : ");
                         mese=tastiera.nextInt();
                         System.out.println("Inserisci anno : ");
                         anno=tastiera.nextInt();
                          LocalDate k=LocalDate.of(anno, mese, giorno);
                          appoggio=r.eliminaAbb(k);
                          if (appoggio==0)
                              System.out.println("Eliminazione riuscita");
                          else
                             System.out.println("Non è stato eliminato nessun abbonamento");
                          System.out.println(r.toString());
                         break;
                     }
                          case 4:
                     {
                         String nome="";
                         String cognome=""; 
                         String u="";
                         System.out.println("Inserire nome : ");
                         nome=tastiera.nextLine(); 
                         System.out.println("Inserire cognome : ");
                         cognome=tastiera.nextLine();
                         u+=r.ricercaPerNomeCognome(nome, cognome);
                         System.out.println(u);
                     
                         
                         break;
                     }
                          case 5:
                          {
                              Abbonamento[] Appoggio= new Abbonamento[r.getMax()];
                               
                                  System.out.println("Abbonamenti in ordine cronologico : ");
                                
                                 for(int i=0;i<r.getnAbbonamentiPresenti();i++)
                                 {
                                     if(Appoggio[i]==null) 
                                         Appoggio[i]=r.ordina()[i];
                                 }         
                                     System.out.println(r.tiPregoFunziona(Appoggio));
   
                              
                                 
                                 // System.out.println(r.toString());
                              
                              
                              break;
                          }
                 }
             }while (sceltaUtente!=0);

        }

    
}
