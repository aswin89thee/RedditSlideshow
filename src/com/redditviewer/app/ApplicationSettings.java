package com.redditviewer.app;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ApplicationSettings {
	private static long maxPicLimit = 0L;
	private static long intervalInMillis = 5000L;
	
	public static void init(){
		//Initialize system settings by reading settings.xml file
		System.out.println("Inside init of SystemSettings");
//		SAXReader reader = new SAXReader();
//		Document document = null;
//        try {
//			document = reader.read("settings.xml");
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//        if(document != null){
//        	Element root = document.getRootElement();
//        	// iterate through child elements of root
//            for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
//                Element element = (Element) i.next();
//            }
//
//            // iterate through child elements of root with element name "foo"
//            for ( Iterator i = root.elementIterator( "property" ); i.hasNext(); ) {
//                Element foo = (Element) i.next();
//            }
//
//            // iterate through attributes of root 
//            for ( Iterator i = root.attributeIterator(); i.hasNext(); ) {
//                Attribute attribute = (Attribute) i.next();
//            }
//        }
        
	}
	
	public static long getMaxPicLimit(){
		return maxPicLimit;
	}
	public static long getIntervalInMillis(){
		return intervalInMillis;
	}
}
