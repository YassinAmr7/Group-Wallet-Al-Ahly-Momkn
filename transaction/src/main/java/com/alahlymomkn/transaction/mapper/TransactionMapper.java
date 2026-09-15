package com.alahlymomkn.transaction.mapper;

import com.alahlymomkn.transaction.dto.TransactionResponseDto;
import com.alahlymomkn.transaction.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionResponseDto toResponseDto(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        return TransactionResponseDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .sourceWalletId(transaction.getSourceWalletId())
                .destWalletId(transaction.getDestWalletId())
                .performedByUserId(transaction.getPerformedByUserId())
                .createdAt(transaction.getCreatedAt())
                .build();
    }
}
