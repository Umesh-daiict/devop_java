package sun.dev.ijobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/all")
public class IjobController {
    @Autowired
    private IjobService jobservice;
    @GetMapping
    public ResponseEntity<List<Ijob>> geAllJobs(){
        return new ResponseEntity<List<Ijob>>(jobservice.allJobsData(), HttpStatus.OK);
    }
}
