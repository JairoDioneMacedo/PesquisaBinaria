/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jairo.pesquisa.binaria;

import javax.swing.JOptionPane;

/**
 *
 * @author Jairo
 */
public class PesquisaBinaria {

    static int inicial = 1;
    static int fim = 10;
    static boolean encontrado = false;

    public static void main(String[] args) {
        int meio = 0;
        //vetor que deve ser ordenado
        int vetor[] = new int[10];

        //variavel que usaremos para guardar o maior valor de cada compração
        int aux;

        //variavel que guarda os numeros no vetor digitados pelo usuario;
        String num, num1 = "", num2 = "", num3 = "";

        //guarda no vetor os numeros digitados pelo usuario
        for (int i = 0; i < 10; i++) {
            num = JOptionPane.showInputDialog("Digite um  numero inteiro: ");
            vetor[i] = Integer.parseInt(num);
        }

        //exibe os numeros digitados peo usuario
        for (int i = 0; i < 10; i++) {
            //JOptionPane.showMessageDialog(null, vetor[i]);
            //System.out.println(vetor[i]);
            num1 += String.valueOf(vetor[i] + ", ");
        }
        JOptionPane.showMessageDialog(null, "Numeros digitados pelo Usuario: " + num1 + ".");

        //ordenação do vetor
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (vetor[i] < vetor[j]) {
                    //aqui acontece a ordenação
                    aux = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }

        //exibe o vetor ordenado
        for (int i = 0; i < 10; i++) {
            num2 += String.valueOf(vetor[i] + ", ");
        }
        JOptionPane.showMessageDialog(null, "Numeros Ordenados de Forma Crescente Pelo Sistema: " + num2 + ".");
        
        //Numero a ser pesquisado
        num3 = JOptionPane.showInputDialog("Digite o número a ser pesquisado: ");
                
        while ((inicial <= fim) && (!encontrado)) {
            meio = (inicial + fim) / 2;
            if(vetor[meio] == Integer.parseInt(num3)){
                encontrado = true;
            }else if (vetor[meio] > Integer.parseInt(num3)){
                fim = meio - 1;
            }else{
                inicial = meio + 1;
            }
        }
        
        //exibe resultado da busca
        if(encontrado == true){
            JOptionPane.showMessageDialog(null,"Numero encontrado na posição: " + meio);
        }else{
            JOptionPane.showMessageDialog(null,"Numero não encontrado no vetor!");
        }
    }
}
