package dev.cru.context.k8s;

public final class ResourceParser {

	// TODO Layman Solution for first approach, replace with comparable data later.

	public static double parseMemory(String input) {
		return Double.parseDouble(input.replace("Mi", ""));
	}

	public static double parseCpu(String input) {
		return Double.parseDouble(input.replace("m", ""));
	}
}
