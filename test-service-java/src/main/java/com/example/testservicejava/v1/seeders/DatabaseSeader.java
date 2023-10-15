package com.example.testservicejava.v1.seeders;

import com.example.testservicejava.v1.entities.Address;
import com.example.testservicejava.v1.entities.Company;
import com.example.testservicejava.v1.entities.Geo;
import com.example.testservicejava.v1.entities.User;
import com.example.testservicejava.v1.repositories.AddressRepository;
import com.example.testservicejava.v1.repositories.CompanyRepository;
import com.example.testservicejava.v1.repositories.GeoRepository;
import com.example.testservicejava.v1.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

@Component
@Slf4j
public class DatabaseSeader {

    private final GeoRepository geoRepository;
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    public DatabaseSeader(GeoRepository geoRepository, AddressRepository addressRepository, CompanyRepository companyRepository, UserRepository userRepository) {
        this.geoRepository = geoRepository;
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @EventListener
    private void seed(ContextRefreshedEvent event) throws JsonProcessingException {
        userRepository.deleteAll();
        companyRepository.deleteAll();
        addressRepository.deleteAll();
        geoRepository.deleteAll();

        InputStream inputStream = DatabaseSeader.class.getClassLoader().getResourceAsStream("test-data.json");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
                String fileContent = scanner.useDelimiter("\\A").next();

            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<List<User>> typeReference = new TypeReference<>() {};
            List<User> users = objectMapper.readValue(fileContent, typeReference);
            List<Geo> geos = users.stream().map((it) -> it.getAddress().getGeo()).toList();
            geoRepository.saveAll(geos);
            List<Address> addresses = users.stream().map(User::getAddress).toList();
            addressRepository.saveAll(addresses);
            List<Company> companies = users.stream().map(User::getCompany).toList();
            companyRepository.saveAll(companies);
            userRepository.saveAll(users);
        } else {
            log.error("Seed data file not found");
        }
    }

}
