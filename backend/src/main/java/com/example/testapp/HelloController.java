package com.example.testapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final TestRepository testRepository;

    public HelloController(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @GetMapping("/api/hello")
    public String hello() {
        // Save a test entry if empty
        if (testRepository.count() == 0) {
            testRepository.save(new TestEntity("Hello from PostgreSQL Database!"));
        }

        // Return the first entry
        return testRepository.findAll().get(0).getMessage();
    }
}
