package com.botscrew.testtask.service.commands;

import com.botscrew.testtask.domain.enity.Department;
import com.botscrew.testtask.domain.enity.Lecturer;
import com.botscrew.testtask.repository.DepartmentRepository;
import com.botscrew.testtask.service.AbstractCommand;
import com.botscrew.testtask.service.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AverageSalaryDepartmentCommand extends AbstractCommand {

    private final DepartmentRepository departmentRepository;

    public AverageSalaryDepartmentCommand(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        text = "average";
        root = false;
    }

    @Override
    public String execute(String sentence) {
        boolean isFound = sentence.contains(text);
        if (!isFound) return null;
        String key = StringUtil.getKeyAfter(sentence, "department");
        Department department = departmentRepository.findByName(key);
        if (department == null) return null;
        Set<Lecturer> employees = department.getEmployees();
        double averageSalary = employees.stream().mapToDouble(Lecturer::getSalary).average().orElse(0.0);
        return "The average salary of " + department.getName() + " is " + averageSalary;
    }
}
