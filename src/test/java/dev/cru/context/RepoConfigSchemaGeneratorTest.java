package dev.cru.context;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.victools.jsonschema.generator.*;
import dev.cru.conf.RepoConfig;
import org.junit.jupiter.api.Test;

class RepoConfigSchemaGeneratorTest {

	@Test
	void name() {
		SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(
			SchemaVersion.DRAFT_2020_12,
			OptionPreset.PLAIN_JSON
		);
		SchemaGeneratorConfig config = configBuilder.build();
		SchemaGenerator generator = new SchemaGenerator(config);
		JsonNode jsonSchema = generator.generateSchema(RepoConfig.class);

		System.out.println(jsonSchema.toPrettyString());
	}
}
