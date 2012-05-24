package javamag.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
		data.put(p.getLogin(), p);
	}
	
	public static ProfileDao getInstance() {
		return inst;
	}
}
