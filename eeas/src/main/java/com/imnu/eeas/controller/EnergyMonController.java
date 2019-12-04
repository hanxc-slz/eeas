package com.imnu.eeas.config;

import com.imnu.eeas.core.EResponse;
import com.imnu.eeas.pojo.EnergyMon;
import com.imnu.eeas.service.EnergyMonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/energymon")
public class EnergyMonController extends BaseController {

    @Autowired
    private EnergyMonService energyMonService;

    @GetMapping("/{id}")
    public EResponse<EnergyMon> findById(@PathVariable Integer id) {
        return EResponse.data(energyMonService.findEnergyMonById(id));
    }

    @GetMapping("/batch/{ids}")
    public EResponse<List<EnergyMon>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id: idArray) {
                list.add(Integer.valueOf(id.trim()));
            }
            return EResponse.data(energyMonService.findEnergyMonsById(list));
        }
        return EResponse.success();
    }
    @PostMapping("/create")
    public EResponse create(EnergyMon req) {
        return EResponse.data(energyMonService.createNewEnergyMon(req));
    }

    @GetMapping("/delete/{id}")
    public EResponse deleteById(@PathVariable Integer id) {
        energyMonService.deleteEnergyMonById(id);
        return EResponse.success();
    }

    @GetMapping("/delete/batch/{ids}")
    public EResponse deleteByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id: split) {
                list.add(Integer.valueOf(id.trim()));
            }
            energyMonService.deleteEnergyMonsById(list);
        }
        return EResponse.success();
    }
    @PostMapping("/update")
    public EResponse updateById(EnergyMon req) {
        energyMonService.updateEnergyMonById(req);
        return EResponse.success();
    }
}
