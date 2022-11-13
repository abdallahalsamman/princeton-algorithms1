function javac() {
	'/c/Program Files/Android/Android Studio/jre/bin/javac.exe' -cp '.;../algs4.jar' $@
}

function java() {
	'/c/Program Files/Android/Android Studio/jre/bin/java.exe' -cp '.;../algs4.jar' $@
}

javac HelloWorld.java && java HelloWorld
javac HelloGoodbye.java && java HelloGoodbye Abdullah Habeeb
javac RandomWord.java && java RandomWord < animals8.txt
