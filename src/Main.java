import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Detta är en Java-fil som innehåller en lösning på att hämta ett värde från
 * XML-fil och skriva till en annan.
 * Uppgiften går ut på att hämta värdet i elementet 'target' med attributet 'id'
 * 42007 och skriva det till en fil.
 *
 * Författare: Jagtej Sidhu
 * Datum: 2023-07-24
 */

public class Main {

    public static void main(String[] args) {

        try {
            String transUnitId = "42007";
            String filePath = "src\\sma_gentext.xml";
            String outputFile = "output.txt";

            NodeList transUnitsElements = GetTransUnitList(filePath);
            String targetValue = FindTargetValue(transUnitsElements, transUnitId);

            if (targetValue.length() == 0) {
                System.out.println("Kunde inte läsa targetValue");
                return;
            }

            WriteToFile(targetValue, outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Get the Node list of trans-units.
     *
     * @param filePath
     * @return Node List of trans-units.
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    private static NodeList GetTransUnitList(String filePath)
            throws ParserConfigurationException, IOException, SAXException {
        // Skapar en instans av DocumentBuilderFactory.
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        // Skapar en DocumentBuilder för att senare analysera(parse) XML-filen
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        // Analyserar(parse) XML-filen och skapar ett Document-objekt
        Document doc = documentBuilder.parse(new File(filePath));

        // Returnerar en Node List med trans-unit-elementen.
        return doc.getElementsByTagName("trans-unit");
    }

    /**
     * Find the target value from the trans-unit list.
     *
     * @param transUnitsElements
     * @param transUnitId
     * @return Value of target element
     */
    public static String FindTargetValue(NodeList transUnitsElements, String transUnitId) {
        String targetValue = "";
        for (int index = 0; index < transUnitsElements.getLength(); index++) {
            // Omvandlar till Element då trans-unit-elementet är av typen
            // 'org.w3c.dom.Element' för att kunna arbeta med elementet
            Element transUnit = (Element) transUnitsElements.item(index);
            String id = transUnit.getAttribute("id");

            // Hämta värdet från elementet 'target', ifall id är lika med transUnitId.
            if (id.equals(transUnitId)) {
                targetValue = transUnit.getElementsByTagName("target").item(0).getTextContent();
                break; // Ingen anledning att fortsätta loopen när vi har hittat det vi söker.
            }
        }
        return targetValue;
    }

    /**
     * Writes targetValue to given file.
     *
     * @param targetValue
     * @throws IOException
     */
    private static void WriteToFile(String targetValue, String outputFile) throws IOException {
        // Skriver värdet från targetValue till en fil med OutputStreamWriter,
        // samt hjälp av FileOutputStream som antingen skapar en ny fil eller
        // överskrider befintlig fil.
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)) {
            outputStreamWriter.write(targetValue);
        }
    }

}

