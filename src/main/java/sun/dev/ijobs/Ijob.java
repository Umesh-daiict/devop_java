package sun.dev.ijobs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("jobs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ijob {
    @Id
    private ObjectId id;
    private Number job_type;
    private String type;
    private Date date;
    private Number version;
    private String country_code;
    private Boolean is_first;
    private Number _salary;
    private Number _year_exp;
    private List<String> _past_job_type;
    private String _company;
}
