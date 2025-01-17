plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.spikart"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.1.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter")

	// test
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// from old Zosh branch

	 implementation("org.springframework.boot:spring-boot-starter-security")
	 implementation("org.springframework.boot:spring-boot-starter-validation")
	 implementation("org.springframework.boot:spring-boot-starter-web")

	 developmentOnly("org.springframework.boot:spring-boot-devtools")

	implementation("io.jsonwebtoken:jjwt-api:0.11.1")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.1")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.1")

	// test from Zosh
	// testImplementation("org.springframework.security:spring-security-test")

	/*
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.3.0")
	implementation("org.springframework.boot:spring-boot-starter-security:3.2.6")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation:3.3.0")
	implementation("org.springframework.boot:spring-boot-starter-web:3.2.6")

	implementation("io.jsonwebtoken:jjwt-api:0.11.1")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.1")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.1")

	// implementation("mysql:mysql-connector-java:8.0.31")
	implementation("org.mariadb.jdbc:mariadb-java-client:3.3.3")

	developmentOnly("org.springframework.boot:spring-boot-devtools:3.3.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.10.2")
	* */
}

tasks.withType<Test> {
	useJUnitPlatform()
}
