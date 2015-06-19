
package br.com.sistemaceet;

import br.com.sistemaceet.tela.TelaAluno;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;

/**
 *
 * @author alunon
 */
public class Aluno {
    
    private int matricula;
    private String nome;
    private String Endereço;
    private int idade;
    private ObjectOutputStream output;
    private String fileName;
    private Reader arq;
    

   //Metodos Get e Set
    /**
     * 
     */
   

    public String toString() {
        return   matricula + "\t" + nome + "\t"  + Endereço + "\t" + idade;
        
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public void criarArquivoAluno() throws IOException {
  
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
  
       String[] campo = {"","","",""};
       
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
    
    public void enviarMensagem(String msg) throws IOException{
            
       String mensagem="";
       
      
       try (Socket connection = new Socket ("127.0.0.1", 12345)) {
            ObjectOutputStream saida = new ObjectOutputStream(connection.getOutputStream());
            
            mensagem = "Cliente: " + msg;
            saida.writeObject(mensagem);
            saida.flush();
            
            
            saida.close();
        }
                    
        }
    }
 

    