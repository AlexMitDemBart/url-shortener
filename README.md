# url-shortener
This service will provide short aliases redirecting to long URLs. 


### Built With
* [Spring Boot](https://spring.io)
* [Flyway](https://flywaydb.org/)
* [Docker](https://www.docker.com/)
* [Lombok](https://projectlombok.org/)
<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started
### Installation
Clone the repo
   ```sh
   git clone https://github.com/AlexMitDemBart/url-shortener.git
   ```
<p align="right">(<a href="#top">back to top</a>)</p>

### Usage with Docker
You can build an Docker image by running this command
```sh
mvn clean package docker:build
   ```

The image will build from pom.xml configurations
```sh
  <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>docker-maven-plugin</artifactId>
        <version>1.2.2</version>
            <configuration>
               <imageName>url-shortener</imageName>
               <baseImage>openjdk:15.0</baseImage>
               <entryPoint>["java", "-jar", "/${project.build.finalName}.jar"]</entryPoint>
               <resources>
                  <resource>
                     <targetPath>/</targetPath>
                     <directory>${project.build.directory}</directory>
                     <include>${project.build.finalName}.jar</include>
                     </resource>
                  </resources>
            </configuration>
  </plugin>
```
   
execute the 
```sh
docker-compose.yml
```
file to create an image of the MySQL Database. </br>
Start the application in docker profile.

<!-- CONTACT -->
## Contact
Alexander Zotz - AlexMitDemBart@gmail.com
Project Link: (https://github.com/AlexMitDemBart/url-shortener.git)
<p align="right">(<a href="#top">back to top</a>)</p>
