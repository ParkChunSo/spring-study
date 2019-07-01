package com.example.springstudy;

import com.example.springstudy.model.dto.BeanDto;
import com.example.springstudy.model.entity.Board;
import com.example.springstudy.repository.BoardRepository;
import com.example.springstudy.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class SpringStudyApplicationTests {

    @Autowired
    DemoService demoService;

    @Autowired
    BeanDto beanDto;

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void iocTest() {
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
        beanDto.setFirst("첫번째");
        beanDto.setSecond("두번째");
        beanDto.setThird("세번째");
        System.out.println("값을 넣어준 beanDto의 값");
        System.out.println("BeanDto.first = " + beanDto.getFirst());
        System.out.println("BeanDto.second = " + beanDto.getSecond());
        System.out.println("BeanDto.third = " + beanDto.getThird());
        System.out.println("");
        demoService.printBean("하나", "둘", "셋");
    }

    @Test
    public void insertBoard() {
        for (int i = 1; i <= 200; i++) {
            Board board = Board.builder()
                    .title("제목.." + i)
                    .content("내용 ...." + i + " 채우기 ")
                    .writer("user0" + (i % 10))
                    .build();
            boardRepository.save(board);
        }
    }

    @Test
    public void testBnoPagingSort() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");

        Page<Board> results = boardRepository.findByBnoGreaterThan(0L, pageable);

        results.forEach(board -> System.out.println(board));
        System.out.println(results.getTotalElements());
        System.out.println(results.getTotalPages());
        System.out.println(results.getSize());
        System.out.println(results.getNumber());
        System.out.println(results.getContent());
    }

}

