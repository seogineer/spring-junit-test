package com.seogineer.springjunittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    @DisplayName("요구사항1 - 1")
    //"1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    void test1_1(){
        String target = "1,2";
        String[] temp = target.split(",");

        assertThat(temp).contains("1", "2");
    }

    @Test
    @DisplayName("요구사항1 - 2")
    //"1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    void test1_2(){
        String target = "1";
        String[] temp = target.split(",");

        assertThat(temp).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2")
    //"(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환 하도록 구현한다.
    void test2(){
        String target = "(1,2)";
        String result = target.substring(1, 4);

        assertEquals("1,2", result);
    }

    @Test
    @DisplayName("요구사항3 - 1")
    //"abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
    void test3_1(){
        String target = "abc";
        char result = target.charAt(0);
        char result2 = target.charAt(1);
        char result3 = target.charAt(2);

        assertEquals('a', result);
        assertEquals('b', result2);
        assertEquals('c', result3);
    }

    @Test
    @DisplayName("요구사항3 - StringIndexOutOfBoundsException")
    //String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
    //StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
    void test3_2(){
        assertThatThrownBy(() -> {
            String target = "abc";
            char result = target.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");

//        assertThatExceptionOfType(IndexOutOfBoundsException.class)
//                .isThrownBy(() -> {
//                    String target = "abc";
//                    char result = target.charAt(3);
//                }).withMessageMatching("String index out of range: \\d+");
    }
}