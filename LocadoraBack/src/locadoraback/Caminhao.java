package locadoraback;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Caminhao extends Veiculo{
    private int qtdEixos;
    private int potenciaHP;
    private char tipoCaminhao; // B = Baú  C =  Caçamba

    public Caminhao(int codVeiculo, String marcaVeiculo, String modeloVeiculo, String placaVeiculo, boolean locado) {
        super(codVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo, locado);
    }

    Caminhao() {
    }

    @Override
    public boolean abastecer(String tipoCombustivel, 
                             int    qtdKmRodado, 
                             float  precoCombustivel){

        if ((qtdKmRodado * precoCombustivel) > 0)  {
            System.out.println("Você gastou R$ " + (qtdKmRodado * precoCombustivel) + " de " 
                                + tipoCombustivel + " para rodar " + qtdKmRodado);            
            return true;            
        } else {
                return false;
        }
    }
    
    public boolean incluirCaminhao() throws ClassNotFoundException{
        String sql = "INSERT INTO caminhao ";
               sql+= "(marcaveiculo, modeloveiculo, placaveiculo, locado,potenciaHP, qtdeixos, tipoCaminhao) ";
               sql+= "values (?,?,?,?,?,?,?)";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString (1, this.getMarcaVeiculo());
            stm.setString (2, this.getModeloVeiculo());
            stm.setString (3, this.getPlacaVeiculo());
            stm.setBoolean(4, this.isLocado());
            stm.setInt    (5, this.potenciaHP);
            stm.setInt    (6, this.qtdEixos);
            stm.setString (7, String.valueOf(this.tipoCaminhao)); // stm.setChar(7, this.tipoCaminhao); 
            stm.execute();
        } catch (SQLException error){
            System.out.println("Inclusao do Caminhao com problema\nVerifique" + error);
            return false;
        }
        return true;
    }
    
    public boolean alterarCaminhao() throws ClassNotFoundException{
        String sql = "update caminhao ";
               sql+= "set marcaveiculo  = ?, ";
               sql+= "    modeloveiculo = ?, ";
               sql+= "    placaveiculo  = ?, ";
               sql+= "    locado        = ?, ";
               sql+= "    potenciaHP    = ?, ";
               sql+= "    qtdeixos      = ?, ";
               sql+= "    tipoCaminhao  = ?  ";
               sql+= "where codveiculo  = ?  ";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.getMarcaVeiculo());
            stm.setString(2, this.getModeloVeiculo());
            stm.setString(3, this.getPlacaVeiculo());
            stm.setBoolean(4, this.isLocado());
            stm.setInt(5, this.potenciaHP);
            stm.setInt(6, this.qtdEixos);
            stm.setString(7, String.valueOf(this.tipoCaminhao)); // stm.setChar(7, this.tipoCaminhao);
            stm.setInt(8, this.getCodVeiculo());
            stm.execute();
        } catch (SQLException error){
            System.out.println("Alteracao do caminhao com problema\nVerifique" + error);
            return false;
        }
        return true;
    }
    
    public boolean excluirCaminhao() throws ClassNotFoundException{
        String sql = "delete from Caminhao ";
               sql+= "where codVeiculo = ? ";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.getCodVeiculo());
            stm.execute();
        } catch (SQLException error){
            System.out.println("Exclusao do Caminhao com problema\nVerifique" + error );
            return false;
        }
        return true;
    }
    
    public Caminhao consultarCaminhao() throws ClassNotFoundException{
        String sql = "select * ";
               sql+= "from Caminhao ";
               sql+= "where codVeiculo = ?";
        Connection con = Conexao.conectar();
        Caminhao ca = null;
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.getCodVeiculo());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ca = new Caminhao();
                ca.setModeloVeiculo(rs.getString("modeloVeiculo"));
                ca.setMarcaVeiculo(rs.getString("MarcaVeiculo"));
                ca.setPlacaVeiculo(rs.getString("PlacaVeiculo"));
                ca.setLocado(rs.getBoolean("Locado"));
                ca.setPotenciaHP(rs.getInt("potenciaHP"));
                ca.setQtdEixos(rs.getInt("qtdEixos"));
            }
        } catch (SQLException ex) {
            System.out.println("Problema na consulta de um Caminhao " + ex);
        }
        return ca;
    }
    
     public List<Caminhao> consultarCaminhoes() throws ClassNotFoundException{
        String sql = "select codVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo, locado,potenciaHP, qtdeixos ";
               sql+= "from Caminhao ";
               sql+= "order by codVeiculo";
        Connection con = Conexao.conectar();
        List<Caminhao> listaCaminhao = new ArrayList<>();
        
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Caminhao ca = new Caminhao();
                ca.setCodVeiculo(rs.getInt("codVeiculo"));
                ca.setModeloVeiculo(rs.getString("modeloVeiculo"));
                ca.setMarcaVeiculo(rs.getString("MarcaVeiculo"));
                ca.setPlacaVeiculo(rs.getString("PlacaVeiculo"));
                ca.setLocado(rs.getBoolean("Locado"));
                ca.setPotenciaHP(rs.getInt("potenciaHP"));
                ca.setQtdEixos(rs.getInt("qtdEixos"));
                listaCaminhao.add(ca);
            }
        } catch (SQLException ex) {
            System.out.println("Problema na consulta dos Automoveis " + ex);
        }
        return listaCaminhao;
    }
    
    public void imprimirDadosVeiculo(){
        System.out.println("Codigo..........: " + this.getCodVeiculo());
        System.out.println("Marca...........: " + this.getMarcaVeiculo());
        System.out.println("Modelo..........: " + this.getModeloVeiculo());
        var locado = 'N';
        if (this.isLocado()){
            locado = 'S';
        }
        System.out.println("Locado?(S/N)....: " + locado);
        System.out.println("Potencia .......: " + this.getPotenciaHP() + "HP");
        System.out.println("Qtd.Eixos.......: " + this.getQtdEixos());
    }    
    
    
    public int getQtdEixos() {
        return qtdEixos;
    }

    public void setQtdEixos(int qtdEixos) {
        this.qtdEixos = qtdEixos;
    }

    public int getPotenciaHP() {
        return potenciaHP;
    }

    public void setPotenciaHP(int potenciaHP) {
        this.potenciaHP = potenciaHP;
    }

    public char getTipoCaminhao() {
        return tipoCaminhao;
    }

    public void setTipoCaminhao(char tipoCaminhao) {
        this.tipoCaminhao = tipoCaminhao;
    }
}
