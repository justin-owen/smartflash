package com.development.smartflash.dtos;

import com.development.smartflash.entities.UserSet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSetDto implements Serializable {
    private Long id;
    private String name;
    private String subject;
    private UserDto userDto;
    private Set<QuestionDto> questionDtoSet = new HashSet<>();

    public UserSetDto(UserSet set) {
        if (set.getId() != null){
            this.id = set.getId();
        }
        if (set.getName() != null){
            this.name = set.getName();
        }
        if (set.getSubject() != null){
            this.subject = set.getSubject();
        }
    }
}
