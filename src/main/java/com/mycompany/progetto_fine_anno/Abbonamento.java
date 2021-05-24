/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.progetto_fine_anno;

import java.io.Serializable;
import java.time.*;

/**
 *
 * @author Danilo
 */
public class Abbonamento implements Serializable
{
    private int codiceIdenntificativo;
    private String nome, cognome;
    private String tipologia;
    private LocalDate vendita;
    private LocalDate scadenza;
  

/**
 * 
 * 
 * 
 * 
*/

    public Abbonamento (int anno, int mese, int giorno, String tipologia, String nome, String cognome, int codiceIdentificativo)
    {
        this.nome=nome;
        this.cognome=cognome;
        this.tipologia=tipologia;
        this.codiceIdenntificativo=codiceIdentificativo;
        vendita=LocalDate.of(anno, mese, giorno);
        scadenza=null;  
    }

    public void setVendita(LocalDate vendita) {
        this.vendita = vendita;
    }
    public Abbonamento(Abbonamento b)
    {
        nome=b.getNome();
        cognome=b.getCognome();
        codiceIdenntificativo=b.getCodiceIdenntificativo();
        tipologia=b.getTipologia();
        vendita=b.getVendita();
        scadenza=null;
        
        
    }
    
    public Abbonamento()
    {
        nome="";
        cognome="";
        vendita=LocalDate.now();
        scadenza=null;
    }


    //SETTER
    public void setCodiceIdenntificativo(int codiceIdenntificativo) {
        this.codiceIdenntificativo = codiceIdenntificativo;
    }

    public void setNome(String nome) {
            this.nome = nome;
       
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setTipologia(String tipologia) { 
        this.tipologia = tipologia;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }


    
    
    //GETTER

    public int getCodiceIdenntificativo() {
        return codiceIdenntificativo;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public LocalDate getVendita() {
        return vendita;
    }
    
    public LocalDate getScadenza(Abbonamento b, String t)
    {
        
        switch(t)
        {
            case "Settimanale":
            case "settimanale":
            {
                 scadenza=b.getVendita().plusDays(7);
                 b.setTipologia("Settimanale");
                
                break;
            }
            case "Mensile" :
            case "mensile" :
            {
                scadenza=b.getVendita().plusMonths(1);
                 b.setTipologia("Mensile");
                 break;
            }
            case "Annua" :
            case "annua" :
            {
                scadenza=b.getVendita().plusYears(1);
                 b.setTipologia("Annua");
                 break;
            }
            case "":
            {
                b.setTipologia(" ");
                scadenza=null;
            }
            default:
            {
                b.setTipologia("La tipologia inserita non è valida ");
                scadenza=null;
            }
        }
        return scadenza;
        
    }


    @Override
    public String toString() {
        return "Nome : "+getNome()+"  Cognome : "+getCognome()+"  Tipologia : "+getTipologia()+"  Codice identificativo : "+getCodiceIdenntificativo()+"  Data di acquisto "+getVendita()+"  Scade il : "+getScadenza(this, getTipologia()); //" Abbonamento acquistato il : "+ getVendita()+
    }
    
    

    /*
    public int controllaGiorno (int giorno , int mese)
    {
        
        if (mese==11 || mese==4 ||mese==9 ||mese==6)
        {
            if (giorno<=30 && giorno >0)
                return 0; //tutto ok
            else
                return 1; //giorno non valido
        }
        else if (mese==2)
        {
            if (giorno<=28 && giorno >0)
                return 0;
            else 
                return 1;
        }
        else    
            if (giorno<=31 && giorno >0)
                return 0; //tutto ok
            else
                return 1; //giorno non valido
                
    }
    */
}
