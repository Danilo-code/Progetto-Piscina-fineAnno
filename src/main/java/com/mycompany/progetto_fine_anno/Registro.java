/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_fine_anno;

import java.time.*;

/**
 *
 * @author Danilo
 */
public class Registro 
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
             if (d.isEqual(b.getVendita()))
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
     public String tiPregoFunziona(Abbonamento[] d)
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
         for (int i=0;i<nAbbonamentiPresenti;i++)
         {
             b=listaAbbonamenti[i];
             if (f.isEqual(b.getVendita()))
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
     
     }



            
        



        
        

