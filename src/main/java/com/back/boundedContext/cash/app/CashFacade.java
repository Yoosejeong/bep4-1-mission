package com.back.boundedContext.cash.app;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashFacade {
    private final CashSyncMemberUserCase cashSyncMemberUserCase;
    private final CashCreateWalletUserCase cashCreateWalletUserCase;
    private final CashSupport cashSupport;

    @Transactional
    public CashMember syncMember(MemberDto member) {
       return cashSyncMemberUserCase.syncMember(member);
    }

    @Transactional
    public Wallet createWallet(CashMember holder) {
        return cashCreateWalletUserCase.createWallet(holder);
    }

    @Transactional(readOnly = true)
    public Optional<CashMember> findByUsername(String username) {
        return cashSupport.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<Wallet> findWalletByHolder(CashMember holder) {
        return cashSupport.findByHolder(holder);
    }
}
