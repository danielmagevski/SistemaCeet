/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sistemaceet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import javax.swing.JFileChooser;




        
public class Disciplina {
    private int codigo;
    private String nome;
    
    
    public String toString() {
        return  codigo + "\t" + nome;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
     public void criarArquivoDisciplina() throws IOException {
  
        try {           
        
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        // abre a janela para salvar o arquivo...        
        int result = filechooser.showSaveDialog(filechooser);
        
        // recupera o diretório onde será gravado o arquivo...        
        File fileName = filechooser.getSelectedFile();
        
            // grava oa arquivo..
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
        
        FileWriter arq = new FileWriter(fileName);
        PrintWriter gravar = new PrintWriter(arq);
        gravar.print(this);        
        arq.close();
        
        } catch (Exception e) {
            e.getMessage();
        }
     }
    
     public String[] lerArquivo() throws IOException {
  
       
        String[] campo = {"",""};
       
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        // abre a janela para salvar o arquivo...        
        int result = filechooser.showSaveDialog(filechooser);
        
        // recupera o diretório onde será gravado o arquivo...        
        File fileName = filechooser.getSelectedFile();
        
        FileReader arq = new FileReader(fileName);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        
        campo = linha.split("\t");
                        
        arq.close();
        
        return campo;
     }
}