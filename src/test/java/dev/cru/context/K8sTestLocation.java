package dev.cru.context;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;

public class K8sTestLocation implements Location {

	private final String location;

	private final String fileContent;

	public K8sTestLocation(Path location) throws IOException {
		this.location = location.toString();

		fileContent = Files.readString(location);
	}

	@Override
	public String path() {
		return location;
	}

	@Override
	public String fileContent() {
		return fileContent;
	}

	@Override
	public boolean isVirtual() {
		return false;
	}
}
