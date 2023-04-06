
public class JogoDaVelha {
	private char jogo[][];
	private int tamanhoJogo;
	public JogoDaVelha(int tamanhoJogo) {
		this.tamanhoJogo = tamanhoJogo;
		this.jogo = new char[tamanhoJogo][tamanhoJogo];
		
		for(int i = 0; i<jogo.length; i++) 
			for(int j = 0; j<jogo[i].length; j++)
				this.jogo[i][j] = ' ';
	}
	
	public char[][] getJogo() {
		return jogo;
	}

	public void setJogo(char[][] jogo) {
		this.jogo = jogo;
	}

	public int getTamanhoJogo() {
		return tamanhoJogo;
	}

	public void setTamanhoJogo(int tamanhoJogo) {
		this.tamanhoJogo = tamanhoJogo;
	}

	public boolean realizaJogada(int x, int y, char jogada){
		if (x < 0 || x >= jogo.length || y < 0 || y >= jogo.length)
			return false;
		
		if(jogo[x][y] == 'X' || jogo[x][y] == 'O') {
			return false; //nao foi possivel fazer a jogada
		}
		else {
			jogo[x][y] = jogada;
			return true; // jogada realizada com sucesso
		}
					
	}
	
	public boolean verificaGanhador() {
		// Verifica a diagonal principal
		int pontosDP = 0;
		char primeiroDP = jogo[0][0];
		for(int i =0; i < this.jogo.length; i++) {
			if (jogo[i][i] == primeiroDP && jogo[i][i] != ' ')
				pontosDP++;
		}

		//Verifica a diagonal secundaria
		int pontosDS = 0;
		char primeiroDS = jogo[0][jogo.length - 1];
		for(int i =0; i < this.jogo.length; i++) {
			if (jogo[i][jogo.length - i - 1] == primeiroDS && jogo[i][jogo.length - i - 1] != ' ')
				pontosDS++;
		}
		
		//Secundaria E principal então ganha
		if(pontosDP == jogo.length && pontosDS == jogo.length)
			return true;

		//Verifica as linhas
		for (int i = 0; i < jogo.length; i++) {
	        char primeiroL = jogo[i][0];
			int pontos = 0;
	        for (int j = 0; j < jogo[i].length; j++) {
	            if (jogo[i][j] == primeiroL && jogo[i][j] != ' ') {
	                pontos++;
	            }
	        }
			if (pontos == jogo.length)
				return true;
	    }
		
		//Verifica as colunas
		for (int j = 0; j < jogo[0].length; j++) {
	        int primeiroC = jogo[0][j];
			int pontos = 0;
	        for (int i = 1; i < jogo.length; i++) {
	            if (jogo[i][j] == primeiroC && jogo[i][j] != ' ') {
					pontos++;
	            }
	        }
			if (pontos == jogo.length)
				return true;
	    }
		
		return false;
	}
			
	@Override
	public String toString() {
		String retorno = "";
		for(int i=0; i<jogo.length; i++){
			for(int j=0; j<jogo[i].length; j++)
			retorno += (" ["+jogo[i][j]+"] ");
			retorno += "\n";

		}
		return retorno;
	}
}


