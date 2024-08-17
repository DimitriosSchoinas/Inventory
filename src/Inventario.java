
public class Inventario {

	private static final int CAPACIDADE_IN = 0;

	private Produto[] produtos;
	private Produto[] prod2;

	private int numProdutos;

	public Inventario() {
		numProdutos = 0;
		produtos = new Produto[CAPACIDADE_IN];
		prod2 = new Produto[999];
	}

	private int procurarProduto(String nomeProduto) {

		int i = 0;

		while (i < numProdutos && !produtos[i].hasProduct(nomeProduto)) {
			i++;
		}
		if (i < numProdutos) {
			return i;
		} else {
			return -1;
		}
	}

	public Iterador iterator() {
		return new Iterador(produtos);
	}

	public Iterador2 iterator2() {
		return new Iterador2(prod2);
	}

	public boolean hasProduto(String nomeP) {
		return procurarProduto(nomeP) != -1;
	}

	public int getNumProdutos() {
		return numProdutos;
	}

	public void adicionarProduto(String nomeP, int precoP, int quantidadeP) {

		if (isFull()) {

			aumentarTamanhoVetor();

			produtos[numProdutos++] = new Produto(nomeP, precoP, quantidadeP);

		} else {
			produtos[numProdutos] = new Produto(nomeP, precoP, quantidadeP);

			numProdutos++;
		}
	}

	private boolean isFull() {
		return numProdutos == produtos.length;
	}

	private void aumentarTamanhoVetor() {
		Produto[] tmp = new Produto[produtos.length + 1];

		for (int i = 0; i < numProdutos; i++) {
			tmp[i] = produtos[i];
		}
		produtos = tmp;

	}

	public void removerProduto(String nomeP) {
		int s = procurarProduto(nomeP);

		for (int z = 0; z < numProdutos - (s + 1); z++) {
			produtos[s + z] = produtos[s + z + 1];
		}
		numProdutos--;

		Produto[] tmp = new Produto[numProdutos];
		for (int i = 0; i < numProdutos; i++) {
			tmp[i] = produtos[i];
		}
		produtos = tmp;
	}

	public void setPreco(String nomeP, int preco) {
		produtos[procurarProduto(nomeP)].setPreco(preco);
	}

	public void adicionarQuantidade(String nomeP, int quantidade) {
		produtos[procurarProduto(nomeP)].setQuantidade(produtos[procurarProduto(nomeP)].getQuantidade() + quantidade);
	}

	public void diminuirQuantidade(String nomeP, int quantidade) {
		produtos[procurarProduto(nomeP)].setQuantidade(produtos[procurarProduto(nomeP)].getQuantidade() - quantidade);
	}

	public int getQuantidade(String nomeP) {
		return produtos[procurarProduto(nomeP)].getQuantidade();
	}

	public int somaQuantidadePTotal() {
		int n = 0;
		int soma = 0;
		while (n < numProdutos) {
			soma = soma + produtos[n].getQuantidade();
			n++;
		}
		return soma;
	}

	public void ordenarProdutos() {
		prod2 = new Produto[numProdutos];

		for (int s = 0; s < numProdutos; s++) {
			prod2[s] = produtos[s];
		}

		for (int i = 0; i < numProdutos - 1; i++) {
			if (prod2[i].getPreco() < prod2[i + 1].getPreco()) {
				Produto tmp = prod2[i];
				prod2[i] = prod2[i + 1];
				prod2[i + 1] = tmp;
				i = -1;
			}
			for (int j = 0; j < numProdutos - 1; j++) {
				if ((prod2[j].getPreco() == prod2[j + 1].getPreco())
						&& prod2[j].getQuantidade() > prod2[j + 1].getQuantidade()) {
					Produto tmp2 = prod2[j];
					prod2[j] = prod2[j + 1];
					prod2[j + 1] = tmp2;
				}
				for (int z = 0; z < numProdutos - 1; z++) {
					if ((prod2[z].getPreco() == prod2[z + 1].getPreco())
							&& (prod2[z].getQuantidade() == prod2[z + 1].getQuantidade())
							&& prod2[z].getNomeProduto().compareTo(prod2[z + 1].getNomeProduto()) > 0) {
						Produto tmp3 = prod2[z];
						prod2[z] = prod2[z + 1];
						prod2[z + 1] = tmp3;
					}
				}
			}

		}

	}

}
