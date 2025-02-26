<build>
    <plugins>
        <!-- Spring Boot Maven Plugin -->
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <version>\${spring.boot.version}</version>
            <configuration>
                <mainClass>com.studentapp.StudentAttendanceApp</mainClass> <!-- Specify your main class here -->
            </configuration>
        </plugin>

        <!-- Maven Compiler Plugin -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
            <configuration>
                <source>\${java.version}</source>
                <target>\${java.version}</target>
            </configuration>
        </plugin>
    </plugins>
</build>
