package jogo;

import java.util.Scanner;

public class Jogo {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		// aqui instanciamos a classe e demos o nome de jogo
		JV jogo = new JV();
		// aqui para digitar e jogar na posicao
		String posicao;
		// jogadas Ã© o contador, valida Ã© o repetidor
		int valida = 0, Jogadas = 0, opcao;
		String vencedor;

		do {
			while (true) {
				System.out.println("*****Jogo da velha*****");
				jogo.Mostrar();

				// inicia jogador 1
				do {
					System.out.println("Jogador 1, informe uma posição: ");
					posicao = ler.next();
					// se a jogada for valida ele nem entra nesse while
					while (!jogo.Valido(posicao)) {
						System.out.print("Jogador 1, informe uma posição: ");
						posicao = ler.next();
						valida = 0;
					}
					// Jogador 1 recebe X como simbolo
					jogo.Jogada(posicao, "X");
					// isso aqui quebra o ciclo de repetição pq a jogada foi válida
					valida = 1;

				} while (valida == 0); // fim jogador 1

				Jogadas++;
				// zera dnv pra fazer a mesma coisa com jogador 2
				valida = 0;
				jogo.Mostrar();
				// isso aqui quebra o while infinito (pq ta sempre true), enquanto nao for null
				// ele para com o break
				vencedor = jogo.Ganhou(Jogadas);
				if (!vencedor.equals("null")) {
					jogo.placar();
					break;
				}

				do { // incia jogador 2
					System.out.println("Jogador 2, informe uma posição: ");
					posicao = ler.next();
					// se a jogada for valida ele nem entra nesse while
					while (!jogo.Valido(posicao)) {

						System.out.print("Jogador 2, informe uma posição: ");
						posicao = ler.next();
						valida = 0;
					}
					// Jogador 2 recebe O como simbolo
					jogo.Jogada(posicao, "O");
					// isso aqui quebra o ciclo de repetição pq a jogada foi válida
					valida = 1;

				} while (valida == 0); // fim jogador 2

				Jogadas++;
				// zera dnv pra fazer a mesma coisa com jogador 2
				valida = 0;
				jogo.Mostrar();
				// isso aqui quebra o while infinito (pq ta sempre true), enquanto nao for null
				// ele para com o break
				vencedor = jogo.Ganhou(Jogadas);
				if (!vencedor.equals("null")) {
					jogo.placar();
					break;
				}

				if (vencedor.equals("EMPATE")) {
					break;
				}
			}
			if (!vencedor.equals("EMPATE")) {
				System.out.println("O " + vencedor + " Venceu!");
			} else {
				System.out.println("Empate");
			}

			System.out.println("Deseja jogar mais uma vez? 0 para sim, 1 para não");
			opcao = ler.nextInt();

			if (opcao == 0) {

				jogo.zerar();
			}

		} while (opcao != 1);

	}

}
