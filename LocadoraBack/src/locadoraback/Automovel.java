package locadoraback;

import Util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Automovel extends Veiculo {
    private int potenciaHP;
    private int qtdPassageiros;

    public Automovel(int codVeiculo, String marcaVeiculo, String modeloVeiculo, String placaVeiculo, boolean locado) {
        super(codVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo, locado);
    }

    Automovel() {
    }

    public boolean incluirAutomovel() throws ClassNotFoundException{
        String sql = "INSERT INTO automovel ";
               sql+= "(marcaveiculo, modeloveiculo, placaveiculo, locado,potenciaHP, qtdpassageiros) ";
               sql+= "values (?,?,?,?,?,?)";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.getMarcaVeiculo());
            stm.setString(2, this.getModeloVeiculo());
            stm.setString(3, this.getPlacaVeiculo());
            stm.setBoolean(4, this.isLocado());
            stm.setInt(5, this.potenciaHP);
            stm.setInt(6, this.qtdPassageiros);
            stm.execute();
        } catch (SQLException error){
            System.out.println("Inclusao do Automovel com problema\nVerifique" + error);
            return false;
        }
        return true;
    }
    
    public boolean alterarAutomovel() throws ClassNotFoundException{
        String sql = "update automovel ";
               sql+= "set marcaveiculo = ?,  ";
               sql+= "    modeloveiculo      = ?,  ";
               sql+= "    placaveiculo    = ?, ";
               sql+= "    locado    = ?, ";
               sql+= "    potenciaHP    = ?, ";
               sql+= "    qtdpassageiros    = ? ";
               sql+= "where codveiculo = ? ";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.getMarcaVeiculo());
            stm.setString(2, this.getModeloVeiculo());
            stm.setString(3, this.getPlacaVeiculo());
            stm.setBoolean(4, this.isLocado());
            stm.setInt(5, this.potenciaHP);
            stm.setInt(6, this.qtdPassageiros);
            stm.setInt(7, this.getCodVeiculo());
            stm.execute();
        } catch (SQLException error){
            System.out.println("Alteracao do automovel com problema\nVerifique" + error);
            return false;
        }
        return true;
    }
    
    public boolean excluirAutomovel() throws ClassNotFoundException{
        String sql = "delete from Automovel ";
               sql+= "where codVeiculo = ? ";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.getCodVeiculo());
            stm.execute();
        } catch (SQLException error){
            System.out.println("Exclusao do Automovel com problema\nVerifique" + error );
            return false;
        }
        return true;
    }
    
    public Automovel consultarAutomovel() throws ClassNotFoundException{
        String sql = "select * ";
               sql+= "from Automovel ";
               sql+= "where codVeiculo = ?";
        Connection con = Conexao.conectar();
        Automovel au = null;
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.getCodVeiculo());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                au = new Automovel();
                au.setModeloVeiculo(rs.getString("modeloVeiculo"));
                au.setMarcaVeiculo(rs.getString("MarcaVeiculo"));
                au.setPlacaVeiculo(rs.getString("PlacaVeiculo"));
                au.setLocado(rs.getBoolean("Locado"));
                au.setPotenciaHP(rs.getInt("potenciaHP"));
                au.setQtdPassageiros(rs.getInt("qtdPassageiros"));
            }
        } catch (SQLException ex) {
            System.out.println("Problema na consulta de um Automovel " + ex);
        }
        return au;
    }
    
     public List<Automovel> consultarAutomoveis() throws ClassNotFoundException{
        String sql = "select codVeiculo, marcaVeiculo, modeloVeiculo, placaVeiculo, locado,potenciaHP, qtdpassageiros ";
               sql+= "from Automovel ";
               sql+= "order by codVeiculo";
        Connection con = Conexao.conectar();
        List<Automovel> listaAutomovel = new ArrayList<>();
        
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Automovel au = new Automovel();
                au.setCodVeiculo(rs.getInt("codVeiculo"));
                au.setModeloVeiculo(rs.getString("modeloVeiculo"));
                au.setMarcaVeiculo(rs.getString("MarcaVeiculo"));
                au.setPlacaVeiculo(rs.getString("PlacaVeiculo"));
                au.setLocado(rs.getBoolean("Locado"));
                au.setPotenciaHP(rs.getInt("potenciaHP"));
                au.setQtdPassageiros(rs.getInt("qtdPassageiros"));
                listaAutomovel.add(au);
            }
        } catch (SQLException ex) {
            System.out.println("Problema na consulta dos Automoveis " + ex);
        }
        return listaAutomovel;
    }
    
    @Override
    public boolean abastecer(String tipoCombustivel, 
                             int    qtdCombustivel, 
                             float  precoCombustivel){

        if ((qtdCombustivel * precoCombustivel) > 0)  {
            System.out.println("O valor total abastecido de " + tipoCombustivel + " foi : " + (qtdCombustivel * precoCombustivel));            
            return true;            
        } else {
                return false;
        }

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
        System.out.println("Qtd.Passageiros.: " + this.getQtdPassageiros());
        
    }
    

    public int getPotenciaHP() {
        return potenciaHP;
    }

    public void setPotenciaHP(int potenciaHP) {
        this.potenciaHP = potenciaHP;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }
}
