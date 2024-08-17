
public class Iterador {

	private Produto[] produtos;
	private int nextIndex;

	public Iterador(Produto[] produtos) {
		this.produtos = produtos;
		nextIndex = 0;
	}

	public boolean hasNext() {
		return nextIndex < produtos.length;
	}

	public Produto Next() {
		return produtos[nextIndex++];
	}
}
