package com.devsuperior.aula.services;

import com.devsuperior.aula.dtos.PersonDTO;
import com.devsuperior.aula.dtos.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private DepartmentRepository departmentRepository;

    public PersonService(PersonRepository personRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;
    }

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //Desta forma, é retornado o nome do departamento ao realizar o post
        Department department = departmentRepository.getReferenceById(dto.getDepartment().getId());
        //Desta forma, temos o retorno null quando fazemos o post
        //Department department = new Department();
        //department.setId(dto.getDepartment().getId());

        entity.setDepartment(department);

        entity = personRepository.save(entity);
        return new PersonDepartmentDTO(entity);
    }

    public PersonDTO insert(PersonDTO dto) {
        Person entity = new Person();
        entity.setName(dto.getName());
        entity.setSalary(dto.getSalary());

        //Desta forma, é retornado o nome do departamento ao realizar o post
        Department department = departmentRepository.getReferenceById(dto.getDepartmentId());
        //Desta forma, temos o retorno null quando fazemos o post
        //Department department = new Department();
        //department.setId(dto.getDepartmentId());

        entity.setDepartment(department);

        entity = personRepository.save(entity);
        return new PersonDTO(entity);
    }
}
