JAVA = java
JAVAC = javac

build: *.java
	$(JAVAC) $^
clean: *.class
	rm -rf $^

