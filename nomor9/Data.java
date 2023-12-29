/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nomor9;

/**
 *
 * @author MY ASUS
 */
public class Data {
    String kata;
    int frekuensi = 1;

    public Data(String kata) {
        this.kata = kata;
    }

    public void setFrekuensi(int frekuensi) {
        this.frekuensi = frekuensi;
    }
    
    public void incrementFrekuensi(){
        frekuensi++;
    }
}
