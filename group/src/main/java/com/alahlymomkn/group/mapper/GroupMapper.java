package com.alahlymomkn.group.mapper;

import com.alahlymomkn.group.dto.GroupResponseDto;
import com.alahlymomkn.group.dto.MemberResponseDto;
import com.alahlymomkn.group.entity.Group;
import com.alahlymomkn.group.entity.GroupMember;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper {
    public GroupResponseDto toResponseDto(Group group) {
        if (group == null) {
            return null;
        }

        return GroupResponseDto.builder()
                .id(group.getId())
                .name(group.getName())
                .build();
    }

    public MemberResponseDto toMemberResponseDto(GroupMember groupMember) {
        if (groupMember == null) {
            return null;
        }

        return MemberResponseDto.builder()
                .id(groupMember.getId())
                .groupId(groupMember.getGroupId())
                .userId(groupMember.getUserId())
                .roles(groupMember.getRoles())
                .build();
    }
}
