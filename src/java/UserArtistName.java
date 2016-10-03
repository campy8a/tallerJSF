/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.w3c.dom.Element;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author FCampy
 */

@Named(value = "UserArtistName")
@SessionScoped

public class UserArtistName implements Serializable {

    String nombre;
    String respuesta;

    public String getRespuesta() {
        return respuesta;
    }
    
     public UserArtistName() throws MalformedURLException, ProtocolException, IOException 
    {
      
    }
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getArtists(){
        
        String requestQueueName="";
        try {
            URL url = new URL("http://musicbrainz.org/ws/2/artist/?query=artist:"+nombre);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            String xml ="";
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
  System.out.println(output);
                xml += output;
                respuesta=xml;
            }
            conn.disconnect();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse(new InputSource(new StringReader(xml)));
            org.w3c.dom.Element rootElement = document.getDocumentElement();
            requestQueueName = getString("name", rootElement);
            System.out.println(requestQueueName);
          } catch (Exception e) {
            e.printStackTrace();
   }
        return respuesta;
    }

      protected String getString(String tagName, Element element) {
          respuesta="";
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            for(int i = 0; i < list.getLength(); i++){
               
                respuesta += list.item(i).getFirstChild().getNodeValue()+ "<br>";
            }
        }
        return respuesta;
    }
    
}
