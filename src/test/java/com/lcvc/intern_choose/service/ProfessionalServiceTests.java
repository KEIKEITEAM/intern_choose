package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Professional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfessionalServiceTests {
    @Autowired
    private ProfessionalService professionalService;
    @Test
    void save(){
        Professional professional=new Professional();
        professional.setName("软件专业群");
        professional.setId(1);
       System.out.println(professionalService.save(professional));
    }

    @Test
    void update(){
        Professional professional=new Professional();
        professional.setName("软件专业群1");
        professional.setId(1);
        System.out.println(professionalService.update(professional));
    }

    @Test
    void get(){
        System.out.println(professionalService.get(1));
    }

    @Test
    void delete(){
        System.out.println(professionalService.delete(11));
    }

    @Test
    void readAll(){
        System.out.println(professionalService.readAll(null));
    }
}
