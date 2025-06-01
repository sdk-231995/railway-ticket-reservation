package com.refundrule.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.refundrule.entity.RefundRule;
import com.refundrule.service.RefundRuleService;

@RestController
@RequestMapping("/api/refund-rules")
public class RefundRuleController {

    @Autowired
    private RefundRuleService service;

    @GetMapping
    public List<RefundRule> getAll() {
        return service.getAll();
    }

    @GetMapping("/current")
    public RefundRule getCurrentApplicableRule() {
        return service.getApplicableRule(LocalTime.now());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody RefundRule rule) {
        service.createRule(rule);
        return ResponseEntity.ok("Refund rule created.");
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody RefundRule rule) {
        service.updateRule(rule);
        return ResponseEntity.ok("Refund rule updated.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        String deleteRule = service.deleteRule(id);
        return ResponseEntity.ok(deleteRule);
    }
}
