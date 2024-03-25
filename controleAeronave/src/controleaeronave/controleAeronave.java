package controleaeronave;
import java.util.Scanner;
public class controleAeronave {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//numero de Lugares 
        int numeroDeLugares = 12;
//reserva de lugares
        boolean[] ocupacaoLugares = new boolean[numeroDeLugares];
//armazenar os lugares com false(livres)
        for (int i = 0; i < numeroDeLugares; i++) {
            ocupacaoLugares[i] = false;
        }
//laço de repetição infinito até o usuário apertar 4  
        while (true) {
    //menu de opções
            System.out.println("\nMENU:");
            System.out.println("1 = Verificar reservas");
            System.out.println("2 = Reservar lugar");
            System.out.println("3 = Mostrar percentual de lugares");
            System.out.println("4 = Sair");
    //armazena a escolha
            System.out.print("Escolha : ");
            int escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    verificarReserva(ocupacaoLugares);

break;
                case 2:
                    fazerReserva(ocupacaoLugares);
                    break;
                case 3:
                    mostrarPercentual(ocupacaoLugares);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Inválido, escolha outra opção");
            }
        }
    }

    private static void verificarReserva(boolean[] ocupacaoLugares) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Verificar --> \nAssentos Livres - 1 \nAssentos Reservados - 2 \nTodos Assentos - 3");
        int escolha = scanner.nextInt();
        switch (escolha) {
            case 1:
                int j = 1;
                System.out.println("Assentos livres: ");
               for (int i = 0; i < ocupacaoLugares.length; i++) {
                if(ocupacaoLugares[i] == false){
                    System.out.println("Poltrona: "+(i+1));
                    j++;
                }
            }
               if (j == 1) {
                        System.out.println("Assentos todos ocupados");
                    }
                break;
            case 2:
                int o = 1;
                System.out.println("Assentos ocupados: ");
                for (int i = 0; i < ocupacaoLugares.length; i++) {
                if(ocupacaoLugares[i] == true){
                    System.out.println("Poltrona: "+(i+1));
                    o++;
            }
        }
                if (o == 1) {
                        System.out.println("Assentos todos livres");
                    }
                break;
            case 3:
                System.out.println("\nOcupação de lugares:");
        //i vai ser a primeria coluna
        for (int i = 0; i < 6; i++) {
            //y vai ser a segunda coluna
            int y = i+6;
        //Listar os lugares reservados e livres
            System.out.println("Poltrona "+(i+1)+":  " + (ocupacaoLugares[i] ? "Reservado   " : "Livre       ")
                              +"Poltrona "+(y+1)+":  " + (ocupacaoLugares[y] ? "Reservado" : "Livre"));
        }
                break;
            default:
                throw new AssertionError();
        }
    }
//fazer as reservas
    private static void fazerReserva(boolean[] ocupacaoLugares) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe o número do lugar a ser reservado : ");
        int numeroLugar = scanner.nextInt();
//verifica se o lugar esta reservado
        if (numeroLugar >= 1 && numeroLugar <= ocupacaoLugares.length) {
            if (!ocupacaoLugares[numeroLugar - 1]) {
                ocupacaoLugares[numeroLugar - 1] = true;
                System.out.println("Reserva feita com sucesso para o lugar " + numeroLugar
                                  +"\nRealize o pagamento -->");
                                    realizarPagamento(numeroLugar);
            } else {
                System.out.println("Lugar " + numeroLugar + " já reservado, escolha outro");
            }
        } else {
            System.out.println("Número de lugar inválido. Tente novamente.");
        }
    }
//Mostrar o percentual de lugares reservados e livres
    private static void mostrarPercentual(boolean[] ocupacaoLugares) {
        int lugaresReservados = 0;

        for (boolean reservado : ocupacaoLugares) {
            if (reservado) {
                lugaresReservados++;
            }
        }
    //calculos da porcentagem
        int lugaresLivres = ocupacaoLugares.length - lugaresReservados;

        double percentualReservados = (double) lugaresReservados / ocupacaoLugares.length * 100;
        double percentualLivres = (double) lugaresLivres / ocupacaoLugares.length * 100;
    //printf com %.0f para tirar numeros pos vírgulas
        System.out.printf("\nPercentual de lugares reservados : %.0f " , percentualReservados);
        System.out.print("%");
        System.out.printf("\nPercentual de lugares livres : %.0f " , percentualLivres);
        System.out.println("%");
    }
    
    //função para fazer pagamento da passagem
     private static void realizarPagamento(int numeroLugar){
     Scanner sca = new Scanner(System.in);
     String nomePagante, formaPagamento;
     double preco = 600.00;
             
         System.out.println("Informe seu nome");
         nomePagante = sca.next();
         System.out.println("Informe a forma de pagamento");
         formaPagamento = sca.next();
         System.out.println("Seu pagamento foi realizado"
                          + "\nPoltrona: "+ numeroLugar
                          + "\nValor: R$"+preco
                          + "\nForma de Pagamento: " + formaPagamento);
   
     }
}
