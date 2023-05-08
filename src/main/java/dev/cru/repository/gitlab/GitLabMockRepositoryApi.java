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

package dev.cru.repository.gitlab;

import dev.cru.conf.RepoConfig;
import dev.cru.conf.Repository;
import dev.cru.context.Location;
import dev.cru.repository.RepositoryApi;
import java.util.List;

public class GitLabMockRepositoryApi implements RepositoryApi {

	@Override
	public Iterable<Repository> findRepositories() {
		return List.of(
			new Repository(
				"12345",
				new RepoConfig(
					new RepoConfig.K8s(
						List.of(
							new RepoConfig.K8sLocation(
								"kustomize/overlays/prod/patch-resources.yaml",
								"prod-clsuter",
								"prod-namespace",
								null,
								null
							),
							new RepoConfig.K8sLocation(
								"kustomize/overlays/non-prod/patch-resources.yaml",
								"prod-clsuter",
								"non-prod-cluster",
								null,
								null
							)
						)
					),
					null
				)
			)
		);
	}

	@Override
	public Iterable<Location> readLocationsFrom(Repository repository) {
		return null;
	}
}
