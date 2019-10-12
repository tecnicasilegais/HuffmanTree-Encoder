import java.util.Scanner;
import java.awt.Desktop;
import java.io.File;

public class App {

	/**
	 * Menu class
	 * 
	 * @author Eduardo Andrade
	 * @author Marcelo Heredia
	 */
	public static void main(String[] args) {
		final String filepath = "input\\";
		Scanner in = new Scanner(System.in);
		TextEncoder encoder;
		TextDecoder decoder;
		String file;
		int control = 0;
		boolean use;
		do {
			try {
				System.out.println("Digite a operação desejada");
				System.out.println("1 - Codificar texto");
				System.out.println("2 - Decodificar texto");
				System.out.println("0 - Sair");

				control = in.nextInt();

				switch (control) {
				case 1:
					System.out.println("Digite o nome do arquivo a ser codificado");
					System.out.println("(Lembrando que o arquivo deve estar na pasta input)");
					file = in.next();
					if (!file.contains(".txt")) {
						file += ".txt";
					}
					encoder = new TextEncoder(file);
					use = encoder.Start();
					if (!use) {
						System.out.println("Arquivo não encontrado.");
						continue;
					}
					System.out.println("Concluido.");
					if (Desktop.isDesktopSupported()) {
						try {
							File textFile = new File(filepath + file);
							Desktop desktop = Desktop.getDesktop();
							if (textFile.exists()) {
								desktop.open(textFile);
							}
						}
						catch (Exception ex) {
							continue;
						}
					}
					break;
				case 2:
					System.out.println("Digite o nome do arquivo a ser decodificado");
					System.out.println("(Lembrando que o arquivo deve estar na pasta input)");
					file = in.next();
					if (!file.contains(".txt")) {
						file += ".txt";
					}
					decoder = new TextDecoder(file);
					use = decoder.Start();
					if (!use) {
						System.out.println("Arquivo não encontrado.");
						continue;
					}
					System.out.println("Concluido.");
					if (Desktop.isDesktopSupported()) {
						try {
							File textFile = new File(filepath + file);
							Desktop desktop = Desktop.getDesktop();
							if (textFile.exists()) {
								desktop.open(textFile);
							}
						}
						catch (Exception ex) {
							continue;
						}
					}
					break;
				default:
					continue;
				}
			}
			catch (Exception ex) {
				System.out.println("Erro inesperado, recomeçando.");
				control = 3;
				continue;
			}
		} while (control != 0);
		in.close();
	}
}