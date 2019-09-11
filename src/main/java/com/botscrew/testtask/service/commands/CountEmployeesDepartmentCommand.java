package com.botscrew.testtask.service.commands;

import com.botscrew.testtask.domain.enity.Department;
import com.botscrew.testtask.repository.DepartmentRepository;
import com.botscrew.testtask.service.AbstractCommand;
import com.botscrew.testtask.service.util.StringUtil;
import org.springframework.stereotype.Service;

@Service
public class CountEmployeesDepartmentCommand extends AbstractCommand {

    private final DepartmentRepository departmentRepository;

    public CountEmployeesDepartmentCommand(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        text = "count of employee";
        root = true;
    }

    @Override
    public String execute(String sentence) {
        boolean isFound = sentence.contains(text);
        if (!isFound) return null;
        String key = StringUtil.getKeyAfter(sentence, "for");
        Department department = departmentRepository.findByName(key);
        if (department == null) return null;
        long count = department.getEmployees().stream().count();
        return String.valueOf(count);
    }
}
