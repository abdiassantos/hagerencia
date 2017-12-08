package modeloConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {
    
    //CONEXÃO COM O BANCO DE DADOS POSTGRESQL
    //VARIÁVEIS DE CONEXÃO COM O BANCO
    public Statement stm;   //responsável pelas pesquisas;
    public ResultSet rs;    //responsável por armazenar os resultados das pesquisas;
    public Connection con;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/hagerencia";
    private String usuario = "abdiassantos";
    private String senha = "abdiasnivea";
    
    
    //CONECTA AO BANCO DE DADOS;
    public void conecta(){
        
        
        try {
            System.setProperty("jdbc:Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão Realizada com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se Conectar ao Banco de Dados: \n" + ex.getMessage());
        }
    }
    
    
    //EXECUTA SQL PARA O BANCO DE DADOS;
    public void executaSql(String sql){
        
        try{
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ExecutaSql: \n" + ex.getMessage());
        }
    }
    
    
    //DESCONECTA BANCO DE DADOS
    public void desconecta(){
        
        try{
            con.close();
            //JOptionPane.showMessageDialog(null, "Banco de Dados Desconectado com Sucesso!");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao se Desconectar do Banco de Dados: \n" + ex.getMessage());
        }
    }
}
