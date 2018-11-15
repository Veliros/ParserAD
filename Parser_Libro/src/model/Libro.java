package model;

import java.io.Serializable;

/**
 *  LIBRO
 * @author marta
 *
 */
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	String titulo = null, editor = null;
	String autores = null;
	int numPag;
	int anyo;
		 
		 
	/**
	* 
	* @param identificador
	* @param titulo
	* @param autor
	* @param editor
	* @param numeroDePaginas
	* @param anyoDePublicacion
	*/
	public Libro(String titulo, String autor, String editor, int numeroDePaginas,
				int anyoDePublicacion) {
		super();
		this.titulo = titulo;
		this.editor = editor;
		this.numPag = numeroDePaginas;
		this.anyo = anyoDePublicacion;	
		this.autores = autor;
	}
	
	/**
	 * Método toString con todos los campos de libros.
	 */
	public String toString() {
		String datos = "Título: " + titulo + "\nAutor: " + autores + "\nEditor: " + editor + 
				"\nPáginas: " + numPag + "\nPublicación: " + anyo;
		
		return datos;
	}	
	
//	public StringBuilder listaAutores(ArrayList<String> noms){
//		StringBuilder sb = new StringBuilder();
//		if(autores != null) {
//		java.util.Iterator<String> it = noms.iterator();
//		
//		while(it.hasNext()) {
//			sb.append(it.next());
//		}
//		} else sb.append("no entra");
//		
//		return sb;
//		
//	}
		
		/**
		 * 
		 * @return titulo
		 */
		public String getTitulo() {
			return titulo;
		}
		
		/**
		 * 
		 * @param titulo
		 */
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		
		/**
		 * 
		 * @return editor
		 */
		public String getEditor() {
			return editor;
		}
		
		/**
		 * 
		 * @param editor
		 */
		public void setEditor(String editor) {
			this.editor = editor;
		}
		
		/**
		 * 
		 * @return numPag
		 */
		public int getNumeroDePaginas() {
			return numPag;
		}
		
		/**
		 * 
		 * @param numeroDePaginas
		 */
		public void setNumeroDePaginas(int numeroDePaginas) {
			this.numPag = numeroDePaginas;
		}
		
		/**
		 * 
		 * @return anyo
		 */
		public int getAnyoDePublicacion() {
			return anyo;
		}
		
		/**
		 * 
		 * @param anyoDePublicacion
		 */
		public void setAnyoDePublicacion(int anyoDePublicacion) {
			this.anyo = anyoDePublicacion;
		}

		public String getAutores() {
			return autores;
		}

		public void setAutores(String autores) {
			this.autores = autores;
		}
		


}
