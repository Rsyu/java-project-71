.PHONY: run-dist build run clean

# Установка дистрибутива в папке app/
run-dist:
	cd app && ./gradlew installDist
	./app/build/install/app/bin/app -h

# Сборка дистрибутива
build:
	cd app && ./gradlew installDist

# Запуск программы с JSON-файлами из app/
run: build
	./app/build/install/app/bin/app app/filepath1.json app/filepath2.json

# Очистка
clean:
	cd app && ./gradlew clean
