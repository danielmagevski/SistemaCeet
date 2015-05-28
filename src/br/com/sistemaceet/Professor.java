
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

/**
 *
 * @author alunon
 */
public class Professor {
    private int codigoDoProfessor;
    private String nome;
    private String especialidade;
    private ObjectOutputStream output;

    /**
     * @return the codigoDoProfessor
     */
    
    
    public String toString() {
        return codigoDoProfessor + "\t" + nome + "\t" + especialidade; 
        
    }
    public int getCodigoDoProfessor() {
        return codigoDoProfessor;
    }

    /**
     * @param codigoDoProfessor the codigoDoProfessor to set
     */
    public void setCodigoDoProfessor(int codigoDoProfessor) {
        this.codigoDoProfessor = codigoDoProfessor;
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

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
    public void criarArquivoProfessor() throws IOException 
    
   {
  
        try {           
        
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        // abre a janela para salvar o arquivo...        
        int result = filechooser.showSaveDialog(filechooser);
        
        // recupera o diretório onde será gravado o arquivo...        
        File fileName = filechooser.getSelectedFile();
        
        // grava oa arquivo..        
        output = new ObjectOutputStream(new FileOutputStream(fileName));
        
        FileWriter arq = new FileWriter(fileName);
        PrintWriter gravar = new PrintWriter(arq);
        gravar.print(this);        
        
        arq.close();
        
        
        } catch (Exception e) {
            e.getMessage();
        }
   


}

public String[] lerArquivo() throws IOException {
        // Com array, isso define a posição
       String[] campo = {"","",""};
       
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        // abre a janela para salvar o arquivo...        
        int result = filechooser.showSaveDialog(filechooser);
        
        // recupera o diretório onde será gravado o arquivo...        
        File fileName = filechooser.getSelectedFile();
        //Ler o arq, vai no arq, ler e dps mostra na váriavel linha
        FileReader arq = new FileReader(fileName);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha = lerArq.readLine();
        
        //Irá quebrar o arq em "\t"
        campo = linha.split("\t");
                        
        arq.close();
        
        return campo;
}
}

        
        
    
      
        
            
