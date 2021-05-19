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
public class Ordinatore 
{
    public static void scambia (int v[], int posizione1, int posizione2)
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
        public static void scambia (String v[], int posizione1, int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
                public static void scambia (Abbonamento v[], int data1, int data2)
    {
                Abbonamento c = null;
                c=v[data1];
                v[data1]=v[data2];
                v[data2]=c;
                /*
                c.setVendita(v[data1].getVendita());
                v[data1].setVendita(v[data2].getVendita());
                v[data2].setVendita(c.getVendita());*/
                
        
    }
    
    
          public static Abbonamento [] ordineCronologico(Abbonamento [] a)
    {
        Abbonamento [] ordinato=new Abbonamento  [a.length];
        for (int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        
        for (int i=0;i<ordinato.length-1;i++)
        {
            if(ordinato[i]!=null)
            {
               for (int j=i+1;j<ordinato.length-1;j++)
                {
                    if (ordinato[j]!=null)
                    {
                        if (ordinato[j].getVendita().isBefore(ordinato[i].getVendita()))
                        scambia(ordinato,i,j);
                    }

                 }  
            }

                
        }
       return ordinato;
            
    }
              
                
                
                
    public static int [] selectionSortCrescente(int [] a)
    {
        int [] ordinato=new int  [a.length];
        for (int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j]<ordinato[i])
                    scambia(ordinato,i,j);
            }
                
        }
        return ordinato;
            
    }
    
    
        public static int [] selectionSortDecrescente(int [] a)
    {
        int [] ordinato=new int  [a.length];
        for (int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j]>ordinato[i])
                    scambia(ordinato,i,j);
            }
                
        }
        return ordinato;
            
    }
        //Stringhe alfaberico
            public static String [] selectionSortCrescente(String [] a)
    {
        String [] ordinato=new String  [a.length];
        for (int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
                
        }
        return ordinato;
            
    }
            
            //alfabetico inverso
          public static String [] selectionSortDecrescente(String [] a)
    {
        String [] ordinato=new String  [a.length];
        for (int i=0;i<ordinato.length;i++)
        {
            ordinato[i]=a[i];
        }
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j].compareToIgnoreCase(ordinato[i])>0)
                    scambia(ordinato,i,j);
            }
                
        }
        return ordinato;
            
    }
          
     
          public static int [] bubbleSortCrescente (int [] a)
          {
                int [] ordinato=new int  [a.length];
                boolean scambioAvvenuto=false;
                for (int i=0;i<ordinato.length;i++)
                    ordinato[i]=a[i];
                do
                {
                    scambioAvvenuto=false;
                    for (int i=0;i<ordinato.length-1;i++)
                    {
                       if( ordinato[i]>ordinato[i+1])
                       {
                           scambia(ordinato, i, i+1);
                           scambioAvvenuto=true;
                       }
                           
                    }
                }while (scambioAvvenuto);
                return ordinato;
          }
          
          
                    public static int [] bubbleSortDecrescente (int [] a)
          {
                int [] ordinato=new int  [a.length];
                boolean scambioAvvenuto=false;
                for (int i=0;i<ordinato.length;i++)
                    ordinato[i]=a[i];
                do
                {
                    scambioAvvenuto=false;
                    for (int i=0;i<ordinato.length-1;i++)
                    {
                       if( ordinato[i]<ordinato[i+1])
                       {
                           scambia(ordinato, i, i+1);
                           scambioAvvenuto=true;
                       }
                           
                    }
                }while (scambioAvvenuto);
                return ordinato;
          }
          
                    
                    
                    
         public static String [] bubbleSortCrescente (String  [] a)
          {
                String  [] ordinato=new String   [a.length];
                boolean scambioAvvenuto=false;
                for (int i=0;i<ordinato.length;i++)
                    ordinato[i]=a[i];
                do
                {
                    scambioAvvenuto=false;
                    for (int i=0;i<ordinato.length-1;i++)
                    {
                       if( ordinato[i].compareToIgnoreCase(ordinato[i+1])>0)
                       {
                           scambia(ordinato, i, i+1);
                           scambioAvvenuto=true;
                       }
                           
                    }
                }while (scambioAvvenuto);
                return ordinato;
          }
         
         
                  public static String [] bubbleSortDecrescente (String  [] a)
          {
                String  [] ordinato=new String   [a.length];
                boolean scambioAvvenuto=false;
                for (int i=0;i<ordinato.length;i++)
                    ordinato[i]=a[i];
                do
                {
                    scambioAvvenuto=false;
                    for (int i=0;i<ordinato.length-1;i++)
                    {
                       if( ordinato[i].compareToIgnoreCase(ordinato[i+1])<0)
                       {
                           scambia(ordinato, i, i+1);
                           scambioAvvenuto=true;
                       }
                           
                    }
                }while (scambioAvvenuto);
                return ordinato;
          }

                    
         
}
