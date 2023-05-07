package dev.cru.conf;

public final class Environment {

	private static final String GITLAB_USE = "GITLAB_USE";

	private boolean gitlabUse = false;

	private static final String GITLAB_URL = "GITLAB_URL";

	private String gitlabUrl = "https://gitlab.com";

	private static final String GITLAB_TOKEN = "GITLAB_TOKEN";

	private String gitlabToken = "";

	private static final String USE_GITHUB = "USE_GITLAB";

	private boolean useGithub = false;

	public Environment() {
		gitlabUse = Boolean.parseBoolean(System.getenv(GITLAB_USE));
		gitlabUrl = System.getenv(GITLAB_URL);
		gitlabToken = System.getenv(GITLAB_TOKEN);

		useGithub = Boolean.parseBoolean(System.getenv(USE_GITHUB));
	}

	public boolean isGitlabUse() {
		return gitlabUse;
	}

	public String getGitlabUrl() {
		return gitlabUrl;
	}

	public String getGitlabToken() {
		return gitlabToken;
	}

	public boolean isUseGithub() {
		return useGithub;
	}
}
