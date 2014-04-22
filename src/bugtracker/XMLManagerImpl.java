package bugtracker;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *
 * @author kalk
 */
public class XMLManagerImpl implements IXmlManager{
    
    private final String XMLTargetFilePath = "/afs/ericpol.int/home/k/a/kalk/home/NetBeansProjects/BugTracker/src/bugtracker/reports.xml";
    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;
    private Document doc;
    private StreamResult XMLFileHandler;
    

    /**
     * Function initiate abstract objects needed to work with XML  
     */
    public void initialize(){
        docFactory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        doc = docBuilder.newDocument();
    }
    
    public String getPath(){
        return this.XMLTargetFilePath;
    }
    
    @Override
    public StreamResult writeContentXMLfile(String filePath) {
                
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(filePath);
           
            transformer.transform(source, result);
            
            System.out.println("File saved!");
            
        } catch (TransformerException ex) {
            Logger.getLogger(XMLManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return XMLFileHandler;
    }

    @Override
    public void setAttribute(String attributeName, String attributeValue, Element element) {
        Attr attr = doc.createAttribute(attributeName);
	attr.setValue(attributeValue);
        element.setAttributeNode(attr);
    }

    @Override
    public Element addElement(String elementName, Element base, String value) {
        
        Element element = doc.createElement(elementName);
        
        if(base != null){
            
            if(value != null) element.appendChild(doc.createTextNode(value));
            
            base.appendChild(element);
            
        }else{
            
            if(value != null) doc.appendChild(doc.createTextNode(value));
            
            doc.appendChild(element);
        }
        
        return element;
    }
    
}
