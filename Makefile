run-dist:
	cd app && ./gradlew installDist
	./app/build/install/app/bin/app -h

compare:
	./app/build/install/app/bin/app ./app/file1.json ./app/file2.json