package com.ics.demo;

import com.ics.demo.models.Appointment;
import com.ics.demo.models.Attachment;
import com.ics.demo.models.Movie;
import com.ics.demo.models.Student;
import feign.Param;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@FeignClient(name = "client", url = "http://10.51.10.111:2000", configuration = FeignConfig.class)
public interface FeignRestClient {

    @RequestMapping(method = RequestMethod.GET,value = "movies")
    List<Movie> getAllMovies();

    @RequestMapping(method = RequestMethod.GET,value = "movies/{id}")
    Movie findById(@PathVariable(name = "id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "movies")
    Movie createMovie(@RequestBody Movie movie);

    @RequestMapping(method = RequestMethod.PATCH, value = "movies/{id}")
    Movie update(@PathVariable("id") Long id,@RequestBody Movie movie);

    @RequestMapping(method = RequestMethod.POST, value = "students")
    Student createStudent(@RequestBody Student student);

    @RequestMapping(method = RequestMethod.GET, value = "students")
    Student viewStudent(@RequestParam(name = "studentName") Long studentNumber);

    @RequestMapping(method = RequestMethod.POST, value = "companies/{companyId}/attachments")
    Attachment createAttachment(@RequestBody Attachment attachment);
    //@RequestMapping(method = RequestMethod.PATCH,value = "companies/{companyId}/attachments")
    //Department RequestDepartment(@PathVariable("companyId") Long companyId,@RequestParam(name = "studentId") Long studentId,@RequestParam(name = "departmentId") Long departmentId);

    //@RequestMapping(method = RequestMethod.DELETE, value = "departments")
    //Department RejectDepartment(@RequestBody Department department);

    @RequestMapping(method = RequestMethod.POST, value = "companies/{companyId}/attachments")
    Attachment requestAttachment(@PathVariable int companyId, @RequestParam(name = "studentId")Integer studentId);
    @RequestMapping(method = RequestMethod.PATCH, value = "appointments/{appointmentId}")
    Appointment ConfirmAppointment(
            @PathVariable("appointmentId") Long id,
            @RequestParam(name = "studentId") Long studentId);

}
