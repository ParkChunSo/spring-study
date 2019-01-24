package com.example.springstudy.service;

import com.example.springstudy.model.dto.BeanDto;
import com.example.springstudy.model.dto.UserDto;
import com.example.springstudy.model.entity.UserEntity;
import com.example.springstudy.repository.DemoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    private DemoRepository demoRepository;
    private BeanDto beanDto;

    public DemoService(DemoRepository demoRepository, BeanDto beanDto) {
        this.demoRepository = demoRepository;
        this.beanDto = beanDto;
    }


    public String getUserEmail(String name) {
        UserEntity userEntity = demoRepository.findByName(name).orElseThrow(
                () -> new NullPointerException("User Not Found Exception")
        );
        return userEntity.getEmail();
    }

    public void saveUser(String name, String email) {
        UserEntity userEntity = UserEntity.builder()
                .name(name)
                .email(email)
                .build();

        demoRepository.save(userEntity);
    }

    public List<UserDto> getAllUser() {
        List<UserEntity> userEntity = (List<UserEntity>) demoRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(UserEntity entity : userEntity){
            UserDto userDto = new UserDto();
            userDto.setName(entity.getName());
            userDto.setEmail(entity.getEmail());
            userDtos.add(userDto);
        }

        return userDtos;
    }

    public void printBean(String first, String second, String third){
        System.out.println("================================================================");
        System.out.println("====================== DemoService =============================");
        System.out.println("================================================================");
        System.out.println("Bean으로 등록되면 과연 인스턴스가 하나만 생성될까?");
        System.out.println("현재 beanDto의 값");
        System.out.println("BeanDto.first = " + beanDto.getFirst());
        System.out.println("BeanDto.second = " + beanDto.getSecond());
        System.out.println("BeanDto.third = " + beanDto.getThird());
        System.out.println("================================================================");
        beanDto.setFirst(first); beanDto.setSecond(second); beanDto.setThird(third);
        System.out.println("값을 넣어준 beanDto의 값");
        System.out.println("BeanDto.first = " + beanDto.getFirst());
        System.out.println("BeanDto.second = " + beanDto.getSecond());
        System.out.println("BeanDto.third = " + beanDto.getThird());
        System.out.println("================================================================");
    }
}
