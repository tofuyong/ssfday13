package ibf2022.ssf.day13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.ssf.day13.model.Employee;
import ibf2022.ssf.day13.repository.EmployeeRepo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepo empRepo;

    @GetMapping("/home")
    public String employeeListPage(Model model) {
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);
        return "employeeslist";
    }

    @GetMapping("/addnew")
    public String addPage(Model model) {
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return "employeeadd";
    }

    @PostMapping("/addnew")
    public String addEmployee(@Valid @ModelAttribute("employee") Employee employeeForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "employeeadd";
        }

        //assuming no validation carried out
        Boolean bResult = false;
        bResult = empRepo.save(employeeForm);

        return "redirect:/employees/home";
    }

    @GetMapping("/deleteEmployee/{email}") //delete with path variable email
    public String delEmployee(@PathVariable("email") String email) {

        Employee emp = empRepo.findByEmailId(email); //this will return one employee object
        Boolean bResult = empRepo.delete(emp);
        return "redirect:/employees/home";
    }

}
