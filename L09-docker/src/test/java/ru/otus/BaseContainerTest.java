package ru.otus;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;


public abstract class BaseContainerTest {
    private static final int PORT = 8080;
    //если будете повторять, пропишите свой образ
    private static final String imageName = "registry.gitlab.com/petrelevich/dockerregistry/rest-hello:v12";
    private static final GenericContainer<?> REST_CONTAINER =
            new GenericContainer<>(DockerImageName.parse(imageName))
                    .withReuse(true) //To enable reuse of containers, you must set 'testcontainers.reuse.enable=true' in a file located at ~/.testcontainers.properties
                    .withExposedPorts(PORT);

    static {
        REST_CONTAINER.start();
    }

    public static int getPort() {
        return REST_CONTAINER.getMappedPort(PORT);
    }

    public static String getHost() throws IOException, InterruptedException {
        return REST_CONTAINER.execInContainer("hostname").getStdout().replace("\n","");
    }

}
