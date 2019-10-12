import java.util.Scanner;

public class App{
    
/**
 * Menu class
 * 
 * @author Eduardo Andrade
 * @author Marcelo Heredia
 */
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        TextEncoder encoder;
        TextDecoder decoder;
        String file;
        int control = 0;
        do {
            try{ 
                System.out.println("Digite a operação desejada");
                System.out.println("1 - Codificar texto");
                System.out.println("2 - Decodificar texto");
                System.out.println("0 - Sair");

                control = in.nextInt();

                switch(control){
                    case 1: 
                        System.out.println("Digite o nome do arquivo a ser codificado");
                        System.out.println("(Lembrando que o arquivo deve estar na pasta input)");
                        file = in.next();
                        if (!file.contains(".txt")){
                            file += ".txt";
                        }
                        encoder = new TextEncoder(file);
                        break;
                    case 2:
                        System.out.println("Digite o nome do arquivo a ser decodificado");
                        System.out.println("(Lembrando que o arquivo deve estar na pasta input)");
                        file = in.next();
                        if (!file.contains(".txt")){
                            file += ".txt";
                        }
                        decoder = new TextDecoder(file);
                        break;
                    default:
                        continue;
                }
            }
            catch(Exception ex){
                System.out.println("Erro inesperado, recomeçando.");
                control = 3;
                continue;
            }
        }
        while (control != 0);
    }
}