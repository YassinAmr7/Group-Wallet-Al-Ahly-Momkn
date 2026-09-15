package com.alahlymomkn.wallet.mapper;

import com.alahlymomkn.wallet.dto.WalletResponseDto;
import com.alahlymomkn.wallet.entity.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    public WalletResponseDto toResponseDto(Wallet wallet) {
        if (wallet == null) {
            return null;
        }

        return WalletResponseDto.builder()
                .id(wallet.getId())
                .balance(wallet.getBalance())
                .type(wallet.getType())
                .userId(wallet.getUserId())
                .groupId(wallet.getGroupId())
                .version(wallet.getVersion())
                .build();
    }
}
