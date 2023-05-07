package dev.cru.context.k8s;

import dev.cru.conf.Environment;

public class K8sResourceUpdater {

	private final K8sNeedleExtractor needleExtractor = new K8sNeedleExtractor();

	private final Environment environment = new Environment();
}
