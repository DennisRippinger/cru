package dev.cru.conf;

import java.util.List;

public record RepoConfig(K8s k8s, Aws aws) {

	public record K8s(List<K8sLocation> location) {}

	public record Aws(String account, List<AwsLocation> location) {}

	public record K8sLocation(String path, String cluster, 	String namespace, String cpuDifference, String memDifference) {}

	public record AwsLocation(String path, String identifier) {}
}
