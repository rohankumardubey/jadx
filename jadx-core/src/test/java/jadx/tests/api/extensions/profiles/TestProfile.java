package jadx.tests.api.extensions.profiles;

import java.util.function.Consumer;

import jadx.tests.api.IntegrationTest;

public enum TestProfile implements Consumer<IntegrationTest> {
	DX_J8("dx-java-8", test -> {
		test.useTargetJavaVersion(8);
		test.useDexInput();
	}),
	D8_J11("d8-java-11", test -> {
		test.useTargetJavaVersion(11);
		test.useDexInput();
	}),
	JAVA8("java-8", test -> {
		test.useTargetJavaVersion(8);
		test.useJavaInput();
	}),
	JAVA11("java-11", test -> {
		test.useTargetJavaVersion(11);
		test.useJavaInput();
	});

	private final String description;
	private final Consumer<IntegrationTest> setup;

	TestProfile(String description, Consumer<IntegrationTest> setup) {
		this.description = description;
		this.setup = setup;
	}

	@Override
	public void accept(IntegrationTest integrationTest) {
		this.setup.accept(integrationTest);
	}

	public String getDescription() {
		return description;
	}
}
