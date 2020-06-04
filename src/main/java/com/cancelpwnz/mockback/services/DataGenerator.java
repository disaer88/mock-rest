package com.cancelpwnz.mockback.services;

import com.cancelpwnz.mockback.dao.Employee;
import com.cancelpwnz.mockback.dao.EmployeeRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

@Component
public class DataGenerator {

    @Autowired
    EmployeeRepository employeeRepository;

    @EventListener({ContextRefreshedEvent.class})
    @Transactional
    public void generate(){
        Faker faker = new Faker();
        List<Employee> add = new ArrayList<>(100);
        for (int i = 0; i < 60; i++) {
            add.add(doGenerate(()->faker.gameOfThrones().character()));
        }
        for (int i = 0; i < 25; i++) {
            add.add(doGenerate(()->faker.artist().name()));
        }
        for (int i = 0; i < 25; i++) {
            add.add(doGenerate(()->faker.funnyName().name()));
        }

        int pos = 0;
        for (int i = 0; i < add.size(); i++) {
            pos++;
            if (pos == 1 || pos == 2 && add.size() < i+1){
                add.get(i).setChief(add.get(i+1));
            }
            if (pos >= 3){
                pos = 0;
            }
        }
        employeeRepository.saveAll(add);
    }

    private Employee doGenerate(Supplier<String> nameGen){
        Employee e = new Employee();
        e.setName(nameGen.get());
        e.setAge(ThreadLocalRandom.current().nextInt(19,60));
        e.setMarried(ThreadLocalRandom.current().nextBoolean());
        e.setStartWorkSt(between(Instant.ofEpochMilli(631152000),Instant.now()));
        return e;
    }

    private static Instant between(Instant startInclusive, Instant endExclusive) {
        long startSeconds = startInclusive.getEpochSecond();
        long endSeconds = endExclusive.getEpochSecond();
        long random = ThreadLocalRandom
                .current()
                .nextLong(startSeconds, endSeconds);
        return Instant.ofEpochSecond(random);
    }


}
