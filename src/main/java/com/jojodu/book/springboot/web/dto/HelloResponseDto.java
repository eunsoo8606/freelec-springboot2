package com.jojodu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//생성된 모든 필드가 포함된 생성자를 생성해 줍니다.
// final이 없는 필드는 생성자에 포함되지 않습니다.
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;



}
