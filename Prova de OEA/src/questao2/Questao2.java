/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao2;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import registro.Registro;

/**
 *
 * @author Pirlimpimposo
 */
public class Questao2 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile entrada = new RandomAccessFile("E://Desktop//Dados prova oea//Questao2//arq1.dat", "r");
        RandomAccessFile saida = new RandomAccessFile("E://Desktop//Dados prova oea//Questao2//arq2.dat", "rw");
        while(entrada.getFilePointer() < entrada.length()){
            Registro r = new Registro();
            r.leRegistro(entrada);
            if(r.terminaCom(r.getEmail(), "gmail.com")){
                r.escreveRegistro(saida);
            }
        }
        
    }
}
