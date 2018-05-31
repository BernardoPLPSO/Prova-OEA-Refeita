/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import registro.Registro;

/**
 *
 * @author Pirlimpimposo
 */
public class Questao3 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile entrada1 = new RandomAccessFile("E://Desktop//Dados prova oea//Questao3//arq1.dat", "r");
        RandomAccessFile entrada2 = new RandomAccessFile("E://Desktop//Dados prova oea//Questao3//arq2.dat", "r");
        RandomAccessFile saida = new RandomAccessFile("E://Desktop//Dados prova oea//Questao3//arq3.dat", "rw");
        long inicio, meio, fim, i;
        long qtd1 = (entrada1.length())/102;
        long qtd2 = (entrada2.length())/102;
        fim = qtd2;
        inicio = 0;
        meio = (fim + inicio) / 2;
        //System.out.println(fim);
        //System.out.println(meio);
        while (entrada1.getFilePointer() < entrada1.length()) {
            Registro r1 = new Registro();
            r1.leRegistro(entrada1);
            System.out.println("Chave 1: "+ r1.getChave());
            while (entrada2.getFilePointer() >= 0 && entrada2.getFilePointer() < entrada2.length()) {
                Registro r2 = new Registro();
                entrada2.seek(meio*102);
                r2.leRegistro(entrada2);
                int chave1 = Integer.parseInt(r1.getChave().trim());
                int chave2 = Integer.parseInt(r2.getChave().trim());
                if (chave1 < chave2) {
                    fim = meio - 1;
                    meio = (inicio + fim) / 2;
                    System.out.println("Inicio: "+inicio);
                    System.out.println("Meio: "+meio);
                    System.out.println("Fim: "+fim);
                } else if (chave1 > chave2) {
                    inicio = meio + 1;
                    meio = (inicio + fim) / 2;
                    System.out.println("Inicio: "+inicio);
                    System.out.println("Meio: "+meio);
                    System.out.println("Fim: "+fim);
                } else if (chave1 == chave2) {
                    System.out.println("É igual");
                    r1.escreveRegistro(saida);
                    break;
                    //System.out.println(meio);
                }
                  if(inicio >= fim){
                    break;
                }
            }
            fim = qtd2;
            inicio = 0;
            meio = (fim + inicio) / 2;
            entrada2.seek(inicio);
            //System.out.println(meio);
        }
        entrada1.close();
        entrada2.close();
        saida.close();
    }
}
