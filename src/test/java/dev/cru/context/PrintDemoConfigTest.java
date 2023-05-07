package dev.cru.context;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import dev.cru.conf.RepoConfig;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrintDemoConfigTest {

	@Test
	void name() throws JsonProcessingException {
		RepoConfig config = new RepoConfig(
			new RepoConfig.K8s(
				List.of(
					new RepoConfig.K8sLocation("kustomize/overlays/prod/patch-resources.yaml", "prod-clsuter", "prod-namespace", null, null),
					new RepoConfig.K8sLocation("kustomize/overlays/non-prod/patch-resources.yaml", "prod-clsuter", "non-prod-cluster", null, null)
				)
			),
			null
		);

		System.out.println(new ObjectMapper(new YAMLFactory()).writerWithDefaultPrettyPrinter().writeValueAsString(config));

	}
}
