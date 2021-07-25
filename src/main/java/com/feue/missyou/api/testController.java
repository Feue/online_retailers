package com.feue.missyou.api;

import com.feue.missyou.core.UnifyResponse;
import com.feue.missyou.dto.PersonDTO;
import com.feue.missyou.dto.ProdDTO;
import com.feue.missyou.sample.ISkill;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Feue
 * @create 2021-07-22 14:36
 */
@RestController
public class testController {
    //    @Qualifier("diana")
    @Autowired // 注入方式一（不推荐）：属性注入
    private ISkill iSkill;

//    @Autowired // 注入方式二（推荐）：构造注入
//    public BannerController(Diana diana) {
//        this.iSkill = diana;
//    }
//
//    @Autowired // 注入方式三：setter 注入
//    public void setDiana(Diana diana) {
//        this.diana = diana;
//    }

//    @Autowired
//    private IConnect iConnect;

    @PostMapping("/test1/{id}")
    public PersonDTO test1(@PathVariable @Range(min = 1, max = 10) Integer id,
                           @RequestParam @Length(min = 4) String name,
                           @RequestBody @Validated PersonDTO person) throws Exception {
        iSkill.q();
//        PersonDTO dto = new PersonDTO();
//        dto.setName("Feue");
//        dto.setAge(21);
        PersonDTO dto = PersonDTO.builder()
                .name("Feue")
                .age(21)
                .build();
//        throw new ForbiddenException(10000);
//        return "Hello, Feue!";
        return dto;
    }

//    @GetMapping("/test2")
//    public void test2() {
//        iConnect.connect();
//    }

    @GetMapping("/getprodlist")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public ResponseEntity<List<ProdDTO>> test() {
        List<ProdDTO> list = new ArrayList<ProdDTO>();
        ProdDTO dto = new ProdDTO();
        dto.setId(1L);
        dto.setName("奥迪");
        dto.setCtime(new Date());
        list.add(dto);
        dto = new ProdDTO();
        dto.setId(2L);
        dto.setName("宝马");
        dto.setCtime(new Date());
        list.add(dto);
        dto = new ProdDTO();
        dto.setId(3L);
        dto.setName("小狮子");
        dto.setCtime(new Date());
        list.add(dto);
        dto = new ProdDTO();
        dto.setId(1L);
        dto.setName("奔驰");
        dto.setCtime(new Date());
        list.add(dto);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<List<ProdDTO>> r = new ResponseEntity<List<ProdDTO>>(list, headers, HttpStatus.ACCEPTED);
        return r;
    }
}
