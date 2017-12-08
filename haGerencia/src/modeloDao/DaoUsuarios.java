package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansCliente;
import modeloBeans.BeansUsuarioLogin;
import modeloConnection.ConexaoBD;

public class DaoUsuarios {
    ConexaoBD conex = new ConexaoBD();
    BeansUsuarioLogin mod = new BeansUsuarioLogin();
    
    public void SalvarUsuario(BeansUsuarioLogin mod){
        conex.conecta();
        
        try{
            PreparedStatement pst = conex.con.prepareStatement("insert into controleusuarioslogin(nomeusuario, senhausuario, emailusuario) "
                    + "values(?, ?, ?)");
            
            pst.setString(1, mod.getUsuarioLogin());
            pst.setString(2, mod.getSenhaLogin());
            pst.setString(3, mod.getEmailLogin());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar um Novo Usuário: \n" + ex.getMessage());
        }
    }
}
