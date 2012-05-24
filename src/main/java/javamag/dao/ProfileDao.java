package javamag.dao;

import java.util.Set;

import javamag.model.Profile;

import org.apache.shiro.authz.annotation.RequiresPermissions;


public interface ProfileDao {
	@RequiresPermissions("profile:read")
	public abstract Set<String> getAllLogins();

	@RequiresPermissions("profile:read")
	public abstract Profile findByName(String name);

	public abstract void store(Profile p);
}
