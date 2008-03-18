package br.com.nordestefomento.jrimum.utilix;

import br.com.nordestefomento.jrimum.ICurbitaObject;

public interface IReadWriteStream <G> extends ICurbitaObject{
	
	
	/**
	 * Escreve o tipo infomado.
	 * 
	 * @return
	 */
	public abstract G write();
	
	
	/**
	 * Ler o tipo informado.
	 * 
	 * @param g
	 */
	public abstract void read(G g);

}
