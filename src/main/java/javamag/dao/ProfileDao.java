package javamag.dao;

import java.util.Set;

import javamag.model.Profile;


public interface ProfileDao {
	public abstract Set<String> getAllLogins();

	public abstract Profile findByName(String name);

	public abstract void store(Profile p);
}