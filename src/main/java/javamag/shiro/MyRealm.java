package javamag.shiro;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAccount;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class MyRealm extends AuthorizingRealm {
	Map<String,SimpleAccount> accounts = new HashMap<String,SimpleAccount>();
	public MyRealm() {
		super();
		addAccount("admin", "admin", new String[]{"admin","member"}, new String[]{"*"});
		addAccount("adam", "abc", new String[]{"member"}, new String[]{"profile:read:*","profile:write:SELF"});
		addAccount("eva", "123", new String[]{"member"}, new String[]{"profile:read:*","profile:write:SELF"});
	}

	private void addAccount(String username, String password, String[] roles, String[] permissions) {
		SimpleAccount account = new SimpleAccount(username, password, getName());
		for(String r: roles) {
	    	account.addRole(r);
		}
		for(String p: permissions) {
	    	account.addStringPermission(p);
		}
    	accounts.put(username, account);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = principals.getPrimaryPrincipal().toString();
		return accounts.get(username);
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		if (!(token instanceof UsernamePasswordToken)) {
			return null;
		}
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        SimpleAccount account = accounts.get(upToken.getUsername());
        if (account==null) {
        	return null;
        }
        String password = new String(upToken.getPassword());
        if (!password.equals(account.getCredentials())) {
    		return null;
        }
    	return account;
	}
}
