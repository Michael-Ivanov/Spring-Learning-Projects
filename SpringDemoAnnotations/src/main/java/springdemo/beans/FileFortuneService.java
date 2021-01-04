package springdemo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

@Component
public class FileFortuneService implements FortuneService {
    
    @Value("${fortunesFile}")
    private String pathToFile;

    @Override
    public String getFortune() {
        File fortunesFile = new File(pathToFile);
        String[] fortunes = getAllFortunesFromFile(fortunesFile);
        Random random = new Random();
        int randomIndex = random.nextInt(fortunes.length);

        return fortunes[randomIndex];
    }

    private String[] getAllFortunesFromFile(File file) {

        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        return stringBuilder.toString().split("\\n");
    }

    @PostConstruct
    private void initMethod() {
        System.out.println("FileFortuneService >> inside the init method. Fortune: ");
        System.out.println(getFortune());
    }
}
