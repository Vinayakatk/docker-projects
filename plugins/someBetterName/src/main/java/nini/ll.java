package nini;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ll {
public static void main(String[] args) throws IOException {
	System.out.println(System.getProperty("user.dir"));
	File file = new File(System.getProperty("user.dir"));
	ProcessBuilder directory = new ProcessBuilder().directory(file);
	System.out.println(directory.environment().get("DOCKER_TOOLBOX_INSTALL_PATH"));
	Process start = directory.command("C:\\\"Program Files\"\\\"Docker Toolbox\"\\docker-compose.exe up").start();
	
	
}
}
