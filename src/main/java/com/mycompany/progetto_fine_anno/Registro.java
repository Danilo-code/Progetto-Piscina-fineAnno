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
 *
 * @author Danilo
 */
public class Registro  implements Serializable
{
    private  Abbonamento[] listaAbbonamenti;
    private int nAbbonamentiPresenti=0;
    private final int MAX_ABBONAMENTI=100;

    public Registro() 
    {
        listaAbbonamenti=new Abbonamento[MAX_ABBONAMENTI];
    }
    
    public int aggiungiAccesso(Abbonamento b)
    {
        if (nAbbonamentiPresenti>=MAX_ABBONAMENTI)
            return -1;
        listaAbbonamenti[nAbbonamentiPresenti]=new Abbonamento(b);
        nAbbonamentiPresenti++;
        return 0;
    }

       
    public int getnAbbonamentiPresenti() {
        return nAbbonamentiPresenti;
    }

    public int getMax()
    {
        return MAX_ABBONAMENTI;
    }



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

    public void setnAbbonamentiPresenti(int nAbbonamentiPresenti) {
        this.nAbbonamentiPresenti = nAbbonamentiPresenti;
    }
    
    //funziona
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
         
     public int eliminaAbb(LocalDate f)
     {
         Abbonamento b;
         String t;
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
         return -1;
     }
     private void aggiornaAbbonamenti(int posizione)
     {
         for (int i=posizione;i<nAbbonamentiPresenti-1;i++)
         {
             listaAbbonamenti[i]=listaAbbonamenti[i+1];
         }
         listaAbbonamenti[nAbbonamentiPresenti-1]=null;
         nAbbonamentiPresenti--;
         
     }
     
     
     
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
         
         public void salvaRegistro(String nomeFile)throws IOException, FileException
         {
             FileOutputStream f1= new FileOutputStream(nomeFile);
             ObjectOutputStream writer= new ObjectOutputStream(f1);
             writer.writeObject(this);
             writer.flush();
             writer.close();
         }
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



            
        



        
        

