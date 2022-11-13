'/c/Program Files/Android/Android Studio/jre/bin/javac.exe' -cp '.;algs4.jar' $@
'/c/Program Files/Android/Android Studio/jre/bin/java.exe' -cp '.;algs4.jar' $(echo $@ | cut -d'.' -f1) < animals8.txt
