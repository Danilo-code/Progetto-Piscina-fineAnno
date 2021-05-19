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
public class Abbonamento 
{
    private int codiceIdenntificativo;
    private String nome, cognome;
    private String tipologia;
    private LocalDate vendita;
    private LocalDate scadenza;

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
    
    


    @Override
    public String toString() {
        return "Nome : "+getNome()+" Cognome : "+getCognome()+" Tipologia : "+getTipologia()+" Codice identificativo : "+getCodiceIdenntificativo()+" "+"Data di acquisto "+getVendita(); //" Abbonamento acquistato il : "+ getVendita()+
    }
    
    
    public String contorollaTipologia(String g)
    {
        if (g.compareTo("Mensile")==0 || g.compareTo("mensile")==0 || g.compareTo("Settimanale")==0 ||g.compareTo("settimanale")==0 || g.compareTo("Annuale")==0 || g.compareTo("annuale")==0)
        return g;
        else 
            return g="Scadenza non valida, ripetere";
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
