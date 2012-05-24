package javamag.springsecurity;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class OwnAuthProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
		String password = (String)token.getCredentials();
		boolean isAuthenticated = false;
		Collection<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		if (token.getName().equals("admin") && password.equals("admin")) {
			isAuthenticated = true;
			auths.add(new SimpleGrantedAuthority("MEMBER"));
			auths.add(new SimpleGrantedAuthority("ADMIN"));
		}
		if (token.getName().equals("adam") && password.equals("abc")) {
			isAuthenticated = true;
			auths.add(new SimpleGrantedAuthority("MEMBER"));
		}
		if (token.getName().equals("eva") && password.equals("123")) {
			isAuthenticated = true;
			auths.add(new SimpleGrantedAuthority("MEMBER"));
		}
		if (!isAuthenticated) {
			throw new BadCredentialsException("Wrong username or password");
		}
		return new UsernamePasswordAuthenticationToken(token.getName(), password, auths);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
