package org.eclipse.docker.language;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.text.html.StyleSheet.ListPainter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.ListImagesCmd;
import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;



public class test {
public static void main(String[] args) throws IOException {
	DockerClientConfig build = DockerClientConfig.createDefaultConfigBuilder().withDockerCertPath("C:\\Users\\vinio\\.docker\\machine\\certs").withUri("https://192.168.99.100:2376").build();
//	DockerClient build2 = DockerClientBuilder.getInstance("http:/).build();
	DockerClient build2 = DockerClientBuilder.getInstance(build).build();
ListImagesCmd withShowAll = build2.listImagesCmd().withShowAll(true);
withShowAll.exec().forEach(y->System.out.println(y.getId()));
CreateContainerResponse exec = build2.createContainerCmd("vinayaka").
withAttachStderr(true).withAttachStdin(true).
withAttachStdout(true).withCmd("--name=\"loper\"").
withName("lope").withImage("busybox").withCmd("sh").withExposedPorts(ExposedPort.tcp(90)).exec();
InspectContainerResponse r = build2.inspectContainerCmd(exec.getId()).exec();
ObjectMapper k = new ObjectMapper();

JsonNode ll = k.readValue(k.writerWithDefaultPrettyPrinter().writeValueAsString(r).getBytes(), JsonNode.class);
System.out.println(ll.textValue());
System.out.println(k.writerWithDefaultPrettyPrinter().writeValueAsString(r));
//System.out.println(string);
}
}
