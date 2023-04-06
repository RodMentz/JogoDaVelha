
public class Jogador {
	private String nome;
	private int pontos;
	public Jogador(String nome) {
		super();
		this.nome = nome;
		this.pontos = 0;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getPontos() {
		return pontos;
	}
	
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	@Override
	public String toString() {
		return "Jogador [nome=" + nome + ", Pontuação atual =" + pontos + "]";
	}
	
}
