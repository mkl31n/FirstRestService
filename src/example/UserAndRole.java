package example;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.spi.StringReader;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by michaelklein on 10/12/15.
 */
// The Java class will be hosted at the URI path "/userandrole"
@Path("/userandrole")
public class UserAndRole {
    JDBCSelectEmployees employees = new JDBCSelectEmployees();
    @Path("/{param}")
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return String.valueOf(employees.runSample());
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();


        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/userandrole");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
