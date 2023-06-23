package com.example.Criteria_Builder.services;

import com.example.Criteria_Builder.apiresponse.ApiResponse;
import com.example.Criteria_Builder.dto_classes.CommonDto;
import com.example.Criteria_Builder.entity.Admin;
import com.example.Criteria_Builder.repo.AdminRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private ApiResponse apiResponse;
    @PersistenceContext
    private EntityManager entityManager;

    public ApiResponse addAdmin(CommonDto commonDto) {
        try {
            Admin admin = new Admin();
            admin.setName(commonDto.getName());
            admin.setEmailID(commonDto.getEmailID());
            admin.setPassword(commonDto.getPassword());
            admin.setAge(commonDto.getAge());
            adminRepo.save(admin);
            apiResponse.setData(admin);
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("Admin Added Successfully");
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        return apiResponse;
    }

    public ApiResponse getAll() {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Admin> criteriaQuery = criteriaBuilder.createQuery(Admin.class);
            Root<Admin> root = criteriaQuery.from(Admin.class);
            criteriaQuery.select(root);
            List<Admin> admins = entityManager.createQuery(criteriaQuery).getResultList();
            apiResponse.setMessage("Below All Data");
            apiResponse.setData(admins);
            apiResponse.setStatus(HttpStatus.OK.value());
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        return apiResponse;
    }

    @Transactional
    public ApiResponse updateAdmin(CommonDto commonDto) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Admin> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Admin.class);
            Root<Admin> root = criteriaUpdate.from(Admin.class);
            criteriaUpdate.set(root.get("emailID"),commonDto.getEmailID());
            criteriaUpdate.where(criteriaBuilder.equal(root.get("name"), commonDto.getName())); // Condition
            entityManager.createQuery(criteriaUpdate).executeUpdate();

            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("Data Updated Successfully");
            apiResponse.setData(null);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        return apiResponse;
    }

    public ApiResponse getById(Long id) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Admin> criteriaQuery = criteriaBuilder.createQuery(Admin.class);
            Root<Admin> root  = criteriaQuery.from(Admin.class);
            criteriaQuery.where(criteriaBuilder.equal(root.get("id"),id));
          Admin admin =   entityManager.createQuery(criteriaQuery).getSingleResult();
           apiResponse.setData(admin);
           apiResponse.setStatus(HttpStatus.OK.value());
           apiResponse.setMessage("GetById List");
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
        return apiResponse;
    }

    public ApiResponse deleteById(Long id) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaDelete<Admin> criteriaDelete = criteriaBuilder.createCriteriaDelete(Admin.class);
            Root<Admin>root = criteriaDelete.from(Admin.class);
            apiResponse.setMessage("ID Fields Deleted Successfully");
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setData(null);
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
        return apiResponse;
    }
@Transactional
    public ApiResponse updateOneField(CommonDto commonDto) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaUpdate<Admin>criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Admin.class);
            Root<Admin> root = criteriaUpdate.from(Admin.class);
            criteriaUpdate.set(root.get("password"),commonDto.getPassword());
            criteriaUpdate.set(root.get("emailID"),commonDto.getEmailID());
            criteriaUpdate.where(criteriaBuilder.equal(root.get("name"),commonDto.getName()));
            entityManager.createQuery(criteriaUpdate).executeUpdate();
            apiResponse.setData(null);
            apiResponse.setStatus(HttpStatus.OK.value());
            apiResponse.setMessage("Data Updated Successfully");
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
        return apiResponse;
    }
}
