package org.example.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.entity.User;
import org.example.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    
      private final UserRepository userRepository;
    
      @Override
      @Transactional
      public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {
     User user = userRepository.findByEmail(username)
          .orElseThrow(() -> new UsernameNotFoundException("username-or-password-is-not-correct"));
     return UserPrinciple.build(user);
      }
}
