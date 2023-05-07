package dev.cru.context.k8s;

public record K8sRecommendation(String container, String cluster, String value, K8sResourceType resourceType) {}
