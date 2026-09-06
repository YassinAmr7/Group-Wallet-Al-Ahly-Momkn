package com.alahlymomkn.user.service;

import com.alahlymomkn.common.exceptions.EmailAlreadyExistsException;
import com.alahlymomkn.common.exceptions.ResourceNotFoundException;
import com.alahlymomkn.user.dto.CreateUserRequest;
import com.alahlymomkn.user.dto.UserRegistrationResponseDto;
import com.alahlymomkn.user.dto.UserResponseDto;
import com.alahlymomkn.user.entity.User;
import com.alahlymomkn.user.repository.UserRepository;
import com.alahlymomkn.wallet.dto.WalletResponseDto;
import com.alahlymomkn.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final WalletService walletService;

    @Transactional
    public UserRegistrationResponseDto registerUser(CreateUserRequest request) {
        if (userRepository.existsByEmailIgnoreCase(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        User user = userRepository.save(User.builder()
                .name(request.getName().trim())
                .email(request.getEmail().trim().toLowerCase())
                .build());

        WalletResponseDto wallet = walletService.createPersonalWallet(user.getId());

        return UserRegistrationResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .wallet(wallet)
                .build();
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserById(Long userId) {
        return toResponseDto(findUser(userId));
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public void ensureUserExists(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found: " + userId);
        }
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
    }

    private UserResponseDto toResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
