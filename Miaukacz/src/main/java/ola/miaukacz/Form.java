/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ola.miaukacz;

import java.time.LocalDateTime;

public class Form {
    private String pesel;
    private String answer1;
    private String answer2;
    private LocalDateTime createdTime;

    public Form(String pesel, String answer1, String answer2) {
        this.pesel = pesel;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.createdTime = LocalDateTime.now();
    }

    public String getPesel() {
        return pesel;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
    
    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
