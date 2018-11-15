package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Parser {	
	private Document dom = null;
	private ArrayList<Libro> libro = null;

	/**
	 * CONSTRUCTOR
	 */
	public Parser() {
	   libro = new ArrayList<Libro>();
	}

	/**
	 * Método para parsear.
	 * 
	 * @param fichero
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public void parseFicheroXml(String fichero) throws ParserConfigurationException, SAXException, IOException {
	    // creamos una factory
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	      
	    //Forzar UTF-8 al fichero:
	    InputStream inputStream= new FileInputStream(fichero);
	    Reader rd = new InputStreamReader(inputStream, "UTF-8");
	      
	    InputSource is = new InputSource(rd);
	      
	    is.setEncoding("UTF-8");
	      
	      //Representación DOM del parseo de XML una vez forzado a UTF-8.
	    dom = db.parse(is);

	  }

	
	  /**
	   * Parseo del Documento XML.
	   */
	  public void parseDocument() {
	    // Elemento raíz:
	    Element doc = dom.getDocumentElement();
	    // Nodelist de elementos:
	    NodeList nl = doc.getElementsByTagName("libro");
	      
	    if (nl != null && nl.getLength() > 0) {
	      for (int i = 0; i < nl.getLength(); i++) {        
	        // Elemento de libro.
	        Element el = (Element) nl.item(i);
	        // Objeto de libro añadido al Array.
	        Libro p = getLibro(el);
	        libro.add(p);
	      }
	    }
	  }
	  
	  
	 /**
	  * Recuperar libro. 
	  * @param libro
	  * @return
	  */
	 private Libro getLibro(Element libro){
	    String editor = getTextValue(libro,"editor"),
	    	   titulo = getTextValue(libro,"titulo");
	    	
	    
	    NodeList autores = libro.getElementsByTagName("nombre");
	    String lista = "";
	    
	    for (int i = 0; i < autores.getLength(); i++) { 
	    	Element e = (Element) autores.item(i);
	    	lista += "- " + e.getFirstChild().getNodeValue() + " -";        	
	    }
	    

	    int paginas = getIntValue(libro,"paginas"),
	    	anyo = Integer.parseInt(getAtributeValue(libro,"titulo"));  
	    
	    Libro lib = new Libro(titulo, lista, editor, paginas, anyo);

	    return lib; 
		 
		 }
	    
	  
	  
	  /**
	   *  Valor dentro de la respectiva etiqueta.
	   *  
	   * @param ele
	   * @param tagName
	   * @return
	   */
	  private String getTextValue(Element ele, String tagName) {
	    String textVal = null;
	    NodeList nl = ele.getElementsByTagName(tagName);
	    
	    if(nl != null && nl.getLength() > 0) {
	      Element el = (Element)nl.item(0);
	      textVal = el.getFirstChild().getNodeValue();
	    }  
	    
	    return textVal;
	  }
	  
	  
	  /**
	   *  Obtener atributo.
	   *  
	   * @param ele
	   * @param tagName
	   * @return
	   */
	  private String getAtributeValue(Element ele, String tagName) {
	    String textVal = null;
	    NodeList nl = ele.getElementsByTagName(tagName);
	    
	    if(nl != null && nl.getLength() > 0) {
	      Element el = (Element)nl.item(0);
	      textVal = el.getAttribute("anyo");
	    }    
	    
	    return textVal;
	  }
	  
	  /**
	   *  Obtención del valor en formato de Integer.
	   *  
	   * @param ele
	   * @param tagName
	   * @return
	   */
	  private int getIntValue(Element ele, String tagName) {        
	    return Integer.parseInt(getTextValue(ele,tagName));
	  }
	  
	
	  /**
	   * Print de libros
	   */
	  public void printLibro() {
		Iterator<Libro> it = libro.iterator();
		StringBuilder sb = new StringBuilder();
		
		while(it.hasNext()) {
		 Libro l = it.next();
	     sb.append(l.toString() + "\n\n");
	     
	    }
		
		System.out.println(sb);;	
	  }


}

