package com.pavcho.ExpenseTracker.auditor;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("Pavlin Dimitrov");
  }

//  @Override
//  public Optional<String> getCurrentAuditor() {
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if (authentication == null || !authentication.isAuthenticated()){
//      return Optional.empty();
//    }
//    return Optional.of(authentication.getName().toString());
//  }
//  }
}
