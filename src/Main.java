import java.util.Scanner;

import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(System.in);
		Inventario inventario = new Inventario();
		String escreverComando;

		String NomeFicheiro = in.nextLine();
		Scanner in2 = new Scanner(new FileReader(NomeFicheiro));

		LerFicheiro(in2, inventario);

		do {
			escreverComando = in.nextLine();
			executarComando(escreverComando, in, inventario);
		} while (!escreverComando.equals("SAIR"));
		in.close();

	}

	private static void executarComando(String escreverCommando, Scanner in, Inventario inventario) {

		switch (escreverCommando) {
		case "AP":
			Ap(in, inventario);
			break;
		case "AQP":
			Aqp(in, inventario);
			break;
		case "DQP":
			Dqp(in, inventario);
			break;
		case "RP":
			Rp(in, inventario);
			break;
		case "L":
			L(inventario);
			break;
		case "VT":
			Vt(inventario);
			break;
		case "LO":
			Lo(inventario);
			break;
		case "PE":
			Pe(inventario);
			break;
		case "SAIR":
			Sair(inventario);
			break;
		}
	}

	private static void Ap(Scanner in, Inventario inventario) {
		String nomeP = in.nextLine();

		int precoP = in.nextInt();
		int quantidadeP = in.nextInt();
		in.nextLine();

		if (inventario.hasProduto(nomeP) == true) {
			System.out.println("Produto existente");
		} else {
			inventario.adicionarProduto(nomeP, precoP, quantidadeP);
			System.out.println("Produto adicionado");
		}

	}

	private static void Aqp(Scanner in, Inventario inventario) {
		String nomeP = in.nextLine();

		int numAumentar = in.nextInt();
		in.nextLine();

		if (inventario.hasProduto(nomeP) == false) {
			System.out.println("Produto inexistente");
		} else {

			inventario.adicionarQuantidade(nomeP, numAumentar);
			System.out.println("Quantidade de " + nomeP + " aumentada em " + numAumentar + " unidades");
		}
	}

	private static void Dqp(Scanner in, Inventario inventario) {
		String nomeP = in.nextLine();

		int numDiminuir = in.nextInt();
		in.nextLine();

		if (inventario.hasProduto(nomeP) == false) {
			System.out.println("Produto inexistente");
		} else if (inventario.getQuantidade(nomeP) < numDiminuir) {
			System.out.println("Impossível diminuir quantidade");
		} else {
			inventario.diminuirQuantidade(nomeP, numDiminuir);
			System.out.println("Quantidade de " + nomeP + " diminuída em " + numDiminuir + " unidades");
		}
	}

	private static void Rp(Scanner in, Inventario inventario) {
		String nomeP = in.nextLine();

		if (inventario.hasProduto(nomeP) == true) {
			inventario.removerProduto(nomeP);
			System.out.println("Produto removido");
		} else {
			System.out.println("Produto inexistente");
		}
	}

	private static void L(Inventario inventario) {
		if (inventario.getNumProdutos() == 0) {
			System.out.println("Não existem produtos");
		} else {
			Iterador iterador = inventario.iterator();
			while (iterador.hasNext()) {
				Produto tmp = iterador.Next();
				System.out.println(tmp.getNomeProduto() + " ; " + tmp.getQuantidade() + " ; " + tmp.getPreco());
			}
		}
	}

	private static void Vt(Inventario inventario) {
		int v = 0;
		if (inventario.getNumProdutos() == 0) {
			System.out.println("Não existem produtos");
		} else {
			Iterador iterador = inventario.iterator();
			while (iterador.hasNext()) {
				Produto tmp = iterador.Next();
				v = v + (tmp.getQuantidade() * tmp.getPreco());
			}

			System.out.println("Valor total: " + v);
		}
	}

	private static void Sair(Inventario inventario) {

		System.out.println("O stock totaliza " + inventario.somaQuantidadePTotal() + " items");

	}

	private static void Lo(Inventario inventario) {
		inventario.ordenarProdutos();
		Iterador2 iterador = inventario.iterator2();
		while (iterador.hasNext()) {
			Produto tmp = iterador.Next();
			System.out.println(tmp.getNomeProduto() + " ; " + tmp.getQuantidade() + " ; " + tmp.getPreco());
		}
	}

	private static void Pe(Inventario inventario) {

		Iterador iterador = inventario.iterator();
		while (iterador.hasNext() == true) {
			Produto tmp = iterador.Next();
			if (tmp.getQuantidade() == 0) {
				System.out.println(tmp.getNomeProduto() + " ; " + tmp.getQuantidade() + " ; " + tmp.getPreco());
			}
		}

	}

	private static void LerFicheiro(Scanner in2, Inventario inventario) {

		int N = in2.nextInt();
		in2.nextLine();

		while (in2.hasNextLine()) {
			String nomeP = in2.nextLine();
			int precoP = in2.nextInt();
			int quantP = in2.nextInt();
			in2.nextLine();
			inventario.adicionarProduto(nomeP, precoP, quantP);

		}
	}

}
