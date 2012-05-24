package javamag.springsecurity;

import java.io.Serializable;

import javamag.model.Profile;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


public class OwnPermissionEvaluator implements PermissionEvaluator {
	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		// Admin: Darf alles
		for (GrantedAuthority ga: auth.getAuthorities()) {
			if ("ADMIN".equals(ga.getAuthority())) {
				return true;
			}
		}
		// Privilege auf Profile-Objekten
		if (targetDomainObject instanceof Profile) {
			if ("READ".equals(permission)) {
				for (GrantedAuthority ga: auth.getAuthorities()) {
					if ("MEMBER".equals(ga.getAuthority())) {
						return true;
					}
				}
			}
			if ("WRITE".equals(permission)) {
				Profile p = (Profile)targetDomainObject;
				String user = (String)auth.getPrincipal();
				if (p.getLogin().equals(user)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		return false;
	}

}
