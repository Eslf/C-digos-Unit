package listasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimpEnc<T> implements IListaSimpEnc<T> {

	private NoSimpEnc<T> inicio;
	private NoSimpEnc<T> fim;
	private int contElementos;

	// Métodos a Implementar

	public int getContElementos() {
		return contElementos;
	}

	public void setContElementos(int contElementos) {
		this.contElementos = contElementos;
	}

	public void setInicio(NoSimpEnc<T> inicio) {
		this.inicio = inicio;
	}

	public void setFim(NoSimpEnc<T> fim) {
		this.fim = fim;
	}

	@Override
	public NoSimpEnc getInicio() {
		return inicio;
	}

	@Override
	public NoSimpEnc getFim() {
		return fim;
	}

	@Override
	public void clear() {
		this.inicio = null;
		this.fim = null;
		this.contElementos = 0;
	}

	@Override
	public int size() {
		return this.contElementos;
	}

	@Override
	public boolean estaVazia() {
		if (this.inicio == null && this.fim == null) {
			return true;
		}
		return false;
	}

	@Override
	public void InserirInicio(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(elemento);

		if (inicio == null) {
			inicio = fim = novoNo;
			contElementos++;
		} else {
			novoNo.setProximo(inicio);
			inicio = novoNo;
			contElementos++;
		}

	}

	@Override
	public void InserirFim(T elemento) {
		NoSimpEnc<T> novoNo = new NoSimpEnc<T>(elemento);

		if (inicio == null) {
			inicio = fim = novoNo;
			contElementos ++;
		} else {
			fim.setProximo(novoNo);
			fim = novoNo;
			contElementos++;
		}

	}

	@Override
	public void Inserir(int pos, T elemento) throws PosicaoNãoExisteException {
		NoSimpEnc<T> ele = inicio;
		NoSimpEnc<T> addEle = new NoSimpEnc<T>(elemento);
		if (pos == 0) {
			InserirInicio(elemento);
		} else {
			if (pos == contElementos) {
				InserirFim(elemento);
			} else {
				if (pos > contElementos || pos < 0) {
					throw new PosicaoNãoExisteException();
				} else {
					for (int i = 0; i < pos-2; i++) {
						ele = ele.getProximo();
					}
					NoSimpEnc<T> aux = (ele.getProximo());
					ele.setProximo(addEle);
					addEle.setProximo(aux);
					contElementos++;
				}
			}
		}

	}

	@Override
	public boolean contem(T elemento) {
		NoSimpEnc<T> ele = inicio;
		if (elemento.equals(ele.getElemento())) {
			return true;
		}
		for (int i = 0; i < contElementos-1; i++) {
			ele = ele.getProximo();
			if (elemento.equals(ele.getElemento())) {
				return true;
			}

		}
		return false;
	}

	@Override
	public void RemoverInicio() {
		inicio = inicio.getProximo();
		if (inicio == null) {
			contElementos = 0;
			fim = null;
		}
		contElementos--;
	}

	@Override
	public void RemoverFim() {
		NoSimpEnc<T> ele = inicio;
		for (int i = 0; i < contElementos - 1; i++) {
			ele = ele.getProximo();
		}
		ele.setProximo(null);
		fim = null;
		contElementos--;
	}

	@Override
	public void RemoverElemento(T Elemento) {
		NoSimpEnc<T> ele = inicio;
		if (ele.getElemento().equals(Elemento)) {
			RemoverInicio();
		}
		if (fim.getElemento().equals(Elemento)) {
			RemoverFim();
		} else {
			while (this.iterator().hasNext()) {
				ele = ele.getProximo();
				if (ele.getElemento().equals(Elemento)) {
					ele = ele.getProximo();

				}
			}
		}

	}

	@Override
	public Iterator iterator() {
		Iterator<T> myIterator = new Iterator<T>() {

			NoSimpEnc<T> proximo = getInicio();

			@Override
			public boolean hasNext() {
				if (!(proximo == null)) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public T next() throws NoSuchElementException {
				if (!hasNext()) {
					throw new NoSuchElementException();
				} else {
					T elemento = proximo.getElemento();
					proximo = proximo.getProximo();
					return elemento;
				}
			}

		};

		return myIterator;
	}

	@Override
	public String toString() {
		if (this.estaVazia()){
			return "[]";
		}
		NoSimpEnc<T> ele = inicio;
		String elemento = "[";
		if (this.contElementos != 0) {
			for (int i = 0; i < this.contElementos; i++) {
				elemento = elemento + ele.getElemento();
				if (i != this.contElementos - 1) {
					elemento = elemento + ",";
				}
				ele = ele.getProximo();
			}
		} else {
			elemento = elemento + "";
		}
		elemento = elemento + "]";
		return elemento;
	}

}