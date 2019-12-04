package com.imnu.eeas.config;

import com.imnu.eeas.core.EResponse;
import com.imnu.eeas.pojo.Census;
import com.imnu.eeas.service.CensusService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/census")
public class CensusController extends BaseController {

    @Autowired
    private CensusService censusService;

    @GetMapping("/{id}")
    public EResponse<Census> findById(@PathVariable Integer id) {
        return EResponse.data(censusService.findCensusById(id));
    }

    @GetMapping("/batch/{ids}")
    public EResponse<List<Census>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] split = ids.split(",");
            List<Integer> list = new ArrayList<>();
            for (String id: split) {
                list.add(Integer.valueOf(id.trim()));
            }
            return EResponse.data(censusService.findCensussById(list));
        }
        return EResponse.success();
    }

    @PostMapping("/create")
    public EResponse create(Census req) {
        return EResponse.data(censusService.createNewCensus(req));
    }

    @GetMapping("/delete/{id}")
    public EResponse deleteById(@PathVariable Integer id) {
        censusService.deleteCensusById(id);
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
            censusService.deleteCensussById(list);
        }
        return EResponse.success();
    }

    @PostMapping("/update")
    public EResponse updateById(Census req) {
        censusService.updateCensusById(req);
        return EResponse.success();
    }
}
