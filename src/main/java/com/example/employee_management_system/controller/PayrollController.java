package com.example.employee_management_system.controller;


import com.example.employee_management_system.dto.PayrollRequest;
import com.example.employee_management_system.dto.PayrollResponse;
import com.example.employee_management_system.service.PayrollService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/payroll")
@RequiredArgsConstructor
public class PayrollController {


    private final PayrollService payrollService;



    @PostMapping
    public ResponseEntity<PayrollResponse> createPayroll(
            @RequestBody PayrollRequest request) {


        return new ResponseEntity<>(
                payrollService.createPayroll(request),
                HttpStatus.CREATED
        );
    }





    @GetMapping
    public ResponseEntity<List<PayrollResponse>> getAllPayrolls(){

        return ResponseEntity.ok(
                payrollService.getAllPayrolls()
        );
    }





    @GetMapping("/{id}")
    public ResponseEntity<PayrollResponse> getPayrollById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                payrollService.getPayrollById(id)
        );
    }





    @PutMapping("/{id}")
    public ResponseEntity<PayrollResponse> updatePayroll(
            @PathVariable Long id,
            @RequestBody PayrollRequest request){


        return ResponseEntity.ok(
                payrollService.updatePayroll(id,request)
        );

    }





    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayroll(
            @PathVariable Long id){


        payrollService.deletePayroll(id);


        return ResponseEntity.ok(
                "Payroll deleted successfully"
        );
    }

}
