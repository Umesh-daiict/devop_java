package sun.dev.ijobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IjobService {
    @Autowired
    private IjobsRepogistry jobrepogistry;
    public List<Ijob> allJobsData(){
        return jobrepogistry.findAll();
    }
}
