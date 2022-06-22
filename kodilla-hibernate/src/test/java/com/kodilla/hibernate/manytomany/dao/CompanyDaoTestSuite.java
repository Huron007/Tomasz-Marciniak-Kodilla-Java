package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.CompanyFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyFacade companyFacade;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        int johnSmithId = johnSmith.getId();
        int stephanieClarcksonId = stephanieClarckson.getId();
        int lindaKovalskyId = lindaKovalsky.getId();
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        List<Company> companiesThatStartsWith = companyDao.findCompaniesThatStartsWith();
        List<Employee> employeeWithExactLastName = employeeDao.findEmployeeWithExactName("Smith");

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);
        assertEquals(1, companiesThatStartsWith.size());
        assertEquals(1, employeeWithExactLastName.size());

        //CleanUp
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);
        employeeDao.deleteById(johnSmithId);
        employeeDao.deleteById(stephanieClarcksonId);
        employeeDao.deleteById(lindaKovalskyId);
    }

    @Test
    void companyFacadeTest(){
        //Given
        Employee john = new Employee("John", "Smith");
        Employee paul = new Employee("Paul", "Morrison");
        Company company1 = new Company("Good Company");
        Company company2 = new Company("Bad Company");

        //When
        int companyOneId = companyFacade.getCompanyDao().save(company1).getId();
        int companyTwoId = companyFacade.getCompanyDao().save(company2).getId();
        int johnId = companyFacade.getEmployeeDao().save(john).getId();
        int paulId = companyFacade.getEmployeeDao().save(paul).getId();
        List<Employee> employeeList = companyFacade.findEmployeeWithNameThatContains("Smith");
        List<Company> companyList = companyFacade.findCompaniesWithNameThatContains("Company");

        //Then
        assertEquals(1, employeeList.size());
        assertEquals(2, companyList.size());

        //Cleanup
        companyFacade.getCompanyDao().deleteById(companyOneId);
        companyFacade.getCompanyDao().deleteById(companyTwoId);
        companyFacade.getEmployeeDao().deleteById(johnId);
        companyFacade.getEmployeeDao().deleteById(paulId);
    }
}