package com.alahlymomkn.transaction.service;


import com.alahlymomkn.transaction.dto.TransactionResponseDto;
import com.alahlymomkn.transaction.mapper.TransactionMapper;
import com.alahlymomkn.transaction.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class  ReportingService {

   private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;


    public List<TransactionResponseDto> getWalletStatement(Long walletId) {
        return transactionRepository
                .findBySourceWalletIdOrDestWalletIdOrderByCreatedAtDesc(walletId, walletId)
                .stream()
                .map(transactionMapper::toResponseDto)
                .toList();
    }
}
