package com.example.spring.controller;

import com.example.spring.dto.request.StudentRequest;
import com.example.spring.dto.response.MajorsResponse;
import com.example.spring.dto.response.SchoolResponse;
import com.example.spring.dto.response.StudentWorkResponse;
import com.example.spring.models.Student;
import com.example.spring.service.MajorsService;
import com.example.spring.service.SchoolService;
import com.example.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SchoolService schoolService;
    @Autowired
    private MajorsService majorsService;


    @GetMapping("/students/create")
    public String createStudentForm(Model model) {
        StudentRequest studentRequest = new StudentRequest();

        List<SchoolResponse> listOfSchools = schoolService.getAllSchools();
        List<MajorsResponse> listOfMajors = majorsService.getAllMajors();

        model.addAttribute("listOfSchools", listOfSchools);
        model.addAttribute("listOfMajors", listOfMajors);
        model.addAttribute("studentDto", studentRequest);

        return "students-create";
    }

    @PostMapping("/students/create")
    public String saveStudent(@Valid @ModelAttribute("studentDto") StudentRequest studentDto, BindingResult result,
                              Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("listOfSchools", schoolService.getAllSchools());
            model.addAttribute("listOfMajors", majorsService.getAllMajors());
            return "students-create";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Lưu thành công!");
        studentService.saveStudentForm(studentDto);
        return "redirect:/students/create";
    }

    @GetMapping("/students/get-list-student")
    public String getListStudents(Model model) {
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("students", studentList);
        return "search-students";
    }

    @GetMapping("/students/search-student")
    public String searchStudent(@RequestParam(value = "query") String query, Model model) {
        List<StudentRequest> studentRequests = studentService.searchStudents(query);
        model.addAttribute("students", studentRequests);
        return "search-students";
    }

    @GetMapping("/students/get-list-student-work")
    public String getListStudentWork(Model model) {
        List<StudentWorkResponse> studentWorkDtoList = studentService.getAllStudentWork();
        model.addAttribute("studentWorks", studentWorkDtoList);

        return "search-student-work";
    }

    @GetMapping("/students/search-student-work")
    public String searchListStudentWork(@RequestParam(value = "query") String query, Model model) {
        List<StudentWorkResponse> clubs = studentService.searchStudentWork(query);
        model.addAttribute("studentWorks", clubs);
        return "search-student-work";
    }
}
