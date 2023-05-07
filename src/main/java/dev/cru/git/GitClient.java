package dev.cru.git;

import java.nio.file.Path;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class GitClient {

	private final Git instance;

	public GitClient(String uri, Path temporaryFolder) {
		CloneCommand cloneCommand = Git.cloneRepository().setURI(uri).setDirectory(temporaryFolder.toFile()).setDepth(1);

		try (Git git = cloneCommand.call()) {
			this.instance = git;
		} catch (GitAPIException e) {
			throw new RuntimeException(e);
		}
	}
}
