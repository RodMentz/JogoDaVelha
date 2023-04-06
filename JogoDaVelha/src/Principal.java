import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o nome do primeiro jogador: ");
		Jogador j1 = new Jogador(s.nextLine());
		System.out.println();
		System.out.println("Digite o nome do segundo jogador: ");
		Jogador j2 = new Jogador(s.nextLine());
		System.out.println();
		
		int tamanhoJogo = 0;
		while(tamanhoJogo <= 0){
			System.out.println("Digite o tamanho do jogo da velha: ");
			tamanhoJogo = Integer.parseInt(s.nextLine());
		}
		

		JogoDaVelha jogo = new JogoDaVelha(tamanhoJogo);
		System.out.println("Jogo iniciado!\n");
		
		boolean jogoTerminado = false;
		int jogadasRestantes = tamanhoJogo * tamanhoJogo;
		Jogador jogadorAtual = j1; // começa com o jogador 1
		
		while(!jogoTerminado) {
			
			System.out.println(jogo); // mostra o estado atual do tabuleiro
			// solicita a jogada do jogador atual
			System.out.println("Jogador " + jogadorAtual.getNome() + ", é sua vez:\n");
			System.out.print("Digite a linha da jogada (0 a " + (tamanhoJogo - 1) + "): \n");
			int x = s.nextInt();
			System.out.print("Digite a coluna da jogada(0 a " + (tamanhoJogo - 1) + "): \n");
			int y = s.nextInt();

			boolean jogadaValida = jogo.realizaJogada(x, y, jogadorAtual == j1 ? 'X' : 'O');
			while (!jogadaValida) {
				System.out.println("Jogada inválida. Tente novamente!");
				System.out.print("Digite a linha da jogada (0 a " + (tamanhoJogo - 1) + "): \n");
				x = s.nextInt();
				System.out.print("Digite a coluna da jogada(0 a " + (tamanhoJogo - 1) + "): \n");
				y = s.nextInt();
				jogadaValida = jogo.realizaJogada(x, y, jogadorAtual == j1 ? 'X' : 'O');
			}
			if(jogadaValida) {
				jogadasRestantes--;
				if (jogadorAtual == j1) {
					jogadorAtual = j2;
				} else
					jogadorAtual = j1;
			}
			
			//verificar se ha vencedor
			if (jogo.verificaGanhador()) {
				if (jogadorAtual == j1)
					jogadorAtual = j2;
				else
					jogadorAtual = j1;

				System.out.println(jogo);
				System.out.println("O jogador " + jogadorAtual.getNome() + " venceu!");
				jogadorAtual.setPontos(jogadorAtual.getPontos() + 1); //adiciona a pontuacao ao jogador

				System.out.println("Desejam jogar novamente? (s/n)");
				String resposta = s.next();

				if (resposta.equals("n")) {
					// cria arquivo de resultado
					if(j1.getPontos() == j2.getPontos()) {
						try {
							FileWriter fw = new FileWriter("resultado.txt");
							fw.write("Jogo empatado, ainda não há vencedor");
							fw.write("Pontuação atual do jogador "+ j1.getNome() +": "+ j1.getPontos());
							fw.write("Pontuação atual do jogador "+ j2.getNome() +": "+ j2.getPontos());
							fw.close();
							System.out.println("Resultado salvo em resultado.txt");
							jogoTerminado = true;
						} catch (IOException e) {
							System.out.println("Erro ao salvar resultado");
							e.printStackTrace();
						}
						break;
					}
					else {
						try {
							FileWriter fw = new FileWriter("resultado.txt");
							fw.write("Jogador vencedor: " + (j1.getPontos() > j2.getPontos() ? j1.getNome() : j2.getNome()) + "\n");
							fw.write("Pontuação do jogador vencedor: " + (j1.getPontos() > j2.getPontos() ? j1.getPontos() : j2.getPontos()));
							fw.close();
							System.out.println("Resultado salvo em resultado.txt");
							jogoTerminado = true;
						} catch (IOException e) {
							System.out.println("Erro ao salvar resultado");
							e.printStackTrace();
						}
						break;
					}
				}
				else {
					jogo = new JogoDaVelha(tamanhoJogo);
					System.out.println("Jogo iniciado!\n");
					jogoTerminado = false;
					jogadasRestantes = tamanhoJogo * tamanhoJogo;
					jogadorAtual = j1; // começa com o jogador 1
				}
			}


			else if (jogadasRestantes == 0) {
				//o tabuleiro nao tem mais espaco para jogadas
				System.out.println("O jogo empatou!");

				System.out.println("Desejam jogar novamente? (s/n)");
				String resposta = s.next();

				if (resposta.equals("n")) {
					// cria arquivo de resultado
					if(j1.getPontos() == j2.getPontos()) {
						try {
							FileWriter fw = new FileWriter("resultado.txt");
							fw.write("Jogo empatado, ainda não há vencedor");
							fw.write("Pontuação atual do jogador "+ j1.getNome() +": "+ j1.getPontos());
							fw.write("Pontuação atual do jogador "+ j2.getNome() +": "+ j2.getPontos());
							fw.close();
							System.out.println("Resultado salvo em resultado.txt");
							jogoTerminado = true;
						} catch (IOException e) {
							System.out.println("Erro ao salvar resultado");
							e.printStackTrace();
						}
						break;
					}
					else {
						try {
							FileWriter fw = new FileWriter("resultado.txt");
							fw.write("Jogador vencedor: " + (j1.getPontos() > j2.getPontos() ? j1.getNome() : j2.getNome()) + "\n");
							fw.write("Pontuação do jogador vencedor: " + (j1.getPontos() > j2.getPontos() ? j1.getPontos() : j2.getPontos()));
							fw.close();
							System.out.println("Resultado salvo em resultado.txt");
							jogoTerminado = true;
						} catch (IOException e) {
							System.out.println("Erro ao salvar resultado");
							e.printStackTrace();
						}
						break;
					}

				}
				else {
					jogo = new JogoDaVelha(tamanhoJogo);
					System.out.println("Jogo iniciado!\n");

					jogoTerminado = false;
					jogadasRestantes = tamanhoJogo * tamanhoJogo;
					jogadorAtual = j1; // começa com o jogador 1
				}
			}
		}

		s.close();
	}

}
