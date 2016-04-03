package testq.ee;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerCertificateException;
import com.spotify.docker.client.DockerCertificates;
import com.spotify.docker.client.DockerClient.ExecStartParameter;
import com.spotify.docker.client.DockerClient.ListContainersParam;
import com.spotify.docker.client.DockerClient.ListImagesParam;
import com.spotify.docker.client.DockerException;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;
import com.spotify.docker.client.messages.Image;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DockerException, InterruptedException, DockerCertificateException, IOException
    { 
    	DefaultDockerClient build = DefaultDockerClient.fromEnv().dockerCertificates(new DockerCertificates(new File("C:\\Users\\vinio\\.docker\\machine\\certs").toPath())).uri(URI.create("https://192.168.99.100:2376")).build();
		System.out.println(build.ping());
		List<Image> listImages = build.listImages(ListImagesParam.allImages());
		for (Image image : listImages) {
			System.out.println(image.toString());
			
		}
		System.out.println(build.info().name());
		ContainerCreation createContainer = build.createContainer(ContainerConfig.builder().image("busybox").cmd("sh").domainname("kkll").build());
		build.stopContainer(createContainer.id(), 0);
		build.startContainer(createContainer.id());
		
    }
}
