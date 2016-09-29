package listaDupla;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NoDupEnc<T>{

    private T elemento;
    private NoDupEnc<T> proximo;
    private NoDupEnc<T> anterior;
    private NoDupEnc<T> inicio;
    private NoDupEnc<T> fim;
    private int contElementos;

    public NoDupEnc(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
    
    public NoDupEnc(T elemento, NoDupEnc<T> no, NoDupEnc<T> na) {
        this.elemento = elemento;
        this.proximo = no;
        this.anterior = na;
    }
    
    
    
    public NoDupEnc<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDupEnc<T> anterior) {
		this.anterior = anterior;
	}

	public NoDupEnc<T> getInicio() {
		return inicio;
	}

	public NoDupEnc<T> getFim() {
		return fim;
	}

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

	public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoDupEnc<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoDupEnc<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "" + getElemento();
    }

}
