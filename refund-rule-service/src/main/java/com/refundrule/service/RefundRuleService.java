package com.refundrule.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refundrule.entity.RefundRule;
import com.refundrule.repository.RefundRuleRepository;

@Service
public class RefundRuleService {

    @Autowired
    private RefundRuleRepository repo;

    public List<RefundRule> getAll() {
        return repo.findAll();
    }

    public RefundRule getApplicableRule(LocalTime now) {
        return repo.findByTime(now);
    }

    public void createRule(RefundRule rule) {
        repo.save(rule);
    }

    public void updateRule(RefundRule rule) {
        repo.update(rule);
    }

    public String deleteRule(int id) {
        String deleteById = repo.deleteById(id);
        
        return deleteById;
    }
}
