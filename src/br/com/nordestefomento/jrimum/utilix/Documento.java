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
 * Created at: 30/03/2008 - 18:16:19
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
 * Criado em: 30/03/2008 - 18:16:19
 * 
 */


package br.com.nordestefomento.jrimum.utilix;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import br.com.nordestefomento.jrimum.ACurbitaObject;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 
 * Descrição:
 * 
 * 
 * @author Gabriel Guimarães
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Misael Barreto 
 * @author Rômulo Augusto
 * @author <a href="http://www.nordeste-fomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since JMatryx 1.0
 * 
 * @version 1.0
 */
public class Documento extends ACurbitaObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6824599737676504544L;

	protected static Logger log = Logger.getLogger(Documento.class);

	protected Document documento;
	
	protected PdfWriter writer;
	
	protected PdfContentByte contentByte;
	
	protected ByteArrayOutputStream arquivoByteStream;

	/**
	 * 
	 */
	protected Documento() {
		super();
	}

	protected Documento (String tituloDoc, String autorDoc) throws DocumentException {

		if(log.isTraceEnabled())
			log.trace("Instanciando Documento, titulo: "+ tituloDoc + "; autor: "+autorDoc);
		
		
		Document document = new Document(PageSize.A4);
		document.addAuthor(autorDoc);
		document.addTitle(tituloDoc);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	
		documento = document;
		writer = PdfWriter.getInstance(document,out);
		arquivoByteStream = out;
		
		if(log.isTraceEnabled())
			log.trace("Documento Instanciado: "+ this);
		
	}
	
	public File getFile(String pathName)throws IllegalArgumentException, IOException{
		
		File file = null;
		
		if(StringUtils.isNotBlank(pathName)){
			
			file = new File(pathName);
			
			FileOutputStream fout = new FileOutputStream(file);
			
			fout.write(arquivoByteStream.toByteArray());
			
			fout.flush();
			fout.close();
			
		}else{
			IllegalArgumentException e = new IllegalArgumentException("Path File [ "+pathName+" ] não permitido !");
			log.error("Valor Não Permitido!",e);
			throw e;
		}
		
		return file;
	}
	
	public ByteArrayOutputStream getStream() throws IOException{
		
		ByteArrayOutputStream outPuted = null;
		
		outPuted = new ByteArrayOutputStream();
		
		outPuted.write(arquivoByteStream.toByteArray());
		
		return outPuted;
	}
	
	public byte[] getBytes(){
		return arquivoByteStream.toByteArray();
	}

}
