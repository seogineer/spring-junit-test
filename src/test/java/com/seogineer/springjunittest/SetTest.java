package com.seogineer.springjunittest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1")
    //Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
    void test1(){
        assertEquals(3, numbers.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2")
    //Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
    //구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
    /**
     * @Test
     * void contains() {
     *      assertThat(numbers.contains(1)).isTrue();
     *      assertThat(numbers.contains(2)).isTrue();
     *      assertThat(numbers.contains(3)).isTrue();
     * }
     */
    //JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.
    void test2(int param){
        assertThat(numbers.contains(param)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "2", "3", "4", "5"})
    @DisplayName("요구사항3")
    //요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다.
    //입력 값에 따라 결과값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
    //예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true,
    //4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.
    void test3(int input) {
        if(input < 4){
            assertThat(numbers.contains(input)).isTrue();
        } else {
            assertThat(numbers.contains(input)).isFalse();
        }
    }
}
