
public class Iterador2 {
	private Produto[] prod2;
	private int nextIndex;

	public Iterador2(Produto[] prod2) {
		this.prod2 = prod2;
		nextIndex = 0;
	}

	public boolean hasNext() {
		return nextIndex < prod2.length;
	}

	public Produto Next() {
		return prod2[nextIndex++];
	}
}