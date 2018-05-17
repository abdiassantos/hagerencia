package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansCliente;
import modeloConnection.ConexaoBD;

public class DaoCliente {
    
    ConexaoBD conex = new ConexaoBD();
    BeansCliente mod = new BeansCliente();
    
    public void Salvar(BeansCliente mod){
        conex.conecta();
        
        try{
            PreparedStatement pst = conex.con.prepareStatement("insert into "
                    + "controlecliente(nomecliente, cpfcliente, telefonecliente, emailcliente, ruacliente, numerocasa,"
                    + "bairrocliente, cidadecliente, estadocliente, cepcliente, complementoendereco)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, mod.getNomeCliente());
            pst.setString(2, mod.getCpfCliente());
            pst.setString(3, mod.getTelefoneCliente());
            pst.setString(4, mod.getEmailCliente());
            pst.setString(5, mod.getRuaCliente());
            pst.setString(6, mod.getNumeroCasa());
            pst.setString(7, mod.getBairroCliente());
            pst.setString(8, mod.getCidadeCliente());
            pst.setString(9, mod.getEstadoCliente());
            pst.setString(10, mod.getCepCliente());
            pst.setString(11, mod.getComplementoEndereco());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar um Novo Cliente: \n" + ex.getMessage());
        }
    }
    
    
    public void EditarCliente(BeansCliente mod){
        
        conex.conecta();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update controlecliente set nomecliente=?,"
                    + "cpfcliente=?, telefonecliente=?, emailcliente=?, ruacliente=?, numerocasa=?, bairrocliente=?, cidadecliente=?, estadocliente=?,"
                    + "cepcliente=?, complementoendereco=? where idcliente=?");
            pst.setString(1, mod.getNomeCliente());
            pst.setString(2, mod.getCpfCliente());
            pst.setString(3, mod.getTelefoneCliente());
            pst.setString(4, mod.getEmailCliente());
            pst.setString(5, mod.getRuaCliente());
            pst.setString(6, mod.getNumeroCasa());
            pst.setString(7, mod.getBairroCliente());
            pst.setString(8, mod.getCidadeCliente());
            pst.setString(9, mod.getEstadoCliente());
            pst.setString(10, mod.getCepCliente());
            pst.setString(11, mod.getComplementoEndereco());
            pst.setInt(12, mod.getIdCliente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os Dados! \nErro: " + ex);

        }
        
    }
    
    public BeansCliente buscaCliente (BeansCliente mod){
        
        conex.conecta();
        conex.executaSql("select *from controlecliente where nomecliente ilike '%" + mod.getPesquisa() + "%'");
        try {
            conex.rs.first();
            mod.setIdCliente(conex.rs.getInt("idcliente"));
            mod.setNomeCliente(conex.rs.getString("nomecliente"));
            mod.setCpfCliente(conex.rs.getString("cpfcliente"));
            mod.setTelefoneCliente(conex.rs.getString("telefonecliente"));
            mod.setEmailCliente(conex.rs.getString("emailcliente"));
            mod.setRuaCliente(conex.rs.getString("ruacliente"));
            mod.setNumeroCasa(conex.rs.getString("numerocasa"));
            mod.setBairroCliente(conex.rs.getString("bairrocliente"));
            mod.setCidadeCliente(conex.rs.getString("cidadecliente"));
            mod.setEstadoCliente(conex.rs.getString("estadocliente"));
            mod.setCepCliente(conex.rs.getString("cepcliente"));
            mod.setComplementoEndereco(conex.rs.getString("complementoendereco"));
            mod.setValorAtual(conex.rs.getDouble("valoratual"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente: \n" + ex.getMessage());
        }
        
        conex.desconecta();
        return mod;
        
    }
    
    public void excluirCliente(BeansCliente mod){
        conex.conecta();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from controlecliente where idcliente=?");
            pst.setInt(1, mod.getIdCliente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados do cliente Excluídos com Sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir os Dados do cliente! \nErro: " + ex);
        }
        
        conex.desconecta();
    }
    
    public void AtualizaValorAtual(BeansCliente mod){
        conex.conecta();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update controlecliente set valoratual=?"
                    + " where idcliente=?");
            pst.setDouble(1, mod.getValorAtual());
            pst.setInt(2, mod.getIdCliente());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Valor Atual Atualizado com Sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os valores atuais! \nErro: " + ex);

        }
    }
    
}
