/**
 *
 * @author pramod
 */
import com.plivo.helper.xml.elements.PlivoResponse;
import com.plivo.helper.xml.elements.Dial;
import com.plivo.helper.xml.elements.Number;
import spark.*;
import static spark.Spark.*;

public class DialXML {

    public static void main(String[] args) {
        //path with respect to root of the server
        get(new Route("/dialxml") {
            @Override
            public Object handle(Request rqst, Response rspns) {
                PlivoResponse response = new PlivoResponse();
                Dial dial = new Dial();
                
                Number number = new Number();
                // Set the number to be called
                number.setNumber("12345678901");

                // Set up dial
                dial.addNumber(number);
                dial.setAction("http://www.youractionurl.com/path");
                dial.setMethod("GET");

                // Make the final response
                response.addDial(dial);
                //return final serialized XML
                return response.serializeToXML(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
}
/*
the url for getting the  xml wiil be : http://www.yourserver.com/dialxml 

This will return XML like this:
<Response>
    <Dial action="http://www.youractionurl.com/path" method="GET">
        <Number>12345678901</Number>
    </Dial>
</Response>
*/
