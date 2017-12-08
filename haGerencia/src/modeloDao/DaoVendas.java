package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansVendas;
import modeloConnection.ConexaoBD;

public class DaoVendas {
    
    ConexaoBD conex = new ConexaoBD();
    BeansVendas mod = new BeansVendas();
    
    public void Salvar(BeansVendas mod){
        conex.conecta();
        final String sql= "insert into controlevendas(idcliente, idproduto, datavenda) values(?,?,?)";
        
        try {
            PreparedStatement pst = conex.con.prepareStatement(sql);
            pst.setInt(1, mod.getIdCliente());
            pst.setInt(2, mod.getIdProduto());
            pst.setDate(3, mod.getDataVenda());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Venda Cadastrada com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar as Informações da Venda!" + ex);
        }
        
    }
    
    public BeansVendas buscaVenda(BeansVendas mod){
        final String sql = "select idvenda, idcliente, idproduto, nomecliente, nomeproduto, datavenda "
                + "from controlevendas "
                + "inner join controlecliente on controlecliente.idcliente = controlevendas.idcliente "
                + "inner join estoqueproduto on controlevendas.idproduto = estoqueproduto.idproduto "
                + "where nomecliente ilike '%" + mod.getPesquisaVenda()+ "%'" ;
        conex.conecta();
        conex.executaSql(sql);
        
        try {
            conex.rs.first();
            mod.setIdVenda(conex.rs.getInt("idvenda"));
            mod.setIdCliente(conex.rs.getInt("idcliente"));
            mod.setNomeCliente(conex.rs.getString("nomecliente"));
            mod.setIdProduto(conex.rs.getInt("idproduto"));
            mod.setNomeProduto(conex.rs.getString("nomeproduto"));
            mod.setDataVenda(conex.rs.getDate("datavenda"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente: \n" + ex.getMessage());
        }
        
        conex.desconecta();
        return mod;
    }
    
}
