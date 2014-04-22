package bugtracker;

import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;

public interface IXmlManager {
    
    /**
     * Function create new XML file in specified path
     * 
     * @param filePath path for new XML file 
     * @return StreamResult XML file handler
     */
    public StreamResult writeContentXMLfile(String filePath);
    
    /**
     * Function creates new attribute with specified value 
     * 
     * @param attributeName name of node attribute to create
     * @param element Element to set attribute for
     * @param attributeValue value of newly created attribute
     */
    public void setAttribute(String attributeName, String attributeValue, Element element);
    
    /**
     * Function add new element
     * 
     * @param elementName specify name of new element
     * @param base specify base element of new element
     * @param value
     * @return Element reference to newly created element\
     */
    public Element addElement(String elementName, Element base, String value);
    
}
