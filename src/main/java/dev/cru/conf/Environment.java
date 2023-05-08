/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

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
