package javamag.dao;

import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;

import javamag.model.Profile;


public interface ProfileDao {
	@PreAuthorize("hasRole('MEMBER')")
	public abstract Set<String> getAllLogins();

	@PreAuthorize("hasRole('MEMBER')")
	public abstract Profile findByName(String name);

	@PreAuthorize("hasPermission(#p,'WRITE')")
	public abstract void store(Profile p);
}
