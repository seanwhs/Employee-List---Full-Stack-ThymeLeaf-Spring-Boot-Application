// EmployeeController.java
package directory.employee.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import directory.employee.model.Employee;
import directory.employee.repository.EmployeeRepository;

@Controller
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/List")
    public ModelAndView getAllEmployees(){
        ModelAndView modelAndView = new ModelAndView("list-employees");
        modelAndView.addObject("employees", employeeRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm(){
        ModelAndView modelAndView = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        modelAndView.addObject("employee", newEmployee);
        return modelAndView;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/List";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId){
        ModelAndView modelAndView = new ModelAndView("add-employee-form");
        Employee employee = employeeRepository.findById(employeeId).get();
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/deleteEmployee")
    public String deleEmployee(@RequestParam Long employeeId){
        employeeRepository.deleteById(employeeId);
        return "redirect:/List";
    }
}
