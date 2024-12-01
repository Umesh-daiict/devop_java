package sun.dev.ijobs;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IjobService {
    @Autowired
    private IjobsRepogistry jobrepogistry;

    public List<Ijob> allJobsData(){
        return jobrepogistry.findAll();
    }

    public Optional<Ijob> jobsDataById(ObjectId id){
        return jobrepogistry.findById(id);
    }

    public Optional<List<Ijob>> jobsByType(String type){
        return jobrepogistry.findAllIjobByType(type);
    }

    public Ijob addJobData(Ijob job){
        return jobrepogistry.insert(job);
    }

}
