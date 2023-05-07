package dev.cru.context.k8s;

import dev.cru.context.Location;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class K8sNeedleExtractor {

	private final Pattern cpuPattern = Pattern.compile(
		"cru: container=(?<container>.*) cluster=(?<cluster>.*)\\n\\s*cpu: (?<cpu>\\S*)"
	);
	private final Pattern memoryPattern = Pattern.compile(
		"cru: container=(?<container>.*) cluster=(?<cluster>.*)\\n\\s*memory: (?<memory>\\S*)"
	);

	public Set<Match> extractLinesFrom(Location location) {
		Set<Match> result = new HashSet<>();

		for (Matcher cpuMatcher = cpuPattern.matcher(location.fileContent()); cpuMatcher.find();) {
			result.add(
				new Match(
					cpuMatcher.group("container"),
					cpuMatcher.group("cluster"),
					cpuMatcher.group("cpu"),
					K8sResourceType.Cpu
				)
			);
		}

		for (Matcher memoryMatcher = memoryPattern.matcher(location.fileContent()); memoryMatcher.find();) {
			result.add(
				new Match(
					memoryMatcher.group("container"),
					memoryMatcher.group("cluster"),
					memoryMatcher.group("memory"),
					K8sResourceType.Memory
				)
			);
		}

		return result;
	}

	public record Match(String container, String namespace, String value, K8sResourceType resourceType) {}
}
