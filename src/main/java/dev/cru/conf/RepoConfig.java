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

import java.util.List;

public record RepoConfig(K8s k8s, Aws aws) {
	public record K8s(List<K8sLocation> location) {}

	public record Aws(String account, List<AwsLocation> location) {}

	public record K8sLocation(
		String path,
		String cluster,
		String namespace,
		String cpuDifference,
		String memDifference
	) {}

	public record AwsLocation(String path, String identifier) {}
}
