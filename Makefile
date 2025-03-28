.PHONY: build clean test lint run run-dist report

build:
	cd app && ./gradlew build

clean:
	cd app && ./gradlew clean build

test:
	cd app && ./gradlew test

lint:
	cd app && ./gradlew checkstyleMain checkstyleTest || true

run:
	cd app && ./build/install/app/bin/app $(ARGS)

run-dist:
	cd app && ./gradlew installDist
	cd app && ./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.yml

report:
	cd app && ./gradlew jacocoTestReport
