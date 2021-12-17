package jogo;

public class JV {
	// aqui teremos os m√©todos

	// aqui eu declaro a array bidimensional de tipo String de matriz 3 por 3
	// eu inicio desse jeito 1..2..3 para nao precisar atribuir valores depois

	String[][] m = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
	int cont1 = 0, cont2 = 0;

	public void zerar() {
		int valor = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m[i][j] = valor + "";
				valor++;
			}
		}
	}

	// aqui eu fa√ßo o for da linha e outro pra coluna para percorrer a matriz

	public String Mostrar() {
		for (int li = 0; li < 3; li++) {
			for (int co = 0; co < 3; co++) {
				System.out.print("   " + m[li][co]);
			}
			System.out.println("\n");
		}
		return null;
	}

	// aqui eu tenho um metodo para verificar se √© true ou false as posi√ßoes da
	// matriz
	public boolean Valido(String p) {
		for (int li = 0; li < 3; li++) {
			for (int co = 0; co < 3; co++) {
				if (m[li][co].equals(p))
					return true;
			}
			System.out.print("\n");
		}
		if (Character.isDigit(m[0][0].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[0][1].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[0][2].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[1][0].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[1][1].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[1][2].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[2][0].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[2][1].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		else if (Character.isDigit(m[2][2].charAt(0)))
			System.out.print("Jogada inv·lida, jogue novamente\n");
		return false;
	}

	// nesse metodo eu irei fazer a jogada, ou seja, o numero que a pessoa digitou
	// vai aparecer o simbolo na matriz, nao retorna nada

	public void Jogada(String p, String j) {
		// se a posicao for igual ao numero ele coloca na linha ... coluna ...
		if (p.equals("1"))
			m[0][0] = j;
		else if (p.equals("2"))
			m[0][1] = j;
		else if (p.equals("3"))
			m[0][2] = j;
		else if (p.equals("4"))
			m[1][0] = j;
		else if (p.equals("5"))
			m[1][1] = j;
		else if (p.equals("6"))
			m[1][2] = j;
		else if (p.equals("7"))
			m[2][0] = j;
		else if (p.equals("8"))
			m[2][1] = j;
		else if (p.equals("9"))
			m[2][2] = j;
	}

	// aqui eu fa√ßo o metodo do vencedor

	public String Ganhou(int jogadas) {
		// aqui eu tenho um array de string para verificar se alguem ja ganhou, sendo
		// que tem 8 possibilidades de ganhar o jogo por isso os 8 elementos
		String[] T = new String[8];
		// inicializo com null pq ainda nao tem nenhum vencedor
		String vencedor = "null";
		if (jogadas == 9) {			
			return "EMPATE";
		}
		// possibilidade de vitoria em linhas
		T[0] = m[0][0] + m[0][1] + m[0][2];
		T[1] = m[1][0] + m[1][1] + m[1][2];
		T[2] = m[2][0] + m[2][1] + m[2][2];

		// possibilidades de vitoria em coluna
		T[3] = m[0][0] + m[1][0] + m[2][0];
		T[4] = m[0][1] + m[1][1] + m[2][1];
		T[5] = m[0][2] + m[1][2] + m[2][2];

		// possibilidade de vitoria em diagonal
		T[6] = m[0][0] + m[1][1] + m[2][2];
		T[7] = m[0][2] + m[1][1] + m[2][0];

		// for e if para ver se fez velha
		for (int i = 0; i < T.length; i++) {
			if (T[i].equals("XXX")) {
				vencedor = "Jogador 1";
			} else if (T[i].equals("OOO")) {
				vencedor = "Jogador 2";
			}

		}

		if (vencedor.equals("Jogador 1")) {
			cont1++;
		} else if (vencedor.equals("Jogador 2")) {
			cont2++;

		}

		return vencedor;
	}

	public void placar() {
		System.out.println("    ---  PLACAR  ---            ");
		System.out.println("Jogador 1 - " + cont1 + " X " + cont2 + " - Jogador 2");

	}
}
