/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao1;

import java.io.RandomAccessFile;
import registro.Registro;

/**
 *
 * @author Pirlimpimposo
 */
public class Questao1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        RandomAccessFile entrada = new RandomAccessFile("E://Desktop//Dados prova oea//Questao1//arq1.dat", "r");
        RandomAccessFile saida = new RandomAccessFile("E://Desktop//Dados prova oea//Questao1//arq2.dat", "rw");
        int i = 1;
        long pos = entrada.length();
        entrada.seek(entrada.length() - 102);
        System.out.println(entrada.length());
        System.out.println(entrada.length() - 102);
        Registro r = new Registro();
        while (entrada.length() - 102 * i >= 0) {
            pos = entrada.length() - 102 * i;
            System.out.println(pos);
            entrada.seek(pos);
            r.leRegistro(entrada);
            r.escreveRegistro(saida);
            i++;
        }
        entrada.close();
        saida.close();
    }

}
