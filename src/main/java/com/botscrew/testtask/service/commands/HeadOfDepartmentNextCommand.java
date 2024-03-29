package com.botscrew.testtask.service.commands;

import com.botscrew.testtask.domain.enity.Department;
import com.botscrew.testtask.domain.enity.Lecturer;
import com.botscrew.testtask.repository.DepartmentRepository;
import com.botscrew.testtask.service.AbstractCommand;
import com.botscrew.testtask.service.util.StringUtil;
import org.springframework.stereotype.Component;

@Component
public class HeadOfDepartmentNextCommand extends AbstractCommand {

    private final DepartmentRepository departmentRepository;

    public HeadOfDepartmentNextCommand(DepartmentRepository departmentRepository) {
        text = "department";
        root = false;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String execute(String sentence) {
        boolean isFound = sentence.contains(text);
        if (!isFound) return null;
        String key = StringUtil.getKeyAfter(sentence, text);
        Department department = departmentRepository.findByName(key);
        if (department == null) return null;
        Lecturer head = department.getHead();
        String headName;
        if (head == null)
             headName = " department is missed";
        else headName =" department is " +
                department.getHead().getFirstName() +
                " " +
                department.getHead().getLastName();
        return "Head of " + department.getName() + headName;
    }
}
