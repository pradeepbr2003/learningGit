package org.example.emp.service;

import lombok.extern.slf4j.Slf4j;
import org.example.emp.model.Manager;
import org.example.emp.repo.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public void saveManager(List<Manager> managers) {
        managerRepository.saveAll(managers);
        log.info("All managers got saved");
    }
}
