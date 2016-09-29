package listasim;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NoSimpEnc<T> {

    private T elemento;
    private NoSimpEnc<T> proximo;

    public NoSimpEnc(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }
    
    public NoSimpEnc(T elemento, NoSimpEnc<T> no) {
        this.elemento = elemento;
        this.proximo = no;
    }
    

	public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoSimpEnc<T> getProximo() {
        return proximo;
    }

    public void setProximo(NoSimpEnc<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "" + getElemento();
    }
    
}