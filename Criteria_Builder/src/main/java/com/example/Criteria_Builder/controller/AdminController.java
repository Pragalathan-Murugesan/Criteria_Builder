package com.example.Criteria_Builder.controller;

import com.example.Criteria_Builder.apiresponse.ApiResponse;
import com.example.Criteria_Builder.dto_classes.CommonDto;
import com.example.Criteria_Builder.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/add/admin")
    public ApiResponse addAdmin(@RequestBody CommonDto commonDto){
        return adminService.addAdmin(commonDto);
    }
    @GetMapping(value = "/getall")
    public ApiResponse getAll(){
        return adminService.getAll();
    }
    @PutMapping(value = "/update")
    public ApiResponse updateAdmin(@RequestBody CommonDto commonDto){
        return adminService.updateAdmin(commonDto);
    }
   @GetMapping(value = "/getbyid/{id}")
    public ApiResponse getById(@PathVariable("id") Long id){
        return adminService.getById(id);
   }
   @DeleteMapping(value = "/delete/{id}")
    public ApiResponse deleteById(@PathVariable("id") Long id){
        return adminService.deleteById(id);
   }
   @PatchMapping(value = "/updateonefield")
    public ApiResponse updateOneField(@RequestBody CommonDto commonDto){
        return adminService.updateOneField(commonDto);
   }
}
