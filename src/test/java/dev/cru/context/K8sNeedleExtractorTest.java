package dev.cru.context;

import static org.assertj.core.api.Assertions.assertThat;

import dev.cru.context.k8s.K8sNeedleExtractor;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

import dev.cru.context.k8s.K8sResourceType;
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
