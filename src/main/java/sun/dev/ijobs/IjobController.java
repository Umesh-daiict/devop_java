package sun.dev.ijobs;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/api/v1/jobs")
public class IjobController {
    @Autowired
    private IjobService jobservice;
    @GetMapping
    public ResponseEntity<List<Ijob>> geAllJobs(){
        return new ResponseEntity<List<Ijob>>(jobservice.allJobsData(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Ijob>> geJobById(@PathVariable ObjectId id){
//        return new ResponseEntity<Optional<Ijob>>(jobservice.jobsDataById(id), HttpStatus.OK);
//    }


    @GetMapping("/{type}")
    public ResponseEntity<Optional<List<Ijob>>> getJobByType(@PathVariable String type){
        return new ResponseEntity<Optional<List<Ijob>>>(jobservice.jobsByType(type), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ObjectId> createJob(@RequestBody Map<String,String> payload){
        Ijob jobdata = new Ijob();
        jobdata.setJob_type(Integer.valueOf(payload.get("job_type")));
        jobdata.setType(payload.get("type"));
        jobdata.setDate(new Date(0));
        jobdata.setVersion(1);
        jobdata.setIs_first(Boolean.valueOf(payload.get("is_first")));
        jobdata.set_salary(Integer.valueOf(payload.get("salary")));
        jobdata.set_year_exp(Integer.valueOf(payload.get("year_exp")));
        jobdata.set_company(payload.get("company"));

        jobdata = jobservice.addJobData(jobdata);
        return new ResponseEntity<ObjectId>(jobdata.getId(), HttpStatus.CREATED);
    }}
