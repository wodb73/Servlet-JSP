package org.zerock.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    @BeforeEach
    public void  ready(){
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        System.out.println(todoDAO.getTime2());
    }

    @Test
    public void testInsert()throws Exception{
        TodoVO todoVO = TodoVO.builder()
                .title("Sample Title...")
                .dueDate(LocalDate.of(2021,12,31))
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testSelectAll()throws Exception{
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }
    @Test
    public void testSelectOne()throws Exception{
        Long tno = 2L;

        TodoVO vo = todoDAO.selectOne(tno);
        System.out.println(vo);

    }
    @Test
    public void testUpdateOne() throws Exception{
        TodoVO todoVO= TodoVO.builder()
                .tno(1L)
                .title("Sample Title....")
                .dueDate(LocalDate.of(2023,07,14))
                .finished(true)
                .build();

        todoDAO.updateOne(todoVO);
    }

    @Test
    public void delete() throws Exception{
        Long tno=2L;

        try { todoDAO.deleteOne(tno);
            System.out.println("글이 삭제되었습니다.");
        }catch (Exception e){
            System.out.println("글이 삭제되지 않았습니다."+e.getMessage());
        }
    }
}
