/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import java.io.ByteArrayInputStream;

/**
 *
 * @author rivil
 */
public class ReportePersonasDTO {
    private String filename;
    private ByteArrayInputStream stream;
    private int lenght;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public ByteArrayInputStream getStream() {
        return stream;
    }

    public void setStream(ByteArrayInputStream stream) {
        this.stream = stream;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    
    
}


