package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Professional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProfessionalService {

        List<Professional> readAll(Object object);

        Professional get(Integer id);

        Boolean save(Professional professional);

        Boolean update(Professional professional);

        Boolean delete(Integer id);


}
