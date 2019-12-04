package com.imnu.eeas.config;

import com.imnu.eeas.core.EResponse;
import com.imnu.eeas.pojo.EnergyYear;
import com.imnu.eeas.service.EnergyYearService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/energyyear")
public class EnergyYearController extends BaseController {

    @Autowired
    private EnergyYearService energyYearService;

    @GetMapping("/{id}")
    public EResponse<EnergyYear> findById(@PathVariable Integer id) {
        return EResponse.data(energyYearService.findEnergyYearById(id));
    }

    @GetMapping("/batch/{ids}")
    public EResponse<List<EnergyYear>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            return EResponse.data(energyYearService.findEnergyYearsById(idList));
        }
        return EResponse.success();
    }

    @PostMapping("/create")
    public EResponse create(EnergyYear req) {
        return EResponse.data(energyYearService.createNewEnergyYear(req));
    }

    @GetMapping("/delete/{id}")
    public EResponse deleteById(@PathVariable Integer id) {
        energyYearService.deleteEnergyYearById(id);
        return EResponse.success();
    }

    @GetMapping("/delete/batch/{ids}")
    public EResponse deleteByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Integer.valueOf(id.trim()));
            }
            energyYearService.deleteEnergyYearsById(idList);
        }
        return EResponse.success();
    }

    @PostMapping("/update")
    public EResponse updateById(EnergyYear req) {
        energyYearService.updateEnergyYearById(req);
        return EResponse.success();
    }
}
