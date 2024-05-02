package locadoraback;

import Util.Conexao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LocadoraBack {
    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        //instanciar classes
        Scanner sc     = new Scanner(System.in);
        Connection con = Conexao.conectar();
        Cliente cli    = new Cliente();
        Automovel au   = new Automovel();
        Caminhao ca    = new Caminhao();
                
        
        System.out.println("\nQuer consultar\n"
                         + "Cliente...: 1\n"
                         + "Automovel.: 2\n"
                         + "Caminhao..: 3");
        int opcaoClasse = sc.nextInt();
        if (opcaoClasse == 3) {
            
            
        System.out.println("Menu\n"
                         + "Inserir Caminhao .....: 1\n"
                         + "Alterar um Caminhao ..: 2\n"
                         + "Deletar Caminhao .....: 3\n"
                         + "Consultar Caminhoes ..: 4\n"
                         + "Consultar um Caminhao : 5");
        int opcao = sc.nextInt();
        //escolhas
        switch (opcao) {
            case 1:
        //inserir caminhao !
        System.out.println("Informe marca do Caminhao");
            ca.setMarcaVeiculo(sc.next());
        System.out.println("Informe modelo do Caminhao");
            ca.setModeloVeiculo(sc.next());
        System.out.println("Informe placa do Caminhao");
            ca.setPlacaVeiculo(sc.next());
        System.out.println("Informe locacao do Caminhao");
            ca.setLocado(sc.nextBoolean());
        System.out.println("Informe potencia do Caminhao");
            ca.setPotenciaHP(sc.nextInt());
        System.out.println("Informe quantidade de eixos do Caminhao");
            ca.setQtdEixos(sc.nextInt());
        System.out.println("Informe o Tipo do Caminhao ( B = Bau  C = Caçamba)");
            ca.setTipoCaminhao(sc.next().charAt(0));
            
            if (ca.incluirCaminhao()){
            System.out.println("Caminhao incluido com sucesso");
        } else {
            System.out.println("Deu problema na inclusao do Caminhao");
        }              
                break;
            case 2:
                
        // alterar Caminhao
        System.out.println("Informe o codigo do Caminhao a ser alterado");
            ca.setCodVeiculo(sc.nextInt());
        System.out.println("Informe marca do Caminhao");
            ca.setMarcaVeiculo(sc.next());
        System.out.println("Informe modelo do Caminhao");
            ca.setModeloVeiculo(sc.next());
        System.out.println("Informe placa do Caminhao");
            ca.setPlacaVeiculo(sc.next());
        System.out.println("Informe locacao do Caminhao");
            ca.setLocado(sc.nextBoolean());
        System.out.println("Informe potencia do Caminhao");
            ca.setPotenciaHP(sc.nextInt());
        System.out.println("Informe quantidade de eixos do Caminhao");
            ca.setQtdEixos(sc.nextInt());
        System.out.println("Informe o Tipo do Caminhao ( B = Bau  C = Caçamba)");
            ca.setTipoCaminhao(sc.next().charAt(0));
            
        if (ca.alterarCaminhao()){
            System.out.println("Caminhao alterado com sucesso");
        } else {
            System.out.println("Deu problema na alteracao do Caminhao");
        }
                break;
                
            case 3:
        // excluir Caminhao
        System.out.println("Informe o codigo do Caminhao a ser excluido");  
        ca.setCodVeiculo(sc.nextInt());
        if (ca.excluirCaminhao()){
            System.out.println("Caminhao excluido com sucesso");
        } else {
            System.out.println("Deu problema para excluir o Caminhao");
        }
        
                break;
            case 4:
        List<Caminhao> listarAutomoveis = new ArrayList<>();
        listarAutomoveis = ca.consultarCaminhoes();
        if (listarAutomoveis != null) {
            System.out.println("Codigo " + "\t" + "Modelo "    + "\t" + 
                               "Placa  " + "\t" + "Marca "     + "\t" + 
                               "Locado " + "\t" + "PotenciaHP "+ "\t" + 
                               "Eixos  " + "\t" + "tipoCaminhao "
            );
        }
        
        for (Caminhao l : listarAutomoveis) {
           System.out.println(l.getCodVeiculo()           + "\t" + 
                              l.getModeloVeiculo()        + "\t" + 
                              l.getPlacaVeiculo()         + "\t" + 
                              l.getMarcaVeiculo()         + "\t" + 
                             (l.isLocado()? "Sim": "Nao") + "\t" + 
                              l.getPotenciaHP()           + "\t" + 
                              l.getQtdEixos());
          
        }        
                break;
            case 5:
                System.out.println("Informe o codigo do Caminhao");
                ca.setCodVeiculo(sc.nextInt());

        Caminhao ca2 = ca.consultarCaminhao();
        if (ca2 == null) {
            System.out.println("Não localizei o Caminhao");
        } else {
            System.out.println("Codigo.....:" + ca.getCodVeiculo());
            System.out.println("Modelo.....:" + ca2.getModeloVeiculo());
            System.out.println("Marca......:" + ca2.getMarcaVeiculo());
            System.out.println("Placa......:" + ca2.getPlacaVeiculo());
            System.out.println("Locado.....:" + (ca2.isLocado()? "Sim": "Nao"));
            System.out.println("PotenciaHP.:" + ca2.getPotenciaHP());
            System.out.println("Eixos......:" + ca2.getQtdEixos());
        }
                break;
            default:
                throw new AssertionError();
        }    
            
            
            
        } else if (opcaoClasse == 2) {
            
        System.out.println("Menu\n"
                         + "Inserir Automovel .....: 1\n"
                         + "Alterar um Automovel ..: 2\n"
                         + "Delete Automovel ......: 3\n"
                         + "Consultar Automoveis ..: 4\n"
                         + "Consultar um Automovel : 5");
        int opcao = sc.nextInt();
        //escolhas
        switch (opcao) {
            case 1:
        //inserir automovel !
        System.out.println("Informe marca do Automovel");
            au.setMarcaVeiculo(sc.next());
        System.out.println("Informe modelo do Automovel");
            au.setModeloVeiculo(sc.next());
        System.out.println("Informe placa do Automovel");
            au.setPlacaVeiculo(sc.next());
        System.out.println("Informe locacao do Automovel");
            au.setLocado(sc.nextBoolean());
        System.out.println("Informe potencia do Automovel");
            au.setPotenciaHP(sc.nextInt());
        System.out.println("Informe quantidade de passageiros do Automovel");
            au.setQtdPassageiros(sc.nextInt());
            
            if (au.incluirAutomovel()){
            System.out.println("Automovel incluido com sucesso");
        } else {
            System.out.println("Deu problema na inclusao do Automovel");
        }
                break;
            case 2:
                
        // alterar Automovel
        System.out.println("Informe o codigo do Automovel a ser alterado");
            au.setCodVeiculo(sc.nextInt());
        System.out.println("Informe marca do Automovel");
            au.setMarcaVeiculo(sc.next());
        System.out.println("Informe modelo do Automovel");
            au.setModeloVeiculo(sc.next());
        System.out.println("Informe placa do Automovel");
            au.setPlacaVeiculo(sc.next());
        System.out.println("Informe locacao do Automovel");
            au.setLocado(sc.nextBoolean());
        System.out.println("Informe potencia do Automovel");
            au.setPotenciaHP(sc.nextInt());
        System.out.println("Informe quantidade de passageiros do Automovel");
            au.setQtdPassageiros(sc.nextInt());
        if (au.alterarAutomovel()){
            System.out.println("Automovel alterado com sucesso");
        } else {
            System.out.println("Deu problema na alteracao do Automovel");
        }
                break;
                
            case 3:
        // excluir Automovel
        System.out.println("Informe o codigo do Automovel a ser excluido");  
        au.setCodVeiculo(sc.nextInt());
        if (au.excluirAutomovel()){
            System.out.println("Automovel excluido com sucesso");
        } else {
            System.out.println("Deu problema para excluir o Automovel");
        }
                break;
            case 4:
        List<Automovel> listarAutomoveis = new ArrayList<>();
        listarAutomoveis = au.consultarAutomoveis();
        if (listarAutomoveis != null) {
            System.out.println("Codigo " + "\t" + "Modelo "    + "\t" + 
                               "Placa  " + "\t" + "Marca "     + "\t" + 
                               "Locado " + "\t" + "PotenciaHP "+ "\t" + 
                               "Passageiros"
            );
        }
        
        for (Automovel l : listarAutomoveis) {
           System.out.println(l.getCodVeiculo()           + "\t" + 
                              l.getModeloVeiculo()        + "\t" + 
                              l.getPlacaVeiculo()         + "\t" + 
                              l.getMarcaVeiculo()         + "\t" + 
                             (l.isLocado()? "Sim": "Nao") + "\t" + 
                              l.getPotenciaHP()           + "\t" + 
                              l.getQtdPassageiros());
          
        }        
                break;
            case 5:
                System.out.println("Informe o codigo do Automovel");
                au.setCodVeiculo(sc.nextInt());

        Automovel au2 = au.consultarAutomovel();
        if (au2 == null) {
            System.out.println("Não localizei o Automovel");
        } else {
            System.out.println("Codigo......:" + au.getCodVeiculo());
            System.out.println("Modelo .....:" + au2.getModeloVeiculo());
            System.out.println("Marca.......:" + au2.getMarcaVeiculo());
            System.out.println("Placa.......:" + au2.getPlacaVeiculo());
            System.out.println("Locado......:" + (au2.isLocado()? "Sim": "Nao"));
            System.out.println("PotenciaHP..:" + au2.getPotenciaHP());
            System.out.println("Passageiros.:" + au2.getQtdPassageiros());
        }
                break;
            default:
                throw new AssertionError();
        }
            
        } else {
        
        
        //menu para escolher ação
        System.out.println("Menu\n"
                         + "Inserir Cliente .....: 1\n"
                         + "Alterar um Cliente ..: 2\n"
                         + "Delete Cliente ......: 3\n"
                         + "Consultar Clientes ..: 4\n"
                         + "Consultar um Cliente : 5");
        int opcao = sc.nextInt();
        //escolhas
        switch (opcao) {
            case 1:
        //inseri Cliente       
        System.out.println("Informe Nome do Cliente");
        cli.setNomeCliente(sc.next());
        System.out.println("Informe email do Cliente");
        cli.setEmail(sc.next());
        System.out.println("Informe numero do Cliente");
        cli.setFoneCel(sc.next());
        if (cli.incluirCliente()){
            System.out.println("Cliente incluido com sucesso");
        } else {
            System.out.println("Deu problema na inclusao do Cliente");
        }
                break;
            case 2:
                
        // alterar Cliente OK !
        System.out.println("Informe o codigo do Cliente a ser alterado");
            cli.setCodCliente(sc.nextInt());
        System.out.println("Informe o nome do Cliente a ser alterado");
            cli.setNomeCliente(sc.next());
        System.out.println("Informe o email do Cliente a ser alterado");    
            cli.setEmail(sc.next());
        System.out.println("Informe o celular do Cliente a ser alterado");    
            cli.setFoneCel(sc.next());
        if (cli.alterarCliente()){
            System.out.println("Cliente alterado com sucesso");
        } else {
            System.out.println("Deu problema na alteracao do Cliente");
        }
                break;
                
            case 3:
        // excluir Cliente
        System.out.println("Informe o codigo do Cliente a ser excluido");  
        cli.setCodCliente(sc.nextInt());
        if (cli.excluirCliente()){
            System.out.println("Cliente excluido com sucesso");
        } else {
            System.out.println("Deu problema para excluir o Cliente");
        }
                break;
            case 4:
        List<Cliente> listarClientes = new ArrayList<>();
        listarClientes = cli.consultarClienteS();
        if (listarClientes != null) {
            System.out.println("Codigo" +  "\t" + "Nome            " + "\t" + 
                               "Email " + "\t"+ "Fone");
        }
        
        for (Cliente l : listarClientes) {
           System.out.println(l.getCodCliente() + "\t" + 
                              l.getNomeCliente() + "\t" + 
                              l.getEmail()      + "\t" + 
                              l.getFoneCel());  
        }        
                break;
            case 5:
                System.out.println("Informe o codigo do Cliente");
                cli.setCodCliente(sc.nextInt());

        Cliente cli2 = cli.consultarCliente();
        if (cli2 == null) {
            System.out.println("Não localizei o Cliente");
        } else {
            System.out.println("Codigo....:" + cli.getCodCliente());
            System.out.println("Nome .....:" + cli2.getNomeCliente());
            System.out.println("Email.....:" + cli2.getEmail());
            System.out.println("FoneCel...:" + cli2.getFoneCel());
        }
                break;
            default:
                throw new AssertionError();
        }
       
        }
     
        
    }
    }