import java.util.Random;
import java.util.Scanner;

public class vaila {
// INTEGRANTES Luis Fernando Giaccio Candido RM:89293 , João Augusto Rudge RM:87725 ,  Geraldo Patrick Oliveira RM:88407 , Thiago Yoshio Saito RM:87625 ,Rodrigo de Cico N. Serine RM:88549
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		boolean i = false;
		int e = 0;
		int c = 0;
		boolean d = false;
		String tipo = null;
		String[][] porco = new String[20][20];
		String[][] chifrudo = new String[20][20];
		String[][] cabra = new String[20][20];

		while (d == false) {

			System.out.print("Digite o numero de cifras para o deslocamento >>> ");
			c = teclado.nextInt();
			if (c < 1 || c > 25) {
				System.out.println("Digite um numero entre 1 a 25 ");
				c = 0;

			} else {
				d = true;
			}
		}
		while (i == false) {
			System.out.println("Entre com um numero\n1----Cadastrar\n2----Relatorio\n3----Pesquisa\n4----Fechar");
			e = teclado.nextInt();

			switch (e) {
			case 1:
				cadastrar(porco, chifrudo, cabra, tipo, c);

				break;
			case 2:
				relatorio(porco, chifrudo, cabra);
				break;
			case 3:
				pesquisa(porco, chifrudo, cabra);
				break;
			case 4:	
				System.exit(0);
				break;
			default :
				System.out.println("Digite um codigo existente !! ");
				break;
			}

		}

	}

	public static void pesquisa(String[][] porco, String[][] chifrudo, String[][] cabra) {
		Scanner teclado = new Scanner(System.in);
		boolean temp = false;
		String cod;
		System.out.println("Digite o codigo Criptografado");
		cod = teclado.nextLine();

		//System.out.println("aqui");
		
		for (int i = 0; i < 20; i++) {
			//System.out.println("aqui2");
			if (cod.equals(chifrudo[i][4])) {
				System.out.println("Bovino encontrado !! ");
				System.out.println();
				for (int f = 0; f < 5; f++) {
					
					System.out.print(chifrudo[i][f] + " / ");
				}
				temp = true;
				break;
			} else if (cod.equals(porco[i][4]) ) {
				System.out.println("Suino encontrado !!");
				System.out.println();
				for (int f = 0; f < 5; f++) {
					System.out.print(porco[i][f] + " / ");
				}
				temp = true;
				break;
			} else if (cod.equals(cabra[i][4])) {
				System.out.println("Caprino encontrado !!");
				System.out.println();
				for (int f = 0; f < 5; f++) {
					System.out.print(cabra[i][f] + " / ");
				}
				temp = true;
				break;
			}
			
		}
		if(temp == false) {
			System.out.println("O codigo digitado esta errado ou o animal não esta cadastrado. ");
		}
		System.out.println();
		
		

	}

	public static void relatorio(String[][] porco, String[][] chifrudo, String[][] cabra) {
		System.out.println("Relatório (RAÇA / PESO / IDADE / CODIGO DESCRIPTOGRAFADO / CODIGO CRIPTOGRAFADO) : ");
		System.out.println("Bovinos : ");

		for (int f = 0; f < chifrudo.length; f++) {
			for (int i = 0; i < 5; i++) {
				if (chifrudo[f][i] != null) {
					System.out.print(chifrudo[f][i] + " / ");
				}
			}
			if (chifrudo[f][0] != null) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Suinos : ");
		for (int f = 0; f < porco.length; f++) {
			for (int i = 0; i < 5; i++) {
				if (porco[f][i] != null) {
					System.out.print(porco[f][i] + " / ");
				}
			}
			if (porco[f][0] != null) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Caprinos : ");
		for (int f = 0; f < cabra.length; f++) {
			for (int i = 0; i < 5; i++) {
				if (cabra[f][i] != null) {
					System.out.print(cabra[f][i] + " / ");
				}
			}
			if (cabra[f][0] != null) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void cadastrar(String[][] porco, String[][] chifrudo, String[][] cabra, String tipo, int c) {
		Scanner teclado = new Scanner(System.in);
		int t = 0;
		String codigo;
		boolean a = false;
		while (a == false) {
			for (int f = 0; f < 5; f++) {
				System.out.println();
				System.out.println("MENU\n1.BOVINO \n2.SUINO \n3.Caprino \n4.Voltar");
				t = teclado.nextInt();
				teclado.nextLine();
				switch (t) {
				case 1:
					System.out.println("Digite a raça do Bovino");
					chifrudo[f][0] = teclado.nextLine();
					System.out.println("Digite o peso do Bovino");
					chifrudo[f][1] = teclado.nextLine();
					System.out.println("Digite a idade do Bovino");
					chifrudo[f][2] = teclado.nextLine();

					codigo = criacaocodigo();
					chifrudo[f][3] = "BO" + codigo;
					codigo = criptografia("BO" + codigo, c);
					chifrudo[f][4] = codigo;

					break;

				case 2:
					System.out.println("Digite a raça do Suino");
					porco[f][0] = teclado.nextLine();
					System.out.println("Digite o peso do Suino");
					porco[f][1] = teclado.nextLine();
					System.out.println("Digite a idade do Suino");
					porco[f][2] = teclado.nextLine();

					codigo = criacaocodigo();
					porco[f][3] = "SU" + codigo;
					codigo = criptografia("SU" + codigo, c);
					porco[f][4] = codigo;
					break;

				case 3:

					System.out.println("Digite a raça do Suino");
					cabra[f][0] = teclado.nextLine();
					System.out.println("Digite o peso do Suino");
					cabra[f][1] = teclado.nextLine();
					System.out.println("Digite a idade do Suino");
					cabra[f][2] = teclado.nextLine();

					codigo = criacaocodigo();
					cabra[f][3] = "CA" + codigo;
					codigo = criptografia("CA" + codigo, c);
					cabra[f][4] = codigo;
					break;

				case 4:
					a = true;
					return;
				default:
					System.out.println("Digite o codigo correto!! ");

				}

			}

		}

	}

	private static String criptografia(String textoOriginal, int chave) {
		String textoCifrado = "";

		for (int i = 0; i < textoOriginal.length(); i++) {
			textoCifrado += encriptar(textoOriginal.charAt(i), chave);
		}

		return textoCifrado;

	}

	public static char encriptar(char charOriginal, int chave) {
		char charCifrado;

		if (charOriginal >= 97 && charOriginal <= 122) {
			charCifrado = (char) ((charOriginal - 97 + chave) % 26 + 97);
		} else if (charOriginal >= 65 && charOriginal <= 90) {
			charCifrado = (char) ((charOriginal - 65 + chave) % 26 + 65);
		} else {
			charCifrado = charOriginal;
		}

		return charCifrado;
	}

	public static String criacaocodigo() {
		Random r = new Random();
		String b = "";
		for (int i = 0; i < 3; i++) {
			char c = (char) (r.nextInt(26) + 'A');
			b = b + c;
		}
		// System.out.println(b);
		return b;

	}
}