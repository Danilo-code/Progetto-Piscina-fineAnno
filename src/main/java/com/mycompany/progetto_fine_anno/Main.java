/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_fine_anno;
import eccezioni.EccezionePosizioneNonValida;
import eccezioni.FileException;
import java.io.IOException;
import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String nomeFile="registro.txt";
           String nomeFileBinario="Registro.bin";
            Scanner tastiera = new Scanner (System.in);
             String [] vociMenu=new String [8];
            vociMenu[0]="Esci";
            vociMenu[1]="Aggiungi abbonamento";
            vociMenu[2]="Verifica la presenza di abbonamenti scaduti";
            vociMenu[3]="Rimuovi abbonamenti scaduti";
            vociMenu[4]="Ricerca abbonamenti a partire dal nome & congome";
            vociMenu[5]="Visualizza gli abbonamenti in ordina cronologico";
            vociMenu[6]="Esporta gli abbonamenti in CSV";
            vociMenu[7]="Salva dati su un file binario";
                try 
                            {
                    r=r.caricaRegistro(nomeFileBinario);
                    System.out.println("Dati caricati correttamente");
                } 
                catch (IOException ex) 
                {
                    System.out.println("Impossibile accedere al file in lettura. I dati non sono stati caricati");
                } 
                catch (FileException ex) 
                {
                    System.out.println(ex.toString());
                }
             Menu menu=new Menu(vociMenu);
             do
             {
                try
                {
                 sceltaUtente=menu.sceltaMenu(); 
                 
                 switch(sceltaUtente)
                 {
                     case 0:
                     {
                        System.out.println("L'applicazione verrà terminata");
                        break;
                     }

                     case 1:
                     {
                        int verifica;
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
                         b.setVendita(LocalDate.of(anno, mese, giorno));  
                         r.aggiungiAccesso(b);
                         verifica=r.aggiungiAccesso(b);
                         if (verifica==0)
                             System.out.println("Operazione riuscita");
                         else if (verifica==-1)
                             System.out.println("Operazione non riuscita");
                         abbonamenti++;
                         tastiera.nextLine();
                         

                         
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
                                     System.out.println(r.stampaOrdinato(Appoggio));
   
                              
                                 
                                 
                              
                              
                              break;
                          }
                          case 6:
                          {

                              try 
                              {
                                  r.salvaAbbo(nomeFile);
                                  System.out.println("Salvataggio avvenuto correttamente");
                              }
                              catch (IOException ex) 
                              {
                                System.out.println("Salvataggio non avvenuto ");
                              }
                              catch(EccezionePosizioneNonValida | FileException e2)
                              {
                                 System.out.println("Salvataggio non avvenuto correttamente");
                              } 
                              
                              break;
                          }
                          case 7:
                          {
                              try 
                              {
                                  r.salvaRegistro(nomeFileBinario);
                                  System.out.println("Salvataggio avvenuto correttamente");
                              }
                              catch (IOException ex) 
                              {
                                System.out.println("Impossibile accedere al file. Salvataggio non avvenuto ");
                              }
                                 catch(FileException e2)
                                {
                                    System.out.println(e2.toString());
                                } 

                            
                              break;
                          }
                 }
                } //parentesi try
                catch (InputMismatchException | NumberFormatException | DateTimeException e1)
                {   
                    System.out.println("Input non corretto");
                    tastiera.nextLine();
                }
             }while (sceltaUtente!=0);

        }

    
}
