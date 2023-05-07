package dev.cru.repository;

import dev.cru.conf.RepoConfig;
import dev.cru.context.Location;

public interface RepositoryApi {
	RepoConfig findConfig();

	Location readLocation(String path);
}
