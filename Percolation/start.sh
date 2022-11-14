function javac() {
	'/c/Program Files/Android/Android Studio/jre/bin/javac.exe' -cp '.;../algs4.jar' $@
}

function java() {
	'/c/Program Files/Android/Android Studio/jre/bin/java.exe' -cp '.;../algs4.jar' $@
}

javac PercolationVisualizer.java && java PercolationVisualizer eagle25.txt
javac InteractivePercolationVisualizer.java && java InteractivePercolationVisualizer 3
