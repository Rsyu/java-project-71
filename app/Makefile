# Команда для компиляции и запуска проекта через Gradle
run:
	./gradlew run

build:
	./gradlew build

clean:
	./gradlew clean

# Команда для установки проекта и запуска с скомпилированными файлами
run-dist:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/file1.json src/test/resources/file2.json

lint:
	./gradlew check

.PHONY: build
