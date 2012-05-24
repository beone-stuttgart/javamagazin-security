package javamag.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;

import javamag.model.Profile;


public class ProfileDaoImpl implements ProfileDao {
	private Map<String,Profile> data = new HashMap<String,Profile>();
	private static ProfileDaoImpl inst = new ProfileDaoImpl();

	public ProfileDaoImpl()  {
		data.put("admin", new Profile("admin", "Administrator", "Bin hier der Chef"));
		data.put("adam", new Profile("adam", "Adam Müller", "Hobbies: Hobbygärtner"));
		data.put("eva", new Profile("eva", "Eva Mayer", "Hobbies: Apfelzucht"));
	}

	@Override
	public Set<String> getAllLogins() {
		return data.keySet();
	}

	@Override
	public Profile findByName(String name) {
		Profile p = data.get(name);
		return new Profile(p.getLogin(), p.getName(), p.getDescription());
	}

	@Override
	public void store(Profile p) {
		Subject currentUser = SecurityUtils.getSubject();
		String userName = currentUser.getPrincipal().toString();
		if (currentUser.isPermitted("profile:write:"+userName) ||
				(currentUser.isPermitted("profile:write:SELF") &&
						userName.equals(p.getLogin()))) {
			data.put(p.getLogin(), p);
		} else {
			throw new UnauthorizedException();
		}
	}

	public static ProfileDao getInstance() {
		return inst;
	}
}
