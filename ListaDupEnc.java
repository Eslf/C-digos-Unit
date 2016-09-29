package listaDupla;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDupEnc<T> implements IListaDupEnc<T> {

	private NoDupEnc<T> inicio;
	private NoDupEnc<T> fim;
	private int contElementos;

	// Métodos a Implementar

	public int getContElementos() {
		return contElementos;
	}

	public void setContElementos(int contElementos) {
		this.contElementos = contElementos;
	}

	public void setInicio(NoDupEnc<T> inicio) {
		this.inicio = inicio;
	}

	public void setFim(NoDupEnc<T> fim) {
		this.fim = fim;
	}

	@Override
	public NoDupEnc getInicio() {
		return inicio;
	}

	@Override
	public NoDupEnc getFim() {
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
		if (this.inicio == null && this.fim == null || contElementos==0) {
			return true;
		}
		return false;
	}

	@Override
	public void InserirInicio(T elemento) {
		NoDupEnc<T> novoNo = new NoDupEnc<T>(elemento);

		if (inicio == null) {
			inicio = fim = novoNo;
			contElementos++;
		} else {
			novoNo.setProximo(inicio);
			novoNo.getProximo().setAnterior(novoNo);
			inicio = novoNo;
			contElementos++;
		}

	}

	@Override
	public void InserirFim(T elemento) {
		NoDupEnc<T> novoNo = new NoDupEnc<T>(elemento);

		if (inicio == null) {
			inicio = fim = novoNo;
			contElementos ++;
		} else {
			fim.setProximo(novoNo);
			novoNo.setAnterior(fim);
			fim = novoNo;
			contElementos++;
		}

	}

	@Override
	public void Inserir(int pos, T elemento) throws PosicaoNãoExisteException {
		NoDupEnc<T> ele = inicio;
		NoDupEnc<T> addEle = new NoDupEnc<T>(elemento);
		if (pos == 0) {
			InserirInicio(elemento);
		} else {
			if (pos == contElementos) {
				InserirFim(elemento);
			} else {
				if (pos > contElementos || pos < 0) {
					throw new PosicaoNãoExisteException();
				} else {
					for (int i = 0; i < pos; i++) { // Alterado de "pos-2" para "pos"
						ele = ele.getProximo();
					}
					ele.getAnterior().setProximo(addEle);
					ele.setAnterior(addEle);
					addEle.setProximo(ele);
					contElementos++;
				}
			}
		}

	}

	@Override
	public boolean contem(T elemento) {
		NoDupEnc<T> ele = inicio;
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
		if (contElementos!=0 & contElementos > 1){
		fim.setElemento(fim.getAnterior().getElemento());
		fim.setProximo(null);
		contElementos--;} else {
			inicio.setElemento(null);
			fim.setElemento(null);
			contElementos--;
		}
		
	}

	@Override
	public void Remover(int pos) throws PosicaoNãoExisteException{
		// TODO Auto-generated method stub
		NoDupEnc<T> ele = inicio;
		if (pos == 0) {
			RemoverInicio();
		} else {
			if (pos == contElementos) {
				RemoverFim();
			} else {
				if (pos > contElementos || pos < 0) {
					throw new PosicaoNãoExisteException();
				} else {
					for (int i = 0; i < pos; i++) { // Alterado de "pos-2" para "pos"
						ele = ele.getProximo();
					}
					ele.getAnterior().setProximo(ele.getProximo());
					contElementos--;
				}
			}
		}
		
	}

	@Override
	public Iterator iterator() {
		Iterator<T> myIterator = new Iterator<T>() {

			NoDupEnc<T> proximo = getInicio();

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
		NoDupEnc<T> ele = inicio;
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