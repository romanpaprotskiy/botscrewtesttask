package com.botscrew.testtask.service.commands;

import com.botscrew.testtask.domain.enity.Degree;
import com.botscrew.testtask.domain.enity.Department;
import com.botscrew.testtask.repository.DegreeRepository;
import com.botscrew.testtask.repository.DepartmentRepository;
import com.botscrew.testtask.repository.LecturerRepository;
import com.botscrew.testtask.service.AbstractCommand;
import com.botscrew.testtask.service.dto.StatisticDTO;
import com.botscrew.testtask.service.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticCommand extends AbstractCommand {

    private final DepartmentRepository departmentRepository;

    private final DegreeRepository degreeRepository;

    private final LecturerRepository lecturerRepository;

    public StatisticCommand(DepartmentRepository departmentRepository,
                            DegreeRepository degreeRepository, LecturerRepository lecturerRepository) {
        this.departmentRepository = departmentRepository;
        this.degreeRepository = degreeRepository;
        this.lecturerRepository = lecturerRepository;
        text = "statistic";
        root = true;
    }

    @Override
    public String execute(String sentence) {
        boolean isFound = sentence.contains(text);
        if (!isFound) return null;
        String key = StringUtil.getKeyBefore(sentence, text);
        Department department = departmentRepository.findByName(key);
        if (department == null) return null;
        return calculateStatistic(department);
    }

    private String calculateStatistic(Department department) {
        List<StatisticDTO> result = new ArrayList<>();
        List<Degree> degrees = degreeRepository.findAll();
        for (Degree degree : degrees) {
            int count = lecturerRepository.countByDegreeAndDepartmentIn(degree.getId(), department.getId());
            StatisticDTO statisticDTO = new StatisticDTO();
            statisticDTO.setFieldName(degree.getName());
            statisticDTO.setCount(count);
            result.add(statisticDTO);
        }
        return convertToString(result);
    }

    private String convertToString(List<StatisticDTO> statisticDTOS) {
        StringBuilder stringBuilder = new StringBuilder();
        for (StatisticDTO statisticDTO : statisticDTOS) {
            stringBuilder.append(statisticDTO.toString());
        }
        return stringBuilder.toString();
    }
}
