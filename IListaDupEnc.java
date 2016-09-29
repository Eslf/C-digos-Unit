package listaDupla;



import java.util.Iterator;

public interface IListaDupEnc<T> {
	// Retorna a referencia do no que encontra-se no inicio da lista
	public NoDupEnc<T> getInicio();

	// Retorna a referencia do no que encontra-se no fim da lista
	public NoDupEnc<T> getFim();

	// Limpa toda a lista
	public void clear();

	// tamanho de elementos que a lista possui
	public int size();

	// Retorna se a lista està ou nao vazia
	public boolean estaVazia();

	// Inserir um elemento no inicio da lista
	public void InserirInicio(T elemento);

	// Inserir um elemento no fim da lista
	public void InserirFim(T elemento);

	// Inserir um elemento na posicao indicada pelo parametro pos
	public void Inserir(int pos, T elemento) throws PosicaoNãoExisteException;

	// Indica se a lista possui o elemento
	public boolean contem(T elemento);

	// Remove o primeiro elemento da lista
	public void RemoverInicio();

	// Remove o Ïltimo elemento da lista
	public void RemoverFim();

	// Remove o elemento na posicao
	public void Remover(int pos) throws PosicaoNãoExisteException;

	public String toString();

	//Percorre o iterator ao contrario
	public Iterator<T> iterator();
}
