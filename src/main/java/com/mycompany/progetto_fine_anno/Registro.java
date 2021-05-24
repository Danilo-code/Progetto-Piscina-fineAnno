/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_fine_anno;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.FileException;
import file.TextFile;
import java.io.*;
import java.io.IOException;
import java.time.*;

/**
 *La classe Registro rappresenta un array di oggetti di tipo Abbonamento, i suoi attributi sono : <br>
 * listaAbbonamenti :  rappresenta l'array che contiene gli abbonamenti <br>
 * nAbbonamentiPresenti : tiene conto del numero di abbonamenti presenti nell'array <br>
 * MAX_ABBONAMENTI : indica il limite di abbonamenti ch possono essere presenti nello stesso tempo nell'array <br>
 * 
 * @author Danilo
 */
public class Registro  implements Serializable
{
    private  Abbonamento[] listaAbbonamenti;
    private int nAbbonamentiPresenti=0;
    private final int MAX_ABBONAMENTI=2;

    /**
     * Costruttore della classe Registro, permette di inizalizzare un array di grandezza MAX_ABBONAMENTI<br>
     * @param listaAbbonamenti: indica l'array di abbonamenti di grandezza MAX_ABBONAMENTI<br>
     */
    public Registro() 
    {
        listaAbbonamenti=new Abbonamento[MAX_ABBONAMENTI];
    }
    
    /**
     * Il metodo aggiungiAccesso aggiunge un abbonamento (passatogli come input) all'array<br>
     * @param b indica l'abbonamento da aggiungere all'array<br>
     * @return 1 oppure 0 se l'operazione è andata a buon fine<br>
     */
    public int aggiungiAccesso(Abbonamento b)
    {
        if (nAbbonamentiPresenti>MAX_ABBONAMENTI)
            return -1;
        listaAbbonamenti[nAbbonamentiPresenti]=new Abbonamento(b);
        nAbbonamentiPresenti++;
        return 0;
    }

     /**
      * Restituisce il numero di abbonamenti di cui è composto l'array<br>
      * @return nAbbonamentiPresenti numero di abbonamenti presenti nell'array<br>
      */  
    public int getnAbbonamentiPresenti() {
        return nAbbonamentiPresenti;
    }
    
    public Abbonamento getAbb (int posizione)
    {
        return listaAbbonamenti[posizione];
    }
    /**
     * Restituisce il numero massimo di array che si possono aggiungere<br>
     * @return MAX_ABBONAMENTI grandezza dell'array
     */
    public int getMax()
    {
        return MAX_ABBONAMENTI;
    }


/**
 * Il metodo presenzaScadenza cerca all'interno dell'array una corrispondenza tra la data d e  la data di scadenza dell'abbonamento in posizione i<br>
 * @param d Rappresenta la data di scadenza da cercare all'interno dell'array<br>
 * @return 0 se l'operazione è andata a buon fine, oppure 1 se l'operazione non è riuscita<br>
 */
    public int presenzaScadenza(LocalDate d)
    {
       

          Abbonamento b;
         for (int i=0;i<nAbbonamentiPresenti;i++)
         {
             b=listaAbbonamenti[i];
             if (d.isEqual(b.getScadenza(b, b.getTipologia())))
             {
                 return 0;
             }
         }
         return -1;
          
            
    }

   /* public void setnAbbonamentiPresenti(int nAbbonamentiPresenti) {
        this.nAbbonamentiPresenti = nAbbonamentiPresenti;
    }
    */
    //funziona
    /**
     * Il metodo ricercaPerNomeCognome, permette di cercare all'interno dell'array listaAbbonamenti, i dati relativi all'abbonamento intestato alla persona di nome g e di congnome d<br>
     * @param g rappresenta il nome da cercare all'interno dell'array di abbonamenti<br>
     * @param d rappresenta il cognome da cercare all'interno dell'array di abbonamenti<br>
     * @return La stringa contentente i dati dell'abbonamento che corrisponde alla ricerca<br>
     */
    public String ricercaPerNomeCognome(String g, String d)
    {
        String s="";
 
              for(int j=0;j<MAX_ABBONAMENTI;j++)
                  {
                      if (listaAbbonamenti[j]!=null)
                      {
                         
                          if (listaAbbonamenti[j].getNome().equalsIgnoreCase(g) && listaAbbonamenti[j].getCognome().equalsIgnoreCase(d))
                             s+=listaAbbonamenti[j].getCodiceIdenntificativo()+" "+listaAbbonamenti[j].getNome()+" "+listaAbbonamenti[j].getCognome()+" "+listaAbbonamenti[j].getTipologia()+" "+listaAbbonamenti[j].getVendita();
                      }
                  }
              return s;
       
    }
    
