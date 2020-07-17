package rs.ac.uns.zuul;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AuthFilter extends ZuulFilter {

//    @Autowired
//    private AuthClient authClient;

//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();

        // Alter ignored headers as per: https://gitter.im/spring-cloud/spring-cloud?at=56fea31f11ea211749c3ed22
        Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
        // We need our JWT tokens relayed to resource servers
        headers.remove("authorization");

        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10000;
    

//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        if (request.getHeader("Authorization") == null) {
//        	   ctx.addZuulRequestHeader("YYYYYYYYYYYYYYYYYYYYYYY", "3333333333333333333333333333333333333");
//        	
//        	
//        	
//        	System.out.println("yyyyyyyyyyyyyyyyyy authorization je null" );
//        	
//        	Enumeration<String> headerNames = request.getHeaderNames();
//    		System.out.println("---------------- all headers -------------");
//    		while (headerNames.hasMoreElements()) {
//    			String headerName = headerNames.nextElement();
//    			System.out.println("------");
//    			System.out.println("Header Name: " + headerName);
//    			String headerValue = request.getHeader(headerName);
//    			System.out.println("Header Value: " + headerValue);
//    			
//    		}
//    		System.out.println("---------------- all headers -------------");
//        	
//        	
//            return null;
//        };
//
//        String jwtToken= request.getHeader("Authorization");
//        System.out.println("xxxxxxxxxxxxx" +jwtToken);
//        
//        
//    	Enumeration<String> headerNames = request.getHeaderNames();
//		System.out.println("---------------- all headers -------------");
//		while (headerNames.hasMoreElements()) {
//			String headerName = headerNames.nextElement();
//			System.out.println("------");
//			System.out.println("Header Name: " + headerName);
//			String headerValue = request.getHeader(headerName);
//			System.out.println("Header Value: " + headerValue);
//			
//		}
//		System.out.println("---------------- all headers -------------");
//		
//		
		
		
		
		
		
		
		
		
		
//        ctx.addZuulRequestHeader("Authorization", jwtToken);
//        ctx.addZuulRequestHeader("Authorizationaaaaaaaaaaaaaaa", "2222222222222222222222222222");
//        
//        
//        
//        
        
        
        
        
        
        
        
        
//        ctx.addZuulResponseHeader("Authorization", jwtToken);
//        try {
//            authClient.verify(jwtToken);
//
////            ctx.addZuulRequestHeader("username", email);
////            ctx.addZuulRequestHeader("role", "SIMPLE_USER");
//
//        } catch (FeignException.NotFound e) {
//            setFailedRequest("Consumer does not exist!", 403);
//        }

//        return null;
    }


}
