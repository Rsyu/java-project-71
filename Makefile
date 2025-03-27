.PHONY: build test lint run

build:
	cd app && ./gradlew build

test:
	cd app && ./gradlew test

lint:
	cd app && ./gradlew checkstyleMain checkstyleTest

run:
	cd app && ./build/install/app/bin/app


# Команда для установки проекта и запуска с скомпилированными файлами
run-dist:
	cd app && ./gradlew installDist
	cd app && ./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