    /**
     * Il metodo ordina serve ad ordinare un array in ordine cronologico di emissione inverso<br>
     * @return Restituisce un array copia di listaAbbonamenti ordinato in ordine cronologico <br>
     */
    public Abbonamento[] ordina()
    {
        Abbonamento[] elencoAbb = new Abbonamento[MAX_ABBONAMENTI];
        for (int i=0;i<nAbbonamentiPresenti;i++)
        {
            if (elencoAbb[i]==null)
            elencoAbb[i]=listaAbbonamenti[i];
            else 
                break;
        }
       elencoAbb=Ordinatore.ordineCronologico(elencoAbb);
        return elencoAbb;
    }
        

    
    
    
    /**
     * Consente di ottenere una String in cui sono riportati, per ogni valore di i, i dati dell'abbonamento con il codice corrispondente<br>
     * @return una stringa la quale contiente tutti gli abbonamenti contenuti nell'array listaAbbonamenti<br>
     */
    @Override
     public String  toString()
     {
        String s = "";
        try
        {
            for (int i = 0; i < nAbbonamentiPresenti; i++) 
            {
                s+=listaAbbonamenti[i].toString() + "\n";
            }
        }
        catch(NullPointerException e)
        {
           
        }
        return s;
    }
     
     /**
      * Il metodo stampaOrdinato serve a stampare un Array dopo che è stato ordinato,<br>
      * @param d rappresenta l'abbonamento, dopo esser stato ordinato , da stampare<br>
      * @return una stringa la quale contiente tutti gli abbonamenti contenuti nell'array d<br>
      */
     public String stampaOrdinato(Abbonamento[] d)
     {
                 String s = "";
        try
        {
            for (int i = 0; i < nAbbonamentiPresenti; i++) 
            {
                s+=d[i].toString() + "\n";
            }
        }
        catch(NullPointerException e)
        {
           
        }
        return s;
     }
         /**
          * Il metodo eliminaAbb, grazie ad una data inserita dall'utente come input, una volta invocato provvederà a cercare l'abbonamento con la da di scadenza uguale alla data inserita dall'utente all'interno di listaAbbonamenti per poi elimanarlo<br>
          * @param f rappresenta la data da ricercare all''interno dell'array listaAbbonamenti per identificare l'abbonamento da eliminare successivamente<br>
          * @return 0 se l'operazione è andata a buon fine, oppure 1 se l'operazione non è riuscita<br>
          */
     public int eliminaAbb(LocalDate f)
     {
         Abbonamento b;
         String t;
         for (int j=0;j<MAX_ABBONAMENTI;j++)
         {
            for (int i=0;i<nAbbonamentiPresenti;i++)
            {
                b=listaAbbonamenti[i];
                t=b.getTipologia();
                if (f.isEqual(b.getScadenza(b, t)))
                {
                    aggiornaAbbonamenti(i);
                    return 0;
                }
            }
         }

         return -1;
     }
     
     /**
      * Il metodo aggiornaAbbonamenti ha il compito di aggiornare la posizione di degli abbonamenti all'interno dell'array, dopo l'eliminazione di uno di essi<br>
      * @param posizione inidica la posizione dell'abbonamento trovato grazie al metodo eliminaAbb
      */
     private void aggiornaAbbonamenti(int posizione)
     {
         for (int i=posizione;i<nAbbonamentiPresenti-1;i++)
         {
             listaAbbonamenti[i]=listaAbbonamenti[i+1];
         }
         listaAbbonamenti[nAbbonamentiPresenti-1]=null;
         nAbbonamentiPresenti--;
         
     }
     
     
     /**
      * Permette di esportare in formato CSV i dati di tutti gli abbonamenti<br>
      * @param nomeFile inidca il nome del file sul quale verranno esportati i dati con estensione .txt<br>
      * @throws IOException<br>
      * @throws EccezionePosizioneNonValida<br>
      * @throws FileException <br>
      */
         public void salvaAbbo(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        
        for(int i=0;i<MAX_ABBONAMENTI;i++)
        {

                
                if(listaAbbonamenti[i]!=null )
                {
                    f1.toFile(listaAbbonamenti[i].getCodiceIdenntificativo()+";"+listaAbbonamenti[i].getCognome()+";"+listaAbbonamenti[i].getNome()+";"+listaAbbonamenti[i].getVendita()+";"+listaAbbonamenti[i].getTipologia()+";"+listaAbbonamenti[i].getVendita()+";");
                }
           

        }
        f1.close();
        
    }
         
         
         /**
          * Permette salvare i dati su un file binario<br>
          * @param nomeFile inidca il nome del file sul quale verranno salvati i dati con estensione .bin<br>
          * @throws IOException
          * @throws FileException 
          */
         public void salvaRegistro(String nomeFile)throws IOException, FileException
         {
             FileOutputStream f1= new FileOutputStream(nomeFile);
             ObjectOutputStream writer= new ObjectOutputStream(f1);
             writer.writeObject(this);
             writer.flush();
             writer.close();
         }
         
         /**
          * Permette caricare i dati da un file binario<br>
          * @param nomeFile inidca il nome del file dal quale verranno letti i dati con estensione .bin
          * @return
          * @throws IOException
          * @throws FileException 
          */
         public Registro caricaRegistro (String nomeFile) throws IOException, FileException
         {
             Registro d;
             FileInputStream f1=new FileInputStream(nomeFile);
             ObjectInputStream reader=new ObjectInputStream(f1);
            try 
            {
                 d=(Registro)reader.readObject();
                 reader.close();
                 return d;
            } 
            catch (ClassNotFoundException ex) 
            {
                reader.close();
                throw new FileException("Errore di lettura");
            }   
         }
     }



            
        



        
        

