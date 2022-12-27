package com.smartroom.backend.service;

import com.smartroom.backend.email.EmailSender;
import com.smartroom.backend.entity.Student;
import com.smartroom.backend.entity.StudentDetails;
import com.smartroom.backend.exception.InvalidParameter;
import com.smartroom.backend.model.StudentModel;
import com.smartroom.backend.model.StudentPredicationModelParams;
import com.smartroom.backend.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final PasswordEncoder passwordEncoder;

    private final EmailSender emailSender;

    private final RestTemplate restTemplate;


    @Autowired
    TeacherServiceImpl(TeacherRepository teacherRepository, PasswordEncoder passwordEncoder, EmailSender emailSender,RestTemplate restTemplate) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
        this.restTemplate = restTemplate;

    }

    @Override
    public StudentModel createStudent(Student student) throws Exception {
        try {
            String password = student.getPassword();
            System.out.println("Student password:- " + password);
            student.setPassword(passwordEncoder.encode(password));
            StudentModel savedStudent = teacherRepository.createStudent(student);
            String emailSubject = "User Id :- " +
                    student.getStudentId() + "\n" + "Password :- " + password;
            emailSender.sendEmail(savedStudent.getEmail(),emailSubject, "SmartRoom Credentials");
            return savedStudent;
        } catch (DuplicateKeyException e) {
            throw new DuplicateKeyException("Student with this id is already created");
        }
        catch (Exception e){

            throw new Exception(e.getLocalizedMessage());
        }

    }

    @Override
    public Student updateStudent(String studentId, StudentDetails studentDetails) throws Exception {

            Student student = getStudentById(studentId);
            student.setStudentDetails(studentDetails);
            return teacherRepository.updateStudent(student);

    }

    @Override
    public List<Student> fetchAllStudent() throws Exception {
        try {
            return teacherRepository.fetchAllStudent();
        }
        catch (Exception e){
            throw new Exception(e.getLocalizedMessage());
        }
    }

    @Override
    public Integer predictResult(String studentId, Student subject) throws Exception {
        Student student = getStudentById(studentId);
        HashMap<String, ArrayList<Integer>> studentMarks = student.getStudentDetails().getStudentMarks();
        if(!studentMarks.containsKey(subject) && !subject.equals("overall")){
            throw new InvalidParameter("Invalid subject,Subject not available");
        }
        else{
            ArrayList<Integer> totalMarks = new ArrayList<>();
            if(studentMarks.containsKey(subject)){
               totalMarks = studentMarks.get(subject);
            }
            else{
                totalMarks = getTotalMarks(studentMarks);
            }
            StudentPredicationModelParams modelParams = getModelParams(student.getStudentDetails(),totalMarks);
            try {

                return getPrediction(modelParams);
            }
            catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }
    }

    @Override
    public Student getStudentById(String studentId) throws Exception {
       try {
           return teacherRepository.getStudentById(studentId);
       }
       catch (UsernameNotFoundException e){
           throw new UsernameNotFoundException("Student with id:- " + studentId +" not found");
       }
    }

    private StudentPredicationModelParams getModelParams(StudentDetails studentDetails,ArrayList<Integer> totalMarks) {
         StudentPredicationModelParams modelParams = new StudentPredicationModelParams();
         modelParams.setSex(studentDetails.getSex());
         modelParams.setAge(studentDetails.getAge());
         modelParams.setAddress(studentDetails.getAddress());
         modelParams.setFamsize(studentDetails.getFamilySize());
         modelParams.setPstatus(studentDetails.getParentStatus());
         modelParams.setMedu(studentDetails.getMotherEducation());
         modelParams.setFedu(studentDetails.getFatherEducation());
         modelParams.setMjob(studentDetails.getMotherJob());
         modelParams.setFjob(studentDetails.getFatherJob());
         modelParams.setTraveltime(studentDetails.getTravelTime());
         modelParams.setStudytime(studentDetails.getStudyTime());
         modelParams.setFailures(studentDetails.getFailures());
         modelParams.setSchoolsup(studentDetails.getSchoolSupport());
         modelParams.setFamsup(studentDetails.getFamilySupport());
         modelParams.setPaid(studentDetails.getExtraPaidClasses());
         modelParams.setActivities(studentDetails.getExtraCurricularActivities());
         modelParams.setNursery(studentDetails.getNurseryEducation());
         modelParams.setHigher(studentDetails.getHigherEducation());
         modelParams.setInternet(studentDetails.getInternet());
         modelParams.setFamrel(studentDetails.getFamilyRelationship());
         modelParams.setFreetime(studentDetails.getFreeTime());
         modelParams.setHealth(studentDetails.getHealth());
         modelParams.setAbsences(studentDetails.getAbsences());
         modelParams.setG1(totalMarks.get(0));
         modelParams.setG2(totalMarks.get(1));

         return modelParams;

    }

    private Integer getPrediction(StudentPredicationModelParams modelParams) throws Exception {
        String url = "";
        HttpEntity<StudentPredicationModelParams> request = new HttpEntity<>(modelParams);
        ResponseEntity<Integer> response = restTemplate.exchange(url , HttpMethod.POST,request , Integer.class);
        if(response.getStatusCode() != HttpStatus.OK){
            throw new Exception("Unable to predict result try again later");
        }
        else{
            return response.getBody();
        }
    }

    private ArrayList<Integer> getTotalMarks(HashMap<String, ArrayList<Integer>> studentMarks) {
      ArrayList<Integer> totalMarks = new ArrayList<>();
      int term1 = 0, term2 = 0;
      for (Map.Entry entry : studentMarks.entrySet()){
          ArrayList<Integer> marks = (ArrayList<Integer>) entry.getValue();
          term1+=marks.get(0);
          term2+=marks.get(1);
      }
      totalMarks.add(term1);
      totalMarks.add(term2);

      return totalMarks;

    }
}
