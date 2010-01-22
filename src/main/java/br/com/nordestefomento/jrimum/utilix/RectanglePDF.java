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
 * Created at: 30/03/2008 - 12:57:00
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
 * Criado em: 30/03/2008 - 12:57:00
 * 
 */

package br.com.nordestefomento.jrimum.utilix;

import com.lowagie.text.Rectangle;

/**
 * 
 * <p>
 * Classe adapter para facilitar as operações com os fields pdf com a lib iText.
 * </p>
 * 
 * @author <a href=http://gilmatryx.googlepages.com/>Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */

public class RectanglePDF extends Rectangle {

	private int page;

	/**
	 * For each of this groups the values are: [page, llx, lly, urx, ury].
	 */
	public RectanglePDF(float[] positions) {
		super(positions[1], positions[2], positions[3], positions[4]);
		page = (int) positions[0];
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public RectanglePDF(float arg0, float arg1, float arg2, float arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public RectanglePDF(float arg0, float arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public RectanglePDF(Rectangle arg0) {
		super(arg0);
	}

	/**
	 * @return page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @return llx - lower left x
	 */
	public float getLowerLeftX() {
		return this.llx;
	}

	/**
	 * @return lly - lower left y
	 */
	public float getLowerLeftY() {
		return lly;
	}

	/**
	 * 
	 * @return urx - upper right x
	 */
	public float getUpperRightX() {
		return urx;
	}

	/**
	 * @return ury - upper right y
	 */
	public float getUpperRightY() {
		return ury;
	}

}
