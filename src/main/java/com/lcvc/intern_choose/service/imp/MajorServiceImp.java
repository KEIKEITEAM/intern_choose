package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.model.Major;
import com.lcvc.intern_choose.service.MajorService;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MajorServiceImp implements MajorService {
    @Override
    public Major get(@NotNull Integer id) {
        return null;
    }

    @Override
    public List<Major> readAll() {
        return null;
    }

    @Override
    public Boolean delete(@NotNull Integer id) {
        return null;
    }

    @Override
    public boolean update(Major major) {
        return false;
    }

    @Override
    public boolean save(Major major) {
        return false;
    }
}
