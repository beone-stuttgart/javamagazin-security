package javamag.dao;

import java.util.Set;

import javax.annotation.security.RolesAllowed;

import javamag.model.Profile;


public interface ProfileDao {
	@RolesAllowed("MEMBER")
	public abstract Set<String> getAllLogins();

	@RolesAllowed("MEMBER")
	public abstract Profile findByName(String name);

	@RolesAllowed("MEMBER")
	public abstract void store(Profile p);
}
