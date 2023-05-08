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

package dev.cru.context;

import static org.assertj.core.api.Assertions.assertThat;

import dev.cru.context.k8s.K8sNeedleExtractor;
import dev.cru.context.k8s.K8sResourceType;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import org.junit.jupiter.api.Test;

class K8sNeedleExtractorTest {

	@Test
	void name() throws IOException {
		K8sTestLocation k8sTestLocation = new K8sTestLocation(
			Path.of("src", "test", "resources", "K8s", "patch-resources.yaml")
		);
		Set<K8sNeedleExtractor.Match> matches = new K8sNeedleExtractor().extractLinesFrom(k8sTestLocation);

		assertThat(matches)
			.contains(
				new K8sNeedleExtractor.Match("container_one", "Cluster1", "670m", K8sResourceType.Cpu),
				new K8sNeedleExtractor.Match("container_one", "Cluster1", "1021Mi", K8sResourceType.Memory),
				new K8sNeedleExtractor.Match("container_two", "Cluster1", "298m", K8sResourceType.Cpu),
				new K8sNeedleExtractor.Match("container_two", "Cluster1", "40Mi", K8sResourceType.Memory)
			);
	}
}
