package miv.study.jackson.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Driver {

    public static void main(String[] args) {

        try {
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO
            Student student = mapper.readValue(
                    new File("data/sample-full.json"), Student.class);

            // print first name and last name
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            // print out address
            Address address = student.getAddress();
            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());
            // print out languages
            System.out.println(Arrays.toString(student.getLanguages()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
