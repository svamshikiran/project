package com.example.palindrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.palindrome.model.StringPalingdrome;

@Repository
public interface PalindromeRepository extends JpaRepository<StringPalingdrome, String>{

}
