package rs.ac.uns.zuul;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AuthFilter extends ZuulFilter {

	@Autowired
	private AuthClient authClient;

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
		// zuul does not send authorization header and you can't add it with
		// addZullRequestHeader

		// workaround : https://github.com/spring-cloud/spring-cloud-netflix/issues/944
		// Alter ignored headers as per:
		// https://gitter.im/spring-cloud/spring-cloud?at=56fea31f11ea211749c3ed22
		Set<String> headers = (Set<String>) ctx.get("ignoredHeaders");
		// We need our JWT tokens relayed to resource servers
		headers.remove("authorization");

		String s = ctx.getRequest().getRequestURI();
		if (!s.contains("api") && !s.contains("user")) {
			try {
				System.out.println("zuul filter " + s);
				//we dont need send autorization to other microservices just to our aut-s for verification
				//so we will send jwt as argument of verify method
//				ctx.addZuulRequestHeader("newauthheader", ctx.getRequest().getHeader("authorization"));
//				authClient.verify(ctx.getRequest());
				
				System.out.println("passing authorization zuul filter " + ctx.getRequest().getHeader("authorization"));
				

				ArrayList<String> authAndMail = authClient.verify(ctx.getRequest().getHeader("authorization"));
				
				System.out.println("Zuul AuthFilter user authority:_"+ authAndMail.get(0));
				System.out.println("Zuul AuthFilter user username(we use email as username):_"  + authAndMail.get(1));
	            ctx.addZuulRequestHeader("username", authAndMail.get(1));
	            ctx.addZuulRequestHeader("role", authAndMail.get(0));
				
			} catch (Exception e) {
				System.out.println("Verification error " + e);
				e.printStackTrace();
			}

		}

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

	}

}















