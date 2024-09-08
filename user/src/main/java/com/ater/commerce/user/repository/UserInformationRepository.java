package com.ater.commerce.user.repository;

import com.ater.commerce.user.model.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

    Optional<UserInformation> findByMail(String mail);
}
