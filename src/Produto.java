
public class Produto {

	private String nomesProduto;
	private int preco = 0;
	private int quantidade = 0;

	public Produto(String nomeP, int preco, int quantidade) {

		this.nomesProduto = nomeP;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getNomeProduto() {
		return nomesProduto;
	}

	public int getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setNomeProduto(String nome) {
		this.nomesProduto = nome;
	}

	public void setPreco(int Preco) {
		this.preco = Preco;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean hasProduct(String name) {
		return name.equals(getNomeProduto());
	}

}
