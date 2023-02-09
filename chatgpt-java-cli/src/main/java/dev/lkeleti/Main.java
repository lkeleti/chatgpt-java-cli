package dev.lkeleti;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

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