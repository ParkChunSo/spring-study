package com.example.springstudy;

import com.example.springstudy.model.dto.BeanDto;
import com.example.springstudy.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringStudyApplicationTests {

    @Autowired
    DemoService demoService;

    @Autowired
    BeanDto beanDto;

    @Test
    public void iocTest(){
        System.out.println("================================================================");
        System.out.println("======================== DemoTest ==============================");
        System.out.println("======================== IOC TEST ==============================");
        System.out.println("================================================================");
        System.out.println("Bean으로 등록되면 과연 인스턴스가 하나만 생성될까?");
        System.out.println("현재 beanDto의 값");
        System.out.println("BeanDto.first = " + beanDto.getFirst());
        System.out.println("BeanDto.second = " + beanDto.getSecond());
        System.out.println("BeanDto.third = " + beanDto.getThird());
        System.out.println("================================================================");
        beanDto.setFirst("첫번째"); beanDto.setSecond("두번째"); beanDto.setThird("세번째");
        System.out.println("값을 넣어준 beanDto의 값");
        System.out.println("BeanDto.first = " + beanDto.getFirst());
        System.out.println("BeanDto.second = " + beanDto.getSecond());
        System.out.println("BeanDto.third = " + beanDto.getThird());
        System.out.println("");
        demoService.printBean("하나", "둘", "셋");
    }

}

