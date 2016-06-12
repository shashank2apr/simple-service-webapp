package main.java.com.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemo {

	@GET
	@Path("annotation")
	public String getInjectDemo(@MatrixParam("matrixyear") String matrix,
							  @HeaderParam("custHeader") String header,
							  @CookieParam("JSESSIONID") String cookie){
		
		return "Matrix : " + matrix + ", Header : " + header +  ", Cookie : " + cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
		return "uriInfo : " + uriInfo.getAbsolutePath() + ", Headers : " + httpHeaders.getRequestHeaders().toString();
	}
}
