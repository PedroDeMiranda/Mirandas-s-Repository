package locadoraback;

import Util.Conexao;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int    codCliente;
    private String nomeCliente;
    private String email;
    private String foneCel;

    public boolean incluirCliente() throws ClassNotFoundException{
        String sql = "insert into cliente ";
               sql+= "(nomcliente,email,fonecel) ";
               sql+= "values (?,?,?)";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nomeCliente);
            stm.setString(2, this.email);
            stm.setString(3, this.foneCel);
            stm.execute();
        } catch (SQLException error){
            System.out.println("Inclusao do cliente com problema\n, Verifique");
            return false;
        }
        return true;
    }
    
    public boolean alterarCliente() throws ClassNotFoundException{
        String sql = "update cliente ";
               sql+= "set nomcliente = ?,  ";
               sql+= "    email      = ?,  ";
               sql+= "    fonecel    = ?   ";
               sql+= "where codcliente = ? ";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nomeCliente);
            stm.setString(2, this.email);
            stm.setString(3, this.foneCel);
            stm.setInt(4, this.codCliente);
            stm.execute();
        } catch (SQLException error){
            System.out.println("Alteracao do cliente com problema\n, Verifique");
            return false;
        }
        return true;
    }
     public boolean excluirCliente() throws ClassNotFoundException{
        String sql = "delete from cliente ";
               sql+= "where codcliente = ? ";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.codCliente);
            stm.execute();
        } catch (SQLException error){
            System.out.println("Exclusao do cliente com problema\n, Verifique");
            return false;
        }
        return true;
    }
    
    public Cliente consultarCliente() throws ClassNotFoundException{
        String sql = "select nomcliente,email,fonecel ";
               sql+= "from cliente ";
               sql+= "where codcliente = ?";
        Connection con = Conexao.conectar();
        Cliente cli = null;
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.codCliente);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                cli = new Cliente();
                cli.setNomeCliente(rs.getString("nomcliente"));
                cli.setEmail(rs.getString("email"));
                cli.setFoneCel(rs.getString("fonecel"));
            }
        } catch (SQLException ex) {
            System.out.println("Problema na consulta de um cliente " + ex);
        }
        return cli;
    }
    
     public List<Cliente> consultarClienteS() throws ClassNotFoundException{
        String sql = "select codcliente,nomcliente,email,fonecel ";
               sql+= "from cliente ";
               sql+= "order by 2 desc";
        Connection con = Conexao.conectar();
        List<Cliente> listacliente = new ArrayList<>();
        
        try{
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setCodCliente(rs.getInt("codcliente"));
                cli.setNomeCliente(rs.getString("nomcliente"));
                cli.setEmail(rs.getString("email"));
                cli.setFoneCel(rs.getString("fonecel"));
                listacliente.add(cli);
            }
        } catch (SQLException ex) {
            System.out.println("Problema na consulta dos clientse " + ex);
        }
        return listacliente;
    }
    
    public double reajustarSalario(double pSalario, double pPercAumento){
        double salarioNovo = 0;
        salarioNovo = pSalario * ((pPercAumento/100) + 1);
        return salarioNovo;
    }
    
    @Override
    public String toString() {
        return "Cliente : " + codCliente + 
               "\nNome    : " + nomeCliente + 
               "\nemail   : " + email + 
               "\nfone    : " + foneCel;
    }

// area de getters e setters
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneCel() {
        return foneCel;
    }

    public void setFoneCel(String foneCel) {
        this.foneCel = foneCel;
    }
   

}
