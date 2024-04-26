package org.springframework.integration.samples.loanbroker;

import java.util.List;

import org.springframework.integration.samples.loanbroker.domain.LoanQuote;
import org.springframework.integration.samples.loanbroker.domain.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;




public class LoanBrokerController {

    @Autowired
    private LoanBrokerGateway loanBrokerGateway;

    @PostMapping("/loan")
    public ResponseEntity<String> handleLoanRequest(@RequestBody LoanRequest loanRequest) {
        loanBrokerGateway.processLoanRequest(loanRequest);
        return ResponseEntity.ok("Loan request submitted successfully");
        
    }
}
