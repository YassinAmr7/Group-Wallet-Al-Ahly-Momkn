package com.alahlymomkn.user.dto;

import com.alahlymomkn.wallet.dto.WalletResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponseDto {
    private Long id;
    private String name;
    private String email;
    private WalletResponseDto wallet;
}
