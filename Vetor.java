package me;



import java.util.Iterator;
import java.util.NoSuchElementException;



public class Vetor<T> implements IVetor<T>,Iterable<T> {
	
	private final int tamVetor; //por padrão é 10
	private T[] elementos; //como instanciar: (T[]) new  Object[tamVetor]
	private int contElementos; //contador de elementos
	private int vlIncremento; //valor para redimensionar, por padrão o valor é 10
	
	private T[] elementosMaior;
	private T[] elementosMenor;
	
	
	
	//implemente os 3 construtores!
	
	public Vetor() {
		this.tamVetor=10;
		elementos = (T[])  new Object[this.tamVetor];
		this.vlIncremento=10;
		this.contElementos=0;
	}
	
	public Vetor (int tamVetor){
		this.tamVetor=tamVetor;
		elementos = (T[])  new Object[this.tamVetor];
		this.vlIncremento=10;
		this.contElementos=0;
		}
	
	public Vetor (int tamVetor,int vlIncremento){
		this.tamVetor=tamVetor;
		elementos = (T[])  new Object[this.tamVetor];
		this.vlIncremento=vlIncremento;
		this.contElementos=0;
	}
	
	
	// ------------------------------------------------
	
	private Iterator<T> myIterator = new Iterator<T>() 
	{

		private int posicao = 0;
		
		@Override
		public boolean hasNext() 
		{
			if(posicao < contElementos)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		@Override
		public T next() throws NoSuchElementException 
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				T elemento = elementos[posicao];
				posicao++;
				return elemento;
			}
		}
	};
	
		
	@Override
	public Iterator<T> iterator() {
		return myIterator;
	}


	@Override
	public void Adicionar(T elemento) {
		if (contElementos == 0) {
			this.elementos[0]= elemento;
			this.contElementos++;
		} else{
			boolean eVazio=false;
			int pos = 0; // Posicao que receberá o elemento.
			for (int i=0;i<this.contElementos;i++){
				if (this.elementos[i]==null){
					eVazio = true;
					pos=i;
				} else{
					eVazio = false;
				}
			}
			if (eVazio==true){
				this.elementos[pos]=elemento;
				this.contElementos++;
			} else {
				elementosMaior = (T[]) new Object[this.elementos.length+this.vlIncremento];
				System.arraycopy(elementos, 0, elementosMaior, 0, this.contElementos);
				elementos=elementosMaior;
				this.elementos[this.contElementos]=elemento;
				this.contElementos++;
			}
		}
		
		
	}


	@Override
	public void Adicionar(int posicao, T elemento)
			throws IndexOutOfBoundsException {
		if (posicao < 0 || posicao >= this.tamVetor){
			throw new IndexOutOfBoundsException();
		} else {
			if (this.elementos[posicao]==null){
				this.elementos[posicao]=elemento;
				this.contElementos++;
			} else {
				elementosMaior = (T[]) new Object[this.elementos.length+this.vlIncremento];
				System.arraycopy(elementos, 0, elementosMaior, 0, this.elementos.length);
				System.arraycopy(elementos, posicao, elementosMaior, posicao+1, this.tamVetor-posicao);
				elementos=elementosMaior;
				this.elementos[posicao]=elemento;
				this.contElementos++;
			}
			
		}
		
	}


	@Override
	public void AdicionarInicio(T elemento) {
		elementosMaior = (T[]) new Object[this.elementos.length+this.vlIncremento];
		System.arraycopy(elementos, 0, elementosMaior, 1, this.elementos.length);
		elementos=elementosMaior;
		this.elementos[0]=elemento;
		this.contElementos++;
	}

// Não é necessário redimensionar o vetor na hora de remover, somente reorganizar os elementos do vetor;
	@Override
	public void Remover(int posicao) throws IndexOutOfBoundsException {
		if (this.elementos[posicao]!=null){
			this.elementos[posicao]=null;
			if (posicao !=0){
				elementosMenor = (T[]) new Object[this.elementos.length];
				System.arraycopy(elementos, posicao, elementosMenor, posicao-1, this.elementos.length);
				elementos=elementosMenor;
				this.contElementos--;
			} else {
				elementosMenor = (T[]) new Object[this.elementos.length];
				System.arraycopy(elementos, 1, elementosMenor, 0, this.elementos.length-1);
				elementos=elementosMenor;
				this.contElementos--;
			}
			
		}
		
	}


	@Override
	public void RemoverElemento(T elemento) {
		int i,pos;
		for (i=0;i<this.contElementos;i++){
			if (elemento==this.elementos[i]){
				pos=i;
				this.elementos[i]=null;
				this.contElementos--;
				elementosMenor = (T[]) new Object[this.elementos.length-1];
				System.arraycopy(elementos, 0, elementosMenor, 0, this.contElementos+1);
				System.arraycopy(elementos, pos+1, elementosMenor, pos, this.contElementos);
				elementos=elementosMenor;
				break;
			}
		}
	}


	@Override
	public void RemoverInicio() {
		if (this.elementos[0]!=null){
			this.elementos[0]=null;
			elementosMenor = (T[]) new Object[this.elementos.length-1];
			System.arraycopy(elementos, 1, elementosMenor, 0, this.elementos.length-1);
			elementos=elementosMenor;
			this.contElementos--;
		}
	}


	@Override
	public void RemoverFim() {
		if (this.elementos[this.contElementos-1]!=null){
			this.elementos[this.contElementos-1]=null;
			this.contElementos--;
		}
		
	}


	@Override
	public int Tamanho() {
		// TODO Auto-generated method stub
		return contElementos;
	}


	@Override
	public void Limpar() {
		// TODO Auto-generated method stub
		int i;
		for (i=0;i<this.contElementos;i++){
			this.elementos[i]=null;
		}
		this.contElementos=0;
	}


	@Override
	public boolean contem(T elemento) {
		for (int i=0;i<this.elementos.length;i++){
			if (this.elementos[i]==elemento){
				return true;
			}
		}
		return false;
	}	
	
	public String toString(){
		String elemento = "[";
				if (this.contElementos != 0){
					for (int i=0;i<this.contElementos;i++){
						elemento = elemento+this.elementos[i];
						if (i!=this.contElementos-1){
							elemento = elemento+",";
						}
					}
				} else{
					elemento=elemento+"";
				}
		elemento = elemento+"]"; 
		return elemento;
	}
	
}