package com.unindra.repository;

import com.unindra.model.request.TeacherRequest;
import com.unindra.util.AppContext;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

@Slf4j
public class TeacherRepositoryTest {

    private DataSource dataSource = AppContext.getDataSource();

    private TeacherRepository teacherRepository = new TeacherRepositoryImpl(dataSource);

    // @Befo4reEach
    // @Disabled
    @Test
    void setUp(){
        teacherRepository.deleteAll();
    }

    @Test
    void addTest(){

        TeacherRequest teacher = new TeacherRequest();
        Date date = new Date(971496000000l);

        teacher.setName("Putri");
        teacher.setId("1234");
        teacher.setBirthPlace("Bogor");
        teacher.setBirthDate(date);
        teacher.setGender("Female");
        teacher.setPhoneNumber("08123456789");
        teacher.setEmail("email@mail.com");

        teacherRepository.add(teacher);

        String data = teacherRepository.findById("1234");
        
        assertEquals(teacher.getId(), data);
        
    }

    @Test
    void testGetAllData() {
        TeacherRequest teacher = new TeacherRequest();
        
        Date date = new Date(971496000000l);

        for (int i = 1; i <= 100; i++) {
            teacher.setName("Putri" + i);
            teacher.setId(String.valueOf(i));
            teacher.setBirthPlace("Bogor");
            teacher.setBirthDate(date);
            teacher.setGender("Female");
            teacher.setAddress("Bekasih");
            teacher.setPhoneNumber("08123456789");
            teacher.setEmail("email@mail.com");

            teacherRepository.add(teacher);
        }

        TeacherRequest[] all = teacherRepository.getAll();

        assertEquals(100, all.length);


    }
    
}