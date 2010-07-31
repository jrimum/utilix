/*
 * Copyright 2008 JRimum Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * Created at: 30/03/2008 - 18:17:54
 * 
 * ================================================================================
 * 
 * Direitos autorais 2008 JRimum Project
 * 
 * Licenciado sob a Licença Apache, Versão 2.0 ("LICENÇA"); você não pode usar
 * esse arquivo exceto em conformidade com a esta LICENÇA. Você pode obter uma
 * cópia desta LICENÇA em http://www.apache.org/licenses/LICENSE-2.0 A menos que
 * haja exigência legal ou acordo por escrito, a distribuição de software sob
 * esta LICENÇA se dará “COMO ESTÁ”, SEM GARANTIAS OU CONDIÇÕES DE QUALQUER
 * TIPO, sejam expressas ou tácitas. Veja a LICENÇA para a redação específica a
 * reger permissões e limitações sob esta LICENÇA.
 * 
 * Criado em: 30/03/2008 - 18:17:54
 * 
 */

package org.jrimum.utilix;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import org.apache.log4j.Logger;
import org.jrimum.utilix.text.StringUtil;

/**
 * 
 * <p>
 * Utilitário para manipular arquivos e fluxos de arquivos.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class FileUtil implements Serializable {

	protected static final Logger LOG = Logger.getLogger(FileUtil.class);

	private static final long serialVersionUID = 1227314921804015225L;

	/**
	 * <p>
	 * Transforma um array de bytes em um arquivo.
	 * </p>
	 * 
	 * @param pathName - Caminho do arquivo para onde os bytes serão escritos.
	 * @param bytes - Bytes a serem copiados.
	 * 
	 * @return Objeto File com o conteúdo sendo o dos bytes
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NullPointerException Caso <code>pathName</code> ou <code>bytes</code> sejam <code>null</code>.
	 * @throws IllegalArgumentException Caso <code>pathName</code> seja vazio ou contenha apenas espaços em branco
	 * 
	 * @since 0.2
	 */
	public static File bytes2File(String pathName, byte[] bytes) throws FileNotFoundException, IOException {

		StringUtil.checkNotBlank(pathName);
		ObjectUtil.checkNotNull(bytes);

		return bytes2File(new File(pathName), bytes);
	}
	
	/**
	 * <p>
	 * Transforma um array de bytes em um arquivo.
	 * </p>
	 * 
	 * @param file
	 *            - arquivo para onde os bytes serão escritos.
	 * @param bytes
	 *            - Bytes a serem copiados.
	 * 
	 * @return Objeto File com o conteúdo sendo o dos bytes
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NullPointerException
	 *             Caso <code>pathName</code> ou <code>bytes</code> sejam
	 *             <code>null</code>.
	 * @throws IllegalArgumentException
	 *             Caso <code>pathName</code> seja vazio ou contenha apenas
	 *             espaços em branco
	 * 
	 * @since 0.2
	 */
	public static File bytes2File(File file, byte[] bytes) throws FileNotFoundException, IOException {

		ObjectUtil.checkNotNull(file);
		ObjectUtil.checkNotNull(bytes);

		if(file.length() > Integer.MAX_VALUE){
			throw new IllegalArgumentException("TAMANHO DO ARQUIVO MAIOR DO QUE O SUPORTADO: "+Integer.MAX_VALUE);
		}
		
		OutputStream out = new FileOutputStream(file);

		out.write(bytes);
		out.flush();
		out.close();

		return file;
	}

	/**
	 * <p>
	 * Transforma um array de bytes em um <code>ByteArrayOutputStream</code>.
	 * </p>
	 * 
	 * @param bytes - Bytes que serão escritos no objeto ByteArrayOutputStream
	 * 
	 * @return ByteArrayOutputStream ou null
	 * 
	 * @throws IOException
	 * @throws NullPointerException Caso <code>bytes</code> sejam <code>null</code>.
	 * 
	 * @since 0.2
	 */
	public static ByteArrayOutputStream bytes2Stream(byte[] bytes) throws IOException {

		ByteArrayOutputStream byteOut = null;
		
		ObjectUtil.checkNotNull(bytes);

		byteOut = new ByteArrayOutputStream();
		byteOut.write(bytes);

		return byteOut;
	}
}
