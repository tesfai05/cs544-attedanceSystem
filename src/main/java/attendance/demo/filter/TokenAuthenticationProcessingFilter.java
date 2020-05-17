package attendance.demo.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import org.springframework.stereotype.Component;

@Component
public class TokenAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
    public TokenAuthenticationProcessingFilter(@Value("/courses") String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
		return null;
    
    }

//    private String obtainPassword(HttpServletRequest request) {
//        return request.getParameter("password");
//    }
//
//    private String obtainUsername(HttpServletRequest request) {
//        return request.getParameter("username");
//    }

    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

//    @Autowired
//    @Override
//    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
//        super.setAuthenticationSuccessHandler(successHandler);
//    }
//
//    @Autowired
//    @Override
//    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
//        super.setAuthenticationFailureHandler(failureHandler);
//    }
}
