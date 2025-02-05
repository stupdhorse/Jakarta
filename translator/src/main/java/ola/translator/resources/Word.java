/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ola.translator.resources;

import java.time.LocalDateTime;


public class Word {
    private String pl;
    private String eng;
    private String de;
    private LocalDateTime timestamp;
    
    public Word(String pl,String eng,String de){
        this.pl = pl;
        this.eng = eng;
        this.de = de;
        this.timestamp = LocalDateTime.now();
    }
    public Word(String pl,String eng,String de,LocalDateTime timestamp){
    this.pl = pl;
    this.eng = eng;
    this.de = de;
    this.timestamp = timestamp;
    }
    public String getPL() {
        return pl;
    }

    public void setPL(String pl) {
        this.pl = pl;
    }
    
    public String getENG() {
        return eng;
    }

    public void setENG(String eng) {
        this.eng = eng;
    }

    public String getDE() {
        return de;
    }

    public void setDE(String de) {
        this.de = de;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String ToString(){
        String output = "";
        output += this.pl;
        output += " " ;
        output+= this.eng;
        output += " ";
        output += this.de;
        return output;
    }

}
