
/*
This Java source file was generated by test-to-java.xsl
and is a derived work from the source document.
The source document contained the following notice:



Copyright (c) 2001 World Wide Web Consortium, 
(Massachusetts Institute of Technology, Institut National de
Recherche en Informatique et en Automatique, Keio University).  All 
Rights Reserved.  This program is distributed under the W3C's Software
Intellectual Property License.  This program is distributed in the 
hope that it will be useful, but WITHOUT ANY WARRANTY; without even
the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
PURPOSE.  

See W3C License http://www.w3.org/Consortium/Legal/ for more details.


*/

package org.w3c.domts.level2.core;

import org.w3c.dom.*;


import org.w3c.domts.DOMTestCase;
import org.w3c.domts.DOMTestDocumentBuilderFactory;



/**
 *     The "createAttributeNS(namespaceURI,qualifiedName)" method for a 
 *    Document should raise INVALID_CHARACTER_ERR DOMException
 *    if qualifiedName contains an illegal character.
 *    
 *    Invoke method createAttributeNS(namespaceURI,qualifiedName) on this document
 *    with qualifiedName containing an illegal character from illegalChars[].
 *    Method should raise INVALID_CHARACTER_ERR DOMException for all
 *    characters in illegalChars[].
* @author NIST
* @author Mary Brady
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS">http://www.w3.org/TR/DOM-Level-2-Core/core#ID-DocCrAttrNS</a>
* @see <a href="http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])">http://www.w3.org/TR/DOM-Level-2-Core/core#xpointer(id('ID-DocCrAttrNS')/raises/exception[@name='DOMException']/descr/p[substring-before(.,':')='INVALID_CHARACTER_ERR'])</a>
*/
public final class createAttributeNS03 extends DOMTestCase {

   /**
    * Constructor.
    * @param factory document factory, may not be null
    * @throws org.w3c.domts.DOMTestIncompatibleException Thrown if test is not compatible with parser configuration
    */
   public createAttributeNS03(final DOMTestDocumentBuilderFactory factory)  throws org.w3c.domts.DOMTestIncompatibleException {
      super(factory);

    //
    //   check if loaded documents are supported for content type
    //
    String contentType = getContentType();
    preload(contentType, "staffNS", false);
    }

   /**
    * Runs the test case.
    * @throws Throwable Any uncaught exception causes test to fail
    */
   public void runTest() throws Throwable {
      String namespaceURI = "http://www.wedding.com/";
      String qualifiedName;
      Document doc;
      Attr newAttr;
      java.util.List illegalQNames = new java.util.ArrayList();
      illegalQNames.add("person:{");
      illegalQNames.add("person:}");
      illegalQNames.add("person:~");
      illegalQNames.add("person:'");
      illegalQNames.add("person:!");
      illegalQNames.add("person:@");
      illegalQNames.add("person:#");
      illegalQNames.add("person:$");
      illegalQNames.add("person:%");
      illegalQNames.add("person:^");
      illegalQNames.add("person:&");
      illegalQNames.add("person:*");
      illegalQNames.add("person:(");
      illegalQNames.add("person:)");
      illegalQNames.add("person:+");
      illegalQNames.add("person:=");
      illegalQNames.add("person:[");
      illegalQNames.add("person:]");
      illegalQNames.add("person:\\");
      illegalQNames.add("person:/");
      illegalQNames.add("person:;");
      illegalQNames.add("person:`");
      illegalQNames.add("person:<");
      illegalQNames.add("person:>");
      illegalQNames.add("person:,");
      illegalQNames.add("person:a ");
      illegalQNames.add("person:\"");
      
      doc = (Document) load("staffNS", false);
      for (int indexN10090 = 0; indexN10090 < illegalQNames.size(); indexN10090++) {
          qualifiedName = (String) illegalQNames.get(indexN10090);
    
      {
         boolean success = false;
         try {
            newAttr = doc.createAttributeNS(namespaceURI, qualifiedName);
          } catch (DOMException ex) {
            success = (ex.code == DOMException.INVALID_CHARACTER_ERR);
         }
         assertTrue("throw_INVALID_CHARACTER_ERR", success);
      }
  }
      }
   /**
    *  Gets URI that identifies the test.
    *  @return uri identifier of test
    */
   public String getTargetURI() {
      return "http://www.w3.org/2001/DOM-Test-Suite/level2/core/createAttributeNS03";
   }
   /**
    * Runs this test from the command line.
    * @param args command line arguments
    */
   public static void main(final String[] args) {
        DOMTestCase.doMain(createAttributeNS03.class, args);
   }
}

