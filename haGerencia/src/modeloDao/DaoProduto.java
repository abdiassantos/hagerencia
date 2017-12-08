package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansProduto;
import modeloConnection.ConexaoBD;

public class DaoProduto {
    
    ConexaoBD conex = new ConexaoBD();
    BeansProduto mod = new BeansProduto();
    
    public void SalvarProduto(BeansProduto mod){
        conex.conecta();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into "
                    + "estoqueproduto(nomeproduto, tamanhoproduto, valorproduto, quantidadeproduto, descricaoproduto)"
                    + "values(?, ?, ?, ?, ?)");
            
            pst.setString(1, mod.getNomeProduto());
            pst.setString(2, mod.getTamanhoProduto());
            pst.setDouble(3, mod.getValorProduto());
            pst.setInt(4, mod.getQuantidadeProduto());
            pst.setString(5, mod.getDescricaoProduto());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar um novo produto! \nErro: " + ex);
        }
    }
    
    public void EditarProduto(BeansProduto mod){
        conex.conecta();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("update estoqueproduto set nomeproduto=?,"
                    + "tamanhoproduto=?, valorproduto=?, quantidadeproduto=?, descricaoproduto=?"
                    + "where idproduto=?");
            
            pst.setString(1, mod.getNomeProduto());
            pst.setString(2, mod.getTamanhoProduto());
            pst.setDouble(3, mod.getValorProduto());
            pst.setInt(4, mod.getQuantidadeProduto());
            pst.setString(5, mod.getDescricaoProduto());
            pst.setInt(6, mod.getIdProduto());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados do produto alterados com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar os dados do produto \nErro: " + ex);
        }
    }
    
    public BeansProduto BuscaProduto(BeansProduto mod){
        conex.conecta();
        conex.executaSql("select *from estoqueproduto where nomeproduto ilike '%" + mod.getPesquisaProduto() + "%'");
        
        try {
            conex.rs.first();
            mod.setIdProduto(conex.rs.getInt("idproduto"));
            mod.setNomeProduto(conex.rs.getString("nomeproduto"));
            mod.setTamanhoProduto(conex.rs.getString("tamanhoproduto"));
            mod.setValorProduto(conex.rs.getDouble("valorproduto"));
            mod.setQuantidadeProduto(conex.rs.getInt("quantidadeproduto"));
            mod.setDescricaoProduto(conex.rs.getString("descricaoproduto"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pelo produto! \n Erro: " + ex);
        }
        
        conex.desconecta();
        return mod;
    }
    
    public void ExcluirProduto(BeansProduto mod){
        conex.conecta();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from estoqueproduto where idproduto=?");
            
            pst.setInt(1, mod.getIdProduto());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados do produto excluídos com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir os dados do produto! \nErro: " + ex);
        }
        conex.desconecta();
    }
    
    public void atualizaQuantidadeProduto(BeansProduto mod){
                conex.conecta();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update estoqueproduto set quantidadeproduto=?"
                    + " where idproduto=?");
            pst.setInt(1, mod.getQuantidadeProduto());
            pst.setInt(2, mod.getIdProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Valor Atual Atualizado com Sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os valores atuais! \nErro: " + ex);

        }
    }
    
}
