package dev.lkeleti;

import java.io.IOException;
public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Service service = new Service();
        String searchString = "";
        System.out.println("Enter a string for search: ");

        while (searchString.toUpperCase() != "QUIT" ) {
            searchString = service.getSearchString();
            service.getAiAnswer(searchString);
        }
    }
}